FROM openjdk:17
ENV PROFILE='h2'
COPY target/contact-list-service-kuehne-nagel-0.0.1-SNAPSHOT.jar contact-list-service-kuehne-nagel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=$PROFILE","/contact-list-service-kuehne-nagel-0.0.1-SNAPSHOT.jar"]