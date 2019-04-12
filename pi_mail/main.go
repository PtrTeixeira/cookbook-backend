package main

import (
  "bytes"
	"context"
	"encoding/json"
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

func getClient(tokFile string, config *oauth2.Config) *http.Client {
	tok, err := tokenFromFile(tokFile)
	if err != nil {
		tok = getTokenFromWeb(config)
		saveToken(tokFile, tok)
	}
	return config.Client(context.Background(), tok)
}

func getTokenFromWeb(config *oauth2.Config) *oauth2.Token {
	authURL := config.AuthCodeURL("state-token", oauth2.AccessTypeOffline)
	fmt.Printf("Go here: \n%v\n", authURL)

	var authCode string
	if _, err := fmt.Scan(&authCode); err != nil {
		log.Fatalf("Could not read auth code")
	}

	tok, err := config.Exchange(context.TODO(), authCode)
	if err != nil {
		log.Fatalf("Unable to retrieve token from web: %v", err)
	}
	return tok
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

func getMessage(srv *gmail.Service, userId string, messageId string) (*gmail.Message, error) {
	return srv.Users.Messages.Get(userId, messageId).Do()
}

func getSubject(message *gmail.Message) string {
	payload := message.Payload
	if payload == nil {
		log.Fatalf("Retrieved message %v had no body\n", message.Raw)
	}

	headers := payload.Headers
	if headers == nil {
		log.Fatalf("Retrieved message %v had no body\n", message.Raw)
	}

	for _, header := range headers {
		if header.Name == "Subject" {
			return header.Value
		}
	}

	return ""
}

func getMostRecentHistoryId(srv *gmail.Service, userId string) uint64 {
	r, err := srv.Users.Messages.List(userId).MaxResults(1).Do()
	if err != nil {
		log.Fatalf("Failed to retrieve recent messages %v\n", err)
	}

	for _, m := range r.Messages {
		message, err := getMessage(srv, userId, m.Id)
		if err != nil {
			log.Fatalf("Failed to retrieve message %v due to %v\n", m.Id, err)
		}

		return message.HistoryId
	}

	log.Fatalf("Could not get most recent history ID")
	return 0
}

// First result = has new messages since
// second result = most recently seen history ID
func hasMessagesSince(srv *gmail.Service, userId string, historyId uint64) (bool, uint64) {
	r, err := srv.Users.History.List(userId).HistoryTypes("messageAdded").StartHistoryId(historyId).Do()
	if err != nil {
		log.Fatalf("Could not get message history due to %v\n", err)
	}

	newHistoryId := r.HistoryId
	hasResults := (len(r.History) > 0)
	return hasResults, newHistoryId
}

func main() {
	usr, err := user.Current()
	var defaultCredentials, defaultTokFile string
	if err != nil {
		defaultCredentials = ""
		defaultTokFile = ""
	}
	homeDir := usr.HomeDir

	defaultCredentials = filepath.Join(homeDir, "credentials.json")
	defaultTokFile = filepath.Join(homeDir, "token.json")
	credentials := flag.StringP("credentials", "c", defaultCredentials, "Saved credentials file")
	tokFile := flag.StringP("token", "t", defaultTokFile, "Saved token file")
	execString := flag.StringP("exec", "e", "", "Command to execute for each message")
	flag.Parse()
	fmt.Printf("Exec string: %v\n", *execString)

	b, err := ioutil.ReadFile(*credentials)
	if err != nil {
		log.Fatalf("Unable to read client secret: %v\n", err)
	}

	config, err := google.ConfigFromJSON(b, gmail.GmailReadonlyScope)
	if err != nil {
		log.Fatalf("Unable to parse client secret: %v\n", err)
	}
	client := getClient(*tokFile, config)

	srv, err := gmail.New(client)
	if err != nil {
		log.Fatalf("Unable to get Gmail client: %v\n", err)
	}

	user := "me"
	historyId := getMostRecentHistoryId(srv, user)
	hasMessages := false

	ticker := time.NewTicker(30 * time.Second)
	quit := make(chan os.Signal, 1)
	signal.Notify(quit, os.Interrupt)

outer:
	for {
		select {
		case <-ticker.C:
			hasMessages, historyId = hasMessagesSince(srv, user, historyId)
			fmt.Printf("Has messages since %v: %v\n", historyId, hasMessages)
			cmd := exec.Command("bash", "-c", *execString)
			var out bytes.Buffer
			cmd.Stdout = &out
			err := cmd.Run()
			if err != nil {
				log.Fatal(err)
			}
			fmt.Printf("Result: %v\n", out.String())

		case <-quit:
			break outer
		}
	}
	ticker.Stop()
}
