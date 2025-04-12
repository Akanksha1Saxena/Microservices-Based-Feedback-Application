FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} survey-app.jar
ENTRYPOINT ["java","-jar","/survey-app.jar"]
EXPOSE 8080