FROM openjdk:11-jdk-alpine

COPY libs/CRUDSample-0.0.1-SNAPSHOT.jar CRUDSample-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/CRUDSample-0.0.1-SNAPSHOT.jar"]