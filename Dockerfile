FROM openjdk:17
ENV SPRING_PROFILES_ACTIVE='mysql'
COPY target/contact-list-service-kuehne-nagel-0.0.1-SNAPSHOT.jar contact-list-service-kuehne-nagel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/contact-list-service-kuehne-nagel-0.0.1-SNAPSHOT.jar"]