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

    - Dev
    * "@babel/plugin-proposal-class-properties"
    * "@babel/preset-env"
    * "@babel/preset-react"
    * "babel-loader"
    * "css-loader"
    * "sass-loader"
    * "webpack"
    * "webpack-cli"
   
    - Required
    * "react"
    * "react-dom"
    * "react-redux"
    * "react-router-dom"
    * "redux"
    * "redux-thunk"

## Running the project
1. ```yarn transpile``` to build React Frontend;
2. ``` ./mvnw clean ``` for a clean Backend build
3. ```./mvnw spring-boot:run``` for Starting the Server;
4. Access http://localhost:8080/
5.  ```./mvnw test``` for JUnit Unit Testing;

# Project description

A company is going to provide training for a client. 

The training has 2 stages where atendees will be split among N Event Rooms with variable capacity. 

There will be 2 Coffee Breaks in M distinct Lounge Rooms.

Backend requirements:

    - Register Atendees using first and last name;
    - Register Event Rooms using name and capacity;
    - Register Lounge Rooms using name;
    
    The difference of Atendees in each Event Room must not exceed 1.

    Half the people in each Event Room will change to Room after the Coffe Break.

    When looking for an Atendee return:    
    - Event Rooms for each Stage 
    - Lounge Room for the Coffe Breaks;

    When consulting an Event or Lounge Room:
    - Return a list of people that will attend the training/break in each room.


Frontend requirements:

    - Register Atendees with first and last name;
    - Register Event Rooms with name and capacity;
    - Register Lounge Rooms with name;
    - Consult Atendees info;
    - Consult Rooms info;

# Solution

## API
For manual testing of the API there are .rest files that contain use cases;

Endpoint | Description
---------|----------
 /api/lounge/save | Saves a single Lounge in the Database
 /api/lounge/all  | Get a list of all Lounges
 /api/lounge/id/:id | Get a single Lounge
 /api/lounge/update/:id | Update Lounge info
 /api/lounge/delete/:id | Delete Lounge
 /api/room/save  | Saves a single Room in the Database
 /api/room/all | Get a list of all Rooms
 /api/room/id/:id  | Get a single Room
 /api/room/update/:id | Update Room info
 /api/room/delete/:id | Delete Room
 /api/person/save  | Saves a single Person in the Database
 /api/person/all | Get a list of all Persons
 /api/person/id/:id  | Get a single Person
 /api/person/update/:id | Update Person info
 /api/person/delete/:id | Delete Person
 /api/actions/organizeAtendees | Distributes Atendees to Event Rooms and Lounge Rooms
 ## Considerations

 * Each Atendee (Person) will be in the same Lounge Room for both coffee breaks, for this reason there is only 1 Lounge Field for each Atendee;
  
 * Room occupancy when Atendee Distribution happens is determined by the Event Room with the least capacity. While the server is processing the Distribution the button will be disabled;
  
 * Information will update automatically after small delay;
  
 * Atendees can only be distributed among rooms if there are at least 1 EventRoom, 1 LoungeRoom AND 1 Person registered (otherwise the button will be disabled);
  
 * If the user chooses to delete a EventRoom or LoungeRoom after Distributing Atendees, all the atendees registered for said room will also be deleted. This happens because of the Relational properties of the postgresSQL database.




