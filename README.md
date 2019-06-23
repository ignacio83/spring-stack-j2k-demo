# Spring Stack - From Java to Kotlin
## Running

### Application
```mvn spring-boot:run```

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