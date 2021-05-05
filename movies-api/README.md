# Movies-api
- Basic CRUD functionality to manage movies collections.
 ✨ ✨

## Features
- Show all the movies list collection.
- Show already watched movies list.
- Add a new movie with details such as name, movie poster ur and any comments.
- Mark/update movie as watched.
- Once added to watched list, duplicates can not be added.
- Delete movie from the store or collection.

This application holds backend part only: backend service written using Java and Spring boot framework mainly.

## Tech

- [Spring boot] - Backend service.
- [H2] - to persist data into in memory db
- [Swagger ui] - A super cool UI for backend endpoints testing or interaction.

## Installation

Backend requires Java SDK 11, Maven build tool version 3.6.2 to build and run.

Install the dependencies and devDependencies and start the server.

```sh
cd movies-api
mvn clean install
mvn sping-boot:run
```

Once we start the applications locally, backend is available on [http://localhost:8080/swagger-ui.html]

