package main

import (
	"bytes"
	"context"
	"encoding/json"
	"errors"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"os/exec"
	"os/signal"
	"os/user"
	"path/filepath"
	"strings"
	"time"

	flag "github.com/spf13/pflag"
	"golang.org/x/oauth2"
	"golang.org/x/oauth2/google"
	"google.golang.org/api/gmail/v1"
)

// GmaildConfig is the format for the gmaild daemon
type GmaildConfig struct {
	// The file path to credentials file
	// defaults to $HOME/credentials.json
	CredFile string
	// The file path to the token file
	// defaults to $HOME/token.json
	TokFile string
	// The command to get executed on new messages
	ExecString string
}

// A MessageEvent is a wrapper for each message received
// when checking for gmail events
type MessageEvent struct {
	// The receieved email associated with the message event
	MessageAdded gmail.Message
}

type cliError struct {
	errorMessage  string
	usage         string
	helpRequested bool
}

func (c *cliError) Error() string {
	if c.helpRequested {
		return fmt.Sprintf("Usage:\n%s", c.usage)
	}
	return fmt.Sprintf("Error: %s\n\nUsage:\n%s", c.errorMessage, c.usage)
}

func getClient(tokFile string, config *oauth2.Config) *http.Client {
	tok, err := tokenFromFile(tokFile)
	if err == nil {
		return config.Client(context.Background(), tok)
	}

	tok, err = getTokenFromWeb(context.TODO(), config)
	if err != nil {
		log.Fatalf("Could not get auth token from gmail: %v", err)
	}
	saveToken(tokFile, tok)
	return config.Client(context.Background(), tok)
}

func getTokenFromWeb(context context.Context, config *oauth2.Config) (*oauth2.Token, error) {
	authURL := config.AuthCodeURL("state-token", oauth2.AccessTypeOffline)
	fmt.Printf("Go here: \n%v\n", authURL)

	var authCode string
	if _, err := fmt.Scan(&authCode); err != nil {
		msg := fmt.Sprintf("Could not read auth code: %v", err)
		return nil, errors.New(msg)
	}

	tok, err := config.Exchange(context, authCode)
	if err != nil {
		msg := fmt.Sprintf("Unable to retrieve token from web: %v", err)
		return nil, errors.New(msg)
	}
	return tok, nil
}

func tokenFromFile(file string) (*oauth2.Token, error) {
	f, err := os.Open(file)
	if err != nil {
		return nil, err
	}
	defer f.Close()

	tok := &oauth2.Token{}
	err = json.NewDecoder(f).Decode(tok)
	return tok, err
}

func saveToken(path string, token *oauth2.Token) {
	fmt.Printf("Saving credential file to %s\n", path)
	f, err := os.OpenFile(path, os.O_RDWR|os.O_CREATE|os.O_TRUNC, 0600)
	if err != nil {
		log.Fatalf("Unable to cache auth token: %s\n", err)
	}
	defer f.Close()

	json.NewEncoder(f).Encode(token)
}

func getMessage(srv *gmail.Service, userID string, messageID string) (*gmail.Message, error) {
	return srv.Users.Messages.Get(userID, messageID).Do()
}

func getMostRecentHistoryID(srv *gmail.Service, userID string) (uint64, error) {
	r, err := srv.Users.Messages.List(userID).MaxResults(1).Do()
	if err != nil {
		return 0, err
	}

	for _, m := range r.Messages {
		message, err := getMessage(srv, userID, m.Id)
		if err != nil {
			continue
		}

		return message.HistoryId, nil
	}

	return 0, errors.New("Could not get the most recent history ID")
}

// First result = most recently seen history ID
// second result = Any messages since last update
func hasMessagesSince(srv *gmail.Service, userID string, historyID uint64) (uint64, []MessageEvent) {
	r, err := srv.Users.History.List(userID).HistoryTypes("messageAdded").StartHistoryId(historyID).Do()
	if err != nil {
		log.Fatalf("Could not get message history due to %v\n", err)
	}

	newHistoryID := r.HistoryId
	result := make([]MessageEvent, 0)
	for _, h := range r.History {
		for _, messageAdded := range h.MessagesAdded {
			message, err := getMessage(srv, userID, messageAdded.Message.Id)
			if err != nil {
				fmt.Printf("Could not get message from server: %v\n", err)
				continue
			}

			messageEvent := MessageEvent{
				MessageAdded: *message,
			}

			result = append(result, messageEvent)
		}
	}

	return newHistoryID, result
}

