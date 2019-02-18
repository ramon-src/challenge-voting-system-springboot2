# SPRINGBOOT 2 CHALLENGE - VOTING SYSTEM


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