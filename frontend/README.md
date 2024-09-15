![image](https://github.com/DanielEspanadero/diverger-java-full-stack-test-app/blob/develop/docs/frontend.png)

## Starting 🚀
_These instructions will allow you to get a working copy of the project on your local machine for development and testing purposes._

### Pre-requisites 📋
_For the project to work correctly, it is recommended to have a series of programs installed and configured properly:_
- [WebStorm](https://www.jetbrains.com/webstorm/)
-
_If you want to run it from a local machine:_
- [NodeJS](https://openjdk.org/projects/jdk/17/)
- [React](https://react.dev/)
- [TypeScript](https://www.typescriptlang.org/)

_If you prefer to use containers:_
- [Docker](https://www.docker.com/)

_Once you have all this installed, you can make a clone of this repository:_

```
git clone https://github.com/DanielEspanadero/diverger-java-full-stack-test-app.git
```

_This documentation corresponds to the frontend part, so you must enter the 'fronend' path to be able to run the project:_

### Compile the project and run the tests:

```bash
npm run build
```

## Local Execution
### Run the application:

```bash
npm run dev
```

Access the application: The application will be available at http://localhost:5173.

## Docker

### Build the Docker image:

```bash
docker build -t my-react-app .
```

Run the Docker container:

```bash
docker run -p 5173:80 my-react-app
```

## Docker Compose

_Running docker compose will allow you to start the backend and the frontend at the same time. Remember to run the commands in the main path (not in the frontend folder or in the backend folder)._

Run the Docker Compose:

```bash
docker-compose up --build
```

Down the Docker Compose:

```bash
docker-compose down
```

## Author ✒️
* [Daniel Españadero Fernández](https://github.com/DanielEspanadero) - *Complete project*
