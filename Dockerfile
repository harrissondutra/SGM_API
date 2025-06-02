FROM openjdk:17-alpine
LABEL maintainer="Harrisson Dutra"

# Cria grupo e usuário para rodar a aplicação
RUN addgroup -S spring && adduser -S spring -G spring

# Argumento para o local do JAR
ARG JAR_FILE=target/gestor-0.0.1-SNAPSHOT.jar

# Copia o JAR para o container
COPY ${JAR_FILE} app.jar

# Altera para o usuário não-root
USER spring:spring

# Define o entrypoint
ENTRYPOINT ["java", "-jar", "/app.jar"]
