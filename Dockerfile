FROM maven:3.9.5-openjdk-21 as build
# copy everything
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/interactivemap-0.0.1-SNAPSHOT.jar interactivemap.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","interactivemap.jar"]