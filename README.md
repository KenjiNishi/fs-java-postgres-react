# fs-java-postgres-react
Project using Java SpringBoot + postgreSQL + ReactJS

Created using [SpringInitializr](https://start.spring.io/) + Maven.

Spring Boot Dependencies:

    * spring-boot-starter-data-jpa
    * spring-boot-starter-web
    * spring-boot-starter-thymeleaf
    * postgresql
    * lombok
    * jackson (core+annotation+databind)
    * junit

NodeJS Dependencies:

    * "@babel/plugin-proposal-class-properties"
    * "@babel/preset-env"
    * "@babel/preset-react"
    * "babel-loader"
    * "css-loader"
    * "sass-loader"
    * "webpack"
    * "webpack-cli"
   
    - Global
    * "react"
    * "react-dom"
    * "react-redux"
    * "react-router-dom"
    * "redux"
    * "redux-devtools-extension"
    * "redux-thunk"

## Running the project
1. ```yarn transpile``` to build React FrontEnd;
2. ```./mvnw test``` for JUnit Unit Testing;
3. ```./mvnw spring-boot:run``` for Starting the Server;




