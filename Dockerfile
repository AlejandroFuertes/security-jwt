# Establecer la imagen base
FROM openjdk:17-jdk

# Establecer el directorio de trabajo en la imagen
WORKDIR /app

# Copiar el archivo JAR del microservicio al contenedor
COPY target/oauth-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el contenedor (ajústalo según sea necesario)
EXPOSE 8080

# Comando para ejecutar el microservicio cuando se inicie el contenedor
CMD ["java", "-jar", "/app/app.jar"]