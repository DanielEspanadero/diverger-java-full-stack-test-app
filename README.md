![image](https://github.com/DanielEspanadero/diverger-java-full-stack-test-app/blob/develop/docs/technical-test.png)

_Link to the different documentations (Backend and Frontend):_
- [Backend](https://github.com/DanielEspanadero/diverger-java-full-stack-test-app/blob/develop/backend/README.md)
- [Frontend](https://github.com/DanielEspanadero/diverger-java-full-stack-test-app/blob/develop/frontend/README.md)


## Fundamentals

### Backend Project

* The API will consume other REST endpoints to obtain information. Specifically, it will rely on the services found at `Swapi`: [https://swapi.dev](https://swapi.dev)
* Using the necessary endpoints, the task is to create a REST interface that accepts a single request of the type:

```sh
http://{host}:{port}/swapi-proxy/person-info?name=Luke%20Skywalker
```

* Upon receiving a request like this, the application should return a JSON containing the following information and structure:

```json
{
  "name": "Luke Skywalker",
  "birth_year": "19BBY",
  "gender": "male",
  "planet_name": "Tatooine",
  "fastest_vehicle_driven": "X-wing",
  "films": [
    {
      "name": "A New Hope",
      "release_date": "1977-05-25"
    },
    {
      "name": "The Empire Strikes Back",
      "release_date": "1980-05-17"
    },
    {
      "name": "Return of the Jedi",
      "release_date": "1983-05-25"
    },
    {
      "name": "Revenge of the Sith",
      "release_date": "2005-05-19"
    },
    {
      "name": "The Force Awakens",
      "release_date": "2015-12-11"
    }
  ]
}
```

* The application should work for any character name included in `Swapi`, and for an incorrect name, it should respond with an error JSON and a `404` status code.
* The `fastest_vehicle_driven` attribute should be filled with the name of the fastest "vehicle" or "starship" (with the highest `max_atmosphering_speed`) driven by the character.

### Frontend Project

* The web part will include at least one view to display the list of characters.
* For each listed character, their information should be shown in a format that best fits (Card, List, etc.).
* Ideally, the application should include pagination, and a search bar to filter and search for characters in the saga will be positively valued.

## Evaluation

* Both projects should be stored in a GitHub or Bitbucket repository.
* We expect to see the different commits made until reaching the final solution.
* We expect to receive the source code of the applications and the instructions for their build and execution (README.md).
* larity and modularity of the source code.
* Use of caches.
* Inclusion of testing.
* Dockerization of the project.
* In the backend project:
  * The application must be built as an executable JAR.
  * You can use either `Maven` or `Gradle` for building the project API.
  * Inclusion of documentation for the API (using Swagger, for example).
* In the frontend project:
  * Ideally, `create-react-app` should be used to build the web app (we would also accept a custom configuration using NPM, Babel, and Webpack).
  * Use of hooks and reusable components, both custom and from libraries published in the npm registry.
  * Inclusion of documentation for the web part (you can use an automation library like docz or storybook).

And most importantly, **we greatly appreciate your time and effort**. Do not feel pressured if, for any reason, you do not achieve the final result. We place significant value on the process you have followed and any steps or progress you have made, so please share everything you have generated/coded, and we will take it into account. Keep going!

## Exercise Submission Method
* You should upload your solution to a GitHub account, and our team will review the code.
* To do this, add `diverger-tech-team` as contributors to the project.
* Create a pull request and add us as reviewers so we can review the code.
* As soon as we receive the request, we will respond with an email confirming we received the PR.
* When we proceed with the review, you may receive some comments in the PR itself.
* The most interesting part is that you can share all your thoughts and decisions with our technical team, for which we will propose a 30-minute session at a time that suits you. That way, you can get to know part of the team and discuss the exercise.