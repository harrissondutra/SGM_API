FROM openjdk:17-alpine
LABEL maintainer="Harrisson Dutra"

# Create a group and user for running the application
RUN addgroup -S spring && adduser -S spring -G spring

# Switch to the new user
USER spring:spring

# Argument for the JAR file location
ARG JAR_FILE=target/gestor-0.0.1-SNAPSHOT.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]