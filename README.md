# SPRINGBOOT 2 CHALLENGE - VOTING SYSTEM
The system was designed looking for simplicity, manutenibility and evolution.
Using a high and controlled use of Inversion of Control, and separating concepts into layers: application, domain, infraestructure.

With the inversion of control we can make our system independs of infraestructure like: database, ui, external services, internal services like email and etc...

Trying to separate the responsabilities of each part of the system.
- Domain only know and can access your entities and own business rules
- App works in the http layer and can get objects from domain also can use the infraestructure ecosystem
- Infra can access the domain objects too


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You will need to install
- Java 11 +
- PostgresSQL

### Installing

After install you need to run on the root folder of the project:

```
 ./gradlew bootRun
```

## Running the tests

```
 ./gradlew tests
```


## Build command

```
 ./gradlew build
```

## Run dev env command

```
 ./gradlew bootRun
```

## Manual Functional Api Tests 
http://localhost:8080/guideline/create
``` 
{
  "guideline": {
    "id": 15
  }
}
```


http://localhost:8080/voting/in-guideline
``` 
{
  "voteInfo": {
    "guideline": {
      "id": 1
    },
    "associated": {
      "id": 3
    },
    "hasVoted": true
  }
}
```

http://localhost:8080/voting/counter/2

the response must be two