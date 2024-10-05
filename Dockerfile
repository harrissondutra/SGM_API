FROM openjdk:17-alpine
LABEL authors="Harrisson Dutra"

RUN apt-get update

RUN apt-get install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y

RUN mvn clean install -DskipTests

EXPOSE 8080

COPY /target/gestor-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]