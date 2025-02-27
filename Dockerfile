FROM maven:3.9.8-eclipse-temurin-21 AS build
# copy everything
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY --from=build /target/interactivemap-0.0.1-SNAPSHOT.jar interactivemap.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","interactivemap.jar"]