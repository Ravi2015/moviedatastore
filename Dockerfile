FROM openjdk:19-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} moviedatastoreapp.jar

ENTRYPOINT ["java","-jar","/moviedatastoreapp.jar"]