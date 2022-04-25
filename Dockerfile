FROM openjdk:11-jre
COPY build/libs/*.jar app.jar
EXPOSE 9035
ENTRYPOINT ["java", "-jar", "/app.jar"]