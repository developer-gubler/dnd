FROM openjdk:17-jdk-alpine
MAINTAINER developer.gubler@gmail.com
ARG JAR_FILE=target/dnd-battle*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]