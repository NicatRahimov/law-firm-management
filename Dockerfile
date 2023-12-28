FROM openjdk:17-jdk-slim-buster
ADD build/libs/*.jar dockerapp.jar
ENTRYPOINT ["java", "-jar", "dockerapp.jar"]
EXPOSE 8080
