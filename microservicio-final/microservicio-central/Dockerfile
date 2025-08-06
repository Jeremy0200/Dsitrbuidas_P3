# Etapa 1: Compilar el JAR
FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -Dmaven.test.skip=true

# Etapa 2: Ejecutar el JAR
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]