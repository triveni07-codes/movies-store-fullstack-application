# Movies-app
## Movies collection managing full-stack application
- Basic CRUD functionality to manage movies collections.
 ✨ ✨

## Features
- Show all the movies list collection.
- Show already watched movies list.
- Add a new movie with details such as name, movie poster ur and any comments.
- Click on movie image from movies collection and mark it as watched.
- Once added to watched list, duplicates can not be added.
- Click on already watched and delete it from the store or collection.(Not so perfect, however it just holds delete functionality for now.)
- Hover effect on images to show comments as dynamic display.
- Responsive web page.(Can be improved more with media queries)

This application holds two parts: one as backend service written using Java and Spring boot framework mainly. 
Second is frontend written using React framework.

## Tech

- [React with react hooks] - web app!
- [Material ui] - great UI boilerplate for modern web apps
- [Axios] - fetch api to interact with backend data
- [Spring boot] - Backend service.
- [H2] - to persist data into in memory db
- [Swagger ui] - A super cool UI for backend endpoints testing or interaction.

Front end feature is available under `movies-store-app` directory.
And backend service is available under `movies-api` directory.

## Installation

Backend requires Java SDK 11, Maven build tool version 3.6.2 to build and run.

Install the dependencies and devDependencies and start the server.

```sh
cd movies-api
mvn clean install
mvn sping-boot:run
```

Frontend requires [Node.js](https://nodejs.org/) installed to run.

Install the dependencies and devDependencies and start the server.

```sh
cd movies-store-app
npm install
npm start
```

Once we start both the applications locally, backend is available on [http://localhost:8080/swagger-ui.html]
and fronted is available on [http://localhost:3000/].
The connection between both the applications is done by using "CrossOrigin" in backend server and
setting up "proxy" in frontend. Full-stack application is available on [http://localhost:3000/].

There is lot of scope to improve, however this is a good start. ✨ ✨

## License

MIT
**Free Software, Yeah!!**
