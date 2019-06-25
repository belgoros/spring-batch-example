# Spring Batch Service example

This is a Maven project of a spring-batch application described in [Spring Guides for batch processing](https://spring.io/guides/gs/batch-processing/).

### Installation

Nothing new here:
- clone the repo `git clone git@github.com:belgoros/spring-batch-example.git`
- cd the project
- run `mvn install` to install th dependencies

### Run

The app uses the in-memory `HSQL DB` database. So all the created data will be dropped after exits.
The service reads `sample_data.csv` file, parses and extracts the data and inserts in the database. See the [guide](https://spring.io/guides/gs/batch-processing/) for a more detailed step-by-step explanation.

You can run the batch service either from your terminal:
```
java -jar target/spring-batch-example-1.0-SNAPSHOT.jar
```

or from your preferred IDE by choosing the available `spring-boot` plugin `run` task.

The job prints out a line for each person that gets transformed. After the job runs, you can also see the output from querying the database.
```
Converting (firstName: Jill, lastName: Doe) into (firstName: JILL, lastName: DOE)
Converting (firstName: Joe, lastName: Doe) into (firstName: JOE, lastName: DOE)
Converting (firstName: Justin, lastName: Doe) into (firstName: JUSTIN, lastName: DOE)
Converting (firstName: Jane, lastName: Doe) into (firstName: JANE, lastName: DOE)
Converting (firstName: John, lastName: Doe) into (firstName: JOHN, lastName: DOE)
Found <firstName: JILL, lastName: DOE> in the database.
Found <firstName: JOE, lastName: DOE> in the database.
Found <firstName: JUSTIN, lastName: DOE> in the database.
Found <firstName: JANE, lastName: DOE> in the database.
Found <firstName: JOHN, lastName: DOE> in the database.
```

