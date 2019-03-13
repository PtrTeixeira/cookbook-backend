Cookbook Backend
================

> Boring line-of-business application for storing recipes

Simplest RESTful application in the world, just a 
wrapper around interactions with a database.


This is largely intended for _me_ to run on an infrastructure provider 
(eg, DigitalOcean), but I am working to make sure that it can be reasonably 
run locally ([self-hosted](https://github.com/Kickball/awesome-selfhosted)) as well.

Table of Contents
-----------------
1. [Usage](#usage)
1. [Development](#development)
1. [Running the Server](#running-the-server)
1. [Configuration](#configuration)

Usage
-----
At the moment, there isn't a binary distribution of this project. Eventually, it 
will be distributed as a Docker image. To build the Docker image, see the 
[Development](#Development) section. 


Development
-----------

This project is built with [Dropwizard](https://dropwizard.io), and 
not a lot else. The endpoints files are all within the `resources` 
package in the `server` directory. The `model` directory contains some 
plain-old Kotlin (data) classes in the REST API, like `User` and `Recipe`.

* To run tests: `bazel test //cookbook/...` (or, in this directory, `bazel test ...`)
* To build a jar: `bazel build //cookbook/server`
  
  
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
is unfortunately (very) sub-par. In particular, your `token` is your username. 
\shrug

The other port is the admin port. There are only the default Dropwizard tasks:
one is to change the log level of a logger and the other is to manually request a 
GC. I have yet to use either of these at the moment.

Logging is to stdout, as per 12-Factor principles. If you set the application up 
with Docker or with the init system, there will be other tools available to 
handle logging for you.

Configuration
-------------

An example configuration file is located at `cookbook.yml`, in the root of the 
repo. You can (and probably should) use environment variables to actually 
conrol it, if you eg run it in a docker image.

Properties configurable with environment variables:


| Property Name | Environment Variable | Default Value | Description |
|---------------|----------------------|---------------|-------------|
| baseUrl       | `COOKBOOK_BASE_URL`    | http://localhost:8080 | URL at which server will be accessed. |
| database.driverClass | `DB_DRIVER_CLASS` | org.h2.Driver | JDBC Driver class. If you change this to something other than H2, you will need to put the jar on the classpath yourself. |
|database.user | `DB_USER` | sa | Username for database connection. Irrelvant for H2 |
|database.password | `DB_PASSWORD` | sa | Password for database connection. Irrelevant for H2 |
|database.url | `DB_JDBC_URL` | jdbc:h2:$HOME/cookbook-db | URL for JDBC connection. Must include "jdbc" and database protocol |

