# gmaild

GmailD is a daemon that will execute commands each time that you 
receive an email in gmail.

For example, `gmaild -e 'echo hello'` will execute 'echo hello' 
each time that you receive an email.

To set this up, you will need to to create a credientials file
in your home directory, following the directions [here](https://developers.google.com/gmail/api/quickstart/go#step_1_turn_on_the). After that, it
will poll for events from gmail and execute given command.

## Should I use this?

Absolutely not. For a while my use-case was doing something like
`gmaild -e 'notify-send "received email"'`, which, like, works, 
but also isn't the most helpful thing in the world. Currently this 
doesn't pass anything about the message to the command, which was
something that I always planned on doing - like an email CGI 
interface. Anyways, I haven't gotten that done, the process is 
kinda crap, and this whole thing is badly implemented. 

This was my first effort at learning go, though, and for that it
wasn't too bad.
