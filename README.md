# Spring Stack - From Java to Kotlin
This repository contains two projects with Spring Boot Stack, one in Java and another in Kotlin, both projects have the same endpoints and business rules.

## Running

### Application
Inside a project just type
```
mvn spring-boot:run
```

## Request examples
All examples use [HTTPie](https://httpie.org/)

### Insert persons
```
http POST :8080/persons id=1 fullName='John Nash' age=40
http POST :8080/persons id=2 fullName='Mary Jane' age=32
http POST :8080/persons id=3 fullName='Carl Junior' age=21
```

### List persons
```
http :8080/persons
```