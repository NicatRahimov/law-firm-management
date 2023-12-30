FROM openjdk:17-jdk-slim-buster
ADD build/libs/law-firm-management-0.0.1-SNAPSHOT.jar dockerapp.jar
ENTRYPOINT ["java", "-jar", "dockerapp.jar"]
EXPOSE 8080
