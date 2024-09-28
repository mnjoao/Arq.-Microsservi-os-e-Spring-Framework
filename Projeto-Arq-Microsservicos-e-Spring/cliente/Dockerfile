# Usar a imagem oficial do OpenJDK para Java 21
FROM openjdk:21-jdk-slim

# Diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR gerado para o diretório de trabalho do container
COPY target/*.jar /app/app.jar

# Expor a porta da aplicação no container
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
