FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/ducks-service-0.0.1-SNAPSHOT.jar ducks-service.jar
ENTRYPOINT ["java", "-jar", "ducks-service.jar"]