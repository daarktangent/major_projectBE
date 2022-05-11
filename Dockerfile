FROM openjdk:11
ADD target/projectify-Backend-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]