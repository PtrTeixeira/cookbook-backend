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

func getClient(tokFile string, config *oauth2.Config) *http.Client {
	tok, err := tokenFromFile(tokFile)
	if err == nil {
		return config.Client(context.Background(), tok)
	}

	tok, err = getTokenFromWeb(config)
	if err != nil {
		log.Fatalf("Could not get auth token from gmail: %v", err)
	}
	saveToken(tokFile, tok)
	return config.Client(context.Background(), tok)
}

func getTokenFromWeb(config *oauth2.Config) (*oauth2.Token, error) {
	authURL := config.AuthCodeURL("state-token", oauth2.AccessTypeOffline)
	fmt.Printf("Go here: \n%v\n", authURL)

	var authCode string
	if _, err := fmt.Scan(&authCode); err != nil {
		msg := fmt.Sprintf("Could not read auth code: %v", err)
		return nil, errors.New(msg)
	}

	tok, err := config.Exchange(context.TODO(), authCode)
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

// First result = has new messages since
// second result = most recently seen history ID
func hasMessagesSince(srv *gmail.Service, userID string, historyID uint64) (bool, uint64) {
	r, err := srv.Users.History.List(userID).HistoryTypes("messageAdded").StartHistoryId(historyID).Do()
	if err != nil {
		log.Fatalf("Could not get message history due to %v\n", err)
	}

	newHistoryID := r.HistoryId
	hasResults := (len(r.History) > 0)
	return hasResults, newHistoryID
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

	if len(arguments) <= 1 {
		// Clearly this is buggy crap
		defaultCommand.PrintDefaults()
		return nil, errors.New("Invalid command string format")
	}

	defaultCommand.Parse(arguments[1:])
	config := GmaildConfig{
		CredFile:   *credFile,
		TokFile:    *tokFile,
		ExecString: *exec,
	}

	return &config, nil
}

func main() {
	usr, err := user.Current()
	// var defaultCredentials, defaultTokFile string
	if err != nil {
		log.Fatalf("Could not determine current user %v\n", err)
		// defaultCredentials = ""
		// defaultTokFile = ""
	}
	// var credentials, tokFile, execString string
	gmaildConfig, err := parseCommandLine(usr, os.Args)
	if err != nil {
		os.Exit(1)
	}

	fmt.Printf("Exec string: %v\n", gmaildConfig.ExecString)

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

	hasMessages := false
	ticker := time.NewTicker(30 * time.Second)
	quit := make(chan os.Signal, 1)
	signal.Notify(quit, os.Interrupt)

outer:
	for {
		select {
		case <-ticker.C:
			hasMessages, historyID = hasMessagesSince(srv, user, historyID)
			fmt.Printf("Has messages since %v: %v\n", historyID, hasMessages)
      if hasMessages {
        cmd := exec.Command("bash", "-c", gmaildConfig.ExecString)
        var out bytes.Buffer
        cmd.Stdout = &out
        err := cmd.Run()
        if err != nil {
          log.Fatal(err)
        }
        fmt.Printf("Result: %v\n", out.String())
      }
		case <-quit:
			break outer
		}
	}
	ticker.Stop()
}
