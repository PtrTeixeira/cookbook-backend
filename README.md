Cookbook Backend
================

> Boring line-of-business application for storing recipes

Simplest RESTful application in the world, just a 
wrapper around interactions with a database.

License: MIT.

This is largely intended for _me_ to run on an infrastructure provider 
(eg, DigitalOcean), but I am working to make sure that it can be reasonably 
run locally ([self-hosted](https://github.com/Kickball/awesome-selfhosted)) as well.

Table of Contents
-----------------
1. [Usage](#usage)
1. [Development](#development)
1. [Running the Server](#running-the-server)
1. [Configuration](#configuration)
1. [How I run the application with Docker](#how-i-run-the-application-with-docker)

Usage
-----
At the moment, there isn't a binary distribution of this project. Eventually, it 
will be distributed as a Docker image. To build the Docker image, see the 
[Development](#Development) section. 


Development
-----------
The project is built using Gradle, with the wrapper file checked in to the repo. 
Assuming that you have Java 1.8+ installed, you can work on this project just by 
running `./gradlew` in the root directory of the project.

If you are familiar with [Dropwizard](https://dropwizard.io), you will be very 
comfortable with this project. 

* To run tests: `./gradlew check`. If you are a TDD kind of person, 
  `./gradlew check -t` will re-run the tests on file changes.
* If you see style violations as a result of the tests, you can use 
  `./gradlew spotlessApply` to fix them.
* To compile a binary that you can run, use `./gradlew install`. The shell script 
  to start the server will be put at `$rootDir/server/build/install/server/bin/server`.
* To build a Docker image, use `./gradlew dockerBuildImage`. This will build an image 
  named `ptrteixeira/cookbook:...`.
  
  
Running the Server
------------------
Starting the server looks something like `server server cookbook.yml`, where 
* the first `server` is the name of the binary
* the second `server` is the Dropwizard CLI command to start the server
* `cookbook.yml` is the config file.

The server listen on two ports. The primary, user-facing port is `8080`. It has 
the following endpoints:
`GET /recipes` - list all recipes accessible to the signed-in user
`POST /recipes` - create a recipe. Will return the recipe, along with its generated ID
`GET /recipes/:id` - get the recipe with the given ID
`PUT /recipes/:id`- Update the recipe with the given ID
`DELETE /recipes/:id` - Delete the recipe with the given ID

All of these resources are protected by an authentication scheme, which at the moment 
is unfortunately sub-par. You need to register the application as a client with Google and 
use the web-flow scheme in order to get a JWT. You can then pass the JWT to the application
with the header `Authorization: Bearer <Token>`. Not that the JWT expires and is 
rotated pretty quickly on Google's end, so this is not great for any kind of automated 
work. To see more about how Google handles the web-flow for auth, you can look 
at [Google's guide](https://developers.google.com/identity/sign-in/web/devconsole-project) and 
related pages. The way that I've been handling it thus far is to create a webpage that
only has a "sign-in" button, pulling the token off of that, and copying it into 
curl requests.

The other port is the admin port. There are only the default Dropwizard tasks:
one is to change the log level of a logger and the other is to manually request a 
GC. I have yet to use either of these at the moment.

Logging is to stdout, as per 12-Factor principles. If you set the application up 
with Docker or with the init system, there will be other tools available to 
handle logging for you.

Configuration
-------------

An example configuration file is located at `cookbook.yml`, in the root of the 
project directory. At this point, the Docker image does _not_ contain the 
configration file, so you will need to pass it in on your own (and pass in 
the command-line arguments, also). You can probably just use the supplied 
config file, which is set up to be configurable with environment variables, 
as per 12-factor principles. 

Properties configurable with environment variables:


| Property Name | Environment Variable | Default Value | Description |
|---------------|----------------------|---------------|-------------|
| baseUrl       | COOKBOOK_BASE_URL    | http://localhost:8080 | URL at which server will be accessed. |
| database.driverClass | DB_DRIVER_CLASS | org.h2.Driver | JDBC Driver class. If you change this to something other than H2, you will need to put the jar on the classpath yourself. |
|database.user | DB_USER | sa | Username for database connection. Irrelvant for H2 |
|database.password | DB_PASSWORD | sa | Password for database connection. Irrelevant for H2 |
|database.url | DB_JDBC_URL | jdbc:h2:./db | URL for JDBC connection. Must include "jdbc" and database protocol |
|autoRunMigration| AUTO_RUN_MIGRATION | no | Whether to run the database migration when the application starts. This is mstly to handle starting the Docker image with no pre-initialized database |
|oauthConfig.clientId|COOKBOOK_CLIENT_ID| <none> | Client ID for working with Google APIs. See [Google's guide](https://developers.google.com/identity/sign-in/web/devconsole-project)|


How I run the application with Docker
--------------------------------------

This is my one-liner to start the application. It works for my needs, but I don't know 
if it will work for yours. I am going to work on making this easier to deal with in 
a future release, I promise.

```bash
docker run -p 8080:8080 -p 8081:8081 -v "$PWD/cookbook.yml":/cookbook.yml -e COOKBOOK_CLIENT_ID:<redacted> ptrteixeira/cookbook:0.2.2 server /cookbook.yml

```
```
