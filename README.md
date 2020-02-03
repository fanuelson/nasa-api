

# Project description:

The project is an API that returns the mars average temperature by the given SOL (Martian Days).


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