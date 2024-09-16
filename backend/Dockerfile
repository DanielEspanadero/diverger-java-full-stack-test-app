FROM openjdk:17-jdk-slim

COPY build/libs/backend-0.0.1-SNAPSHOT.jar /app/backend.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "backend.jar"]
