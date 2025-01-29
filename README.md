# Spring Boot Security Login example with JWT and H2 example

- Appropriate Flow for User Login and Registration with JWT and HttpOnly Cookie
- Spring Boot Rest Api Architecture with Spring Security
- How to configure Spring Security to work with JWT
- How to define Data Models and association for Authentication and Authorization
- Way to use Spring Data JPA to interact with H2 Database

## User Registration, Login and Authorization process.

```mermaid
graph LR
    A[User] -->|Signup Request| B[API: /api/auth/signup]
    B -->|Signup Response| A
    A -->|Login Request| C[API: /api/auth/signin]
    C -->|Login Response with JWT| A
    A -->|Access Protected Resource| D[API: /api/test/user]
    D -->|Response with Data| A
    A -->|Logout Request| E[API: /api/auth/signout]
    E -->|Logout Response| A
```

## Spring Boot Server Architecture with Spring Security
You can have an overview of our Spring Boot Server with the diagram below:

```mermaid
graph LR
    A[Client] -->|HTTP Requests| B[Spring Boot Server]
    B -->|Handles Authentication| C[Spring Security]
    C -->|Generates JWT| D[JWT Token]
    D -->|Sends Response| A
    B -->|Interacts with| E[H2 Database]
```



## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`

```
## Run Spring Boot application
```
mvn spring-boot:run
```

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
