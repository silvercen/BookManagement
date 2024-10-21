FROM openjdk:21-oracle
COPY ./target/BookManagement-0.0.1-SNAPSHOT.jar BookManagement.jar
CMD ["java","-jar","BookManagement.jar"]