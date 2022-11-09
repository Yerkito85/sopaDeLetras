#imagen base (limpia) para instalar nuestra app dentro de la misma
FROM openjdk:8-jdk-slim
#ruta del jar a dockerizar + nombre del componente dentro de la imagen (alias)
COPY "./target/sopa-0.0.1-SNAPSHOT.jar" "app.jar"
#puerto por el cual se expondra la app
EXPOSE 8080
#comandos para ejecutar nuestra app con el alias
ENTRYPOINT ["java", "-jar", "app.jar"]

