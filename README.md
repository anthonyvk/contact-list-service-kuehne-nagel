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

## To Build Docker image :

`docker build -t anthony/contact-list-service-kuehne-nagel .
`

## To run the Docker image :

`docker run -p8080:8080 anthony/contact-list-service-kuehne-nagel
`

## To run the entire suite with Docker compose : 
