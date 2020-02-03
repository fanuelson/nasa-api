

# Project description:

The project is an API that returns the Mars' average temperature in Fahrenheit by a given SOL (Martian Days).

**I'm using this link to make sure the values are correct:**

https://mars.nasa.gov/insight/weather/


The API was deployed at heroku and it is available here:

https://nasa-api-test.herokuapp.com/nasa/temperature

<hr>

- The API expects only one parameter: SOL

- https://nasa-api-test.herokuapp.com/nasa/temperature?SOL=421

Response:
```
{"averageTemperature":-70.6378}
```

<hr>

- If "SOL" parameter is not provided then it returns the average of all "SOLs" found.

- https://nasa-api-test.herokuapp.com/nasa/temperature

Response:
```
{"averageTemperature":-76.59888571428571}
```


# Run with docker

- build project with maven
```
./mvnw package
```
- build image
```
docker build -t springio/gs-spring-boot-docker .
```
- run the container
```
docker run -p 8080:8080 -t springio/gs-spring-boot-docker
```