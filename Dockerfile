FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
# Set the default command to run the Java application
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]

