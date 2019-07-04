# Spring Batch Service example

This is a Maven project of a spring-batch application described in [Spring Guides for batch processing](https://spring.io/guides/gs/batch-processing/).

### Installation

Nothing new here:
- clone the repo `git clone git@github.com:belgoros/spring-batch-example.git`
- cd the project
- run `mvn install` to install th dependencies

### Run

The app makes a request to a Rails API hosted at [Heroku](https://classic-json-api.herokuapp.com).
All the end-points of API are protected and a token is required to get access.
You can get the access token by running:
```
curl -H "Content-Type: application/json" -X POST -d '{"email":"example@mail.com","password":"12345"}' https://classic-json-api.herokuapp.com/authenticate
```

The Rails API code source can be found [here](https://github.com/belgoros/classic-json-api).

You can run the batch service either from your terminal:
```
java -jar target/spring-batch-example-1.0-SNAPSHOT.jar
```

or from your preferred IDE by choosing the available `spring-boot` plugin `run` task.

The job prints out a line for each fetched Post.
```
item = PostDto(title=title-0, body=body-0)
item = PostDto(title=title-1, body=body-1)
item = PostDto(title=title-2, body=body-2)
item = PostDto(title=title-3, body=body-3)
item = PostDto(title=title-4, body=body-4)
item = PostDto(title=title-5, body=body-5)
item = PostDto(title=title-6, body=body-6)
item = PostDto(title=title-7, body=body-7)
item = PostDto(title=title-8, body=body-8)
item = PostDto(title=title-9, body=body-9)
```

