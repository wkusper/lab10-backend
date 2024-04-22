FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/lab10-0.0.1-SNAPSHOT.jar lab10.jar
ENTRYPOINT ["java", "-jar", "lab10.jar"]