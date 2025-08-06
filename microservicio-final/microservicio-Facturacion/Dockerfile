FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -Dmaven.test.skip=true

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]