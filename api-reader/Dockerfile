FROM openjdk:17-jdk-alpine
MAINTAINER developer.gubler@gmail.com
ARG JAR_FILE=target/api*.jar
COPY ${JAR_FILE} app.jar
#RUN mkdir -p keystore
#COPY src/main/resources/keystore/* keystore
ENTRYPOINT ["java","-jar","/app.jar"]