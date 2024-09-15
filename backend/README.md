![image](https://github.com/DanielEspanadero/diverger-java-full-stack-test-app/blob/develop/docs/backend.png)

## Starting 🚀
_These instructions will allow you to get a working copy of the project on your local machine for development and testing purposes._

### Pre-requisites 📋
_For the project to work correctly, it is recommended to have a series of programs installed and configured properly:_
- [IntelliJ](https://www.jetbrains.com/idea/)
- 
_If you want to run it from a local machine:_
- [OpenJDK17](https://openjdk.org/projects/jdk/17/)
- [Gradle](https://gradle.org/)

_If you prefer to use containers:_
- [Docker](https://www.docker.com/)

_Once you have all this installed, you can make a clone of this repository:_

```
git clone https://github.com/DanielEspanadero/diverger-java-full-stack-test-app.git
```

_This documentation corresponds to the backend part, so you must enter the 'backend' path to be able to run the project:_

### Compile the project and run the tests:

```bash
./gradlew build
```

## Local Execution
### Run the application:

```bash
./gradlew bootRun
```

Access the application: The application will be available at http://localhost:8080.

## Docker

### Build the Docker image:

```bash
docker build -t starwars-app .
```

Run the Docker container:

```bash
docker run -p 8080:8080 starwars-app
```

## Endpoints

GET `/swapi-proxy/person-info?name={name}`: Retrieve information about a Star Wars character.
GET `/actuator`: Get information about available endpoints.
GET `/actuator/caches`: Get information about available caches.
GET `/swagger-ui.html`: Swagger documentation.

## Author ✒️
* [Daniel Españadero Fernández](https://github.com/DanielEspanadero) - *Complete project*
