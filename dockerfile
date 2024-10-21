FROM amazoncorretto:21.0.5-alpine3.20
COPY ./target/BookManagement-0.0.1-SNAPSHOT.jar BookManagement.jar
CMD ["java","-jar","BookManagement.jar"]