func parseCommandLine(
	usr *user.User,
	arguments []string,
) (*GmaildConfig, error) {
	homeDir := usr.HomeDir
	defaultCredentials := filepath.Join(homeDir, "credentials.json")
	defaultTokFile := filepath.Join(homeDir, "token.json")

	defaultCommand := flag.NewFlagSet("gmaild", flag.ExitOnError)
	credFile := defaultCommand.StringP(
		"credentials",
		"c",
		defaultCredentials,
		"Saved credentials file")
	tokFile := defaultCommand.StringP("token", "t", defaultTokFile, "Saved token file")
	exec := defaultCommand.StringP("exec", "e", "", "Command to execute for each message")
	help := defaultCommand.BoolP("help", "h", false, "Print usage")

	defaultCommand.Parse(arguments[1:])

	if *help {
		return nil, &cliError{
			errorMessage:  "Help requested",
			usage:         defaultCommand.FlagUsages(),
			helpRequested: true,
		}
	}

	if len(*exec) == 0 {
		return nil, &cliError{
			errorMessage:  "Exec command (-e / --exec) must be set",
			usage:         defaultCommand.FlagUsages(),
			helpRequested: false,
		}
	}

	config := GmaildConfig{
		CredFile:   *credFile,
		TokFile:    *tokFile,
		ExecString: *exec,
	}
	return &config, nil
}

func getNewMessages(
	srv *gmail.Service,
	userID string,
	startHistoryID uint64) <-chan MessageEvent {
	messageEventChan := make(chan MessageEvent)

	historyID := startHistoryID
	go func() {
		ticker := time.NewTicker(30 * time.Second)
		for range ticker.C {
			var messages []MessageEvent
			oldHistoryID := historyID
			historyID, messages = hasMessagesSince(srv, userID, historyID)
			fmt.Printf("Checking for messages between %v -> %v\n", oldHistoryID, historyID)
			for _, message := range messages {
				messageEventChan <- message
			}
		}
		close(messageEventChan)
	}()

	return messageEventChan
}

func main() {
	usr, err := user.Current()
	if err != nil {
		log.Fatalf("Could not determine current user %v\n", err)
	}

	gmaildConfig, err := parseCommandLine(usr, os.Args)
	if err != nil {
		fmt.Fprintf(os.Stderr, "%v\n", err)
		os.Exit(1)
	}

	b, err := ioutil.ReadFile(gmaildConfig.CredFile)
	if err != nil {
		log.Fatalf("Unable to read client secret: %v\n", err)
	}

	config, err := google.ConfigFromJSON(b, gmail.GmailReadonlyScope)
	if err != nil {
		log.Fatalf("Unable to parse client secret: %v\n", err)
	}

	client := getClient(gmaildConfig.TokFile, config)
	srv, err := gmail.New(client)
	if err != nil {
		log.Fatalf("Unable to get Gmail client: %v\n", err)
	}

	user := "me"
	historyID, err := getMostRecentHistoryID(srv, user)
	if err != nil {
		log.Fatal(err)
	}

	messageChannel := getNewMessages(srv, user, historyID)
	quit := make(chan os.Signal, 1)
	signal.Notify(quit, os.Interrupt)

outer:
	for {
		select {
		case message := <-messageChannel:
			cmd := exec.Command("bash", "-c", gmaildConfig.ExecString)

			in := strings.NewReader(message.MessageAdded.Snippet)
			var out bytes.Buffer
			cmd.Stdout = &out
			cmd.Stdin = in
			err := cmd.Run()
			if err != nil {
				log.Fatal(err)
			}
			fmt.Printf("Result: %v\n", out.String())
		case <-quit:
			break outer
		}
	}
}
