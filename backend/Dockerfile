FROM openjdk:17-jdk-slim

COPY build/libs/starWars-0.0.1-SNAPSHOT.jar /app/starWars.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "starWars.jar"]
