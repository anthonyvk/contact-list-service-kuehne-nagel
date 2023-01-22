```
Full stack developer for customer facing website (req79330)

Task statement
Create a simple "contact list" web application that allows:
     Listing people (name and photo)
     Searching by name
     Paging
Initial list should be one-time populated with people.csv attached. Contact 
addition/removal/edit is out of scope of this task.


Technical clarification
     Spring Boot
     Any build system
     Consider it as an enterprise-grade application (it will stay there for years, will 
    be extended and maintained)
     As a result it should be DB-ready, meaning it should be little-to-zero effort to 
    make this implementation use some enterprise DB (e.g. Oracle)
     For frontend you can use any technology
     Do not care about page design

Expected outcome
A repository at your GitHub account/local KN Git from where you can clone and run 
the web app with little-to-zero efforts
```

## Quick start using docker-compose :
- "docker-compose.yml" is provided in the project.
- Prerequisites : 
  - Docker must be installed.
  - Docker compose must be installed and added to system PATH variable if the command is not accesible.
  - To bring up all the services, the following command needs to be run the project directory :
    - `docker-compose up`
      - this will start the angular web application on port 80 
      - and listens to the backend service which runs on port 8080
      - runs the MySQL database on port 3306
  - docker-compose.yml can be modified based on the requirements.

## Development :
- contact-list-service is a maven project.
- Java version 17 is required.
- Using the bundled maven wrapper (./mvnw)
- This project can be imported into the IDE as maven project
- This project has 2 profiles :
  - "h2" : When the profile is set as "h2", service uses the bundled "H2" database.
  - "mysql" : When the profile is set as "mysql", service uses MySQL database. But the MySQL must externally deployed and the JDBC url must be accesible.

- ### **Environment variables and configuration :**
  - If the profile is set to `"mysql"` for **SPRING_PROFILES_ACTIVE**
    - MYSQL_HOST : the IP/DNS where the MySQL can be accesible
    - MYSQL_DATABASE : Database name
    - USERNAME : MySQL username
    - PASSWORD : MySQL password for the user
  - If the profile is set to `"h2"` for **SPRING_PROFILES_ACTIVE**
    - PASSWORD : H2 password for accessing the console.
    - H2 Console can be accessed from the browser using http://\<IP\>/h2-console

- ### **Building the JAR artifact :**
  - Run the following command `./mvn clean install`, which will compile the project and build jar artifact.
  - Running the jar artifact : 
    - `java -jar target/contact-list-service-kuehne-nagel-0.0.1-SNAPSHOT.jar`


## To Build Docker image :
  - First follow the steps for `Building the JAR artifact`
  - Run the following command to build docker image from the project directory :
    - `docker build -t anthony/contact-list-service-kuehne-nagel .`


## To run the Docker image :
`docker run -p8080:8080 anthony/contact-list-service-kuehne-nagel
`
