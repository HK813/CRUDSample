FROM openjdk:11-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/CRUDSample/build/libs/CRUDSample-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} CRUDSample-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CRUDSample-0.0.1-SNAPSHOT.jar"]