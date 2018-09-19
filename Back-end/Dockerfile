FROM openjdk:8-jdk-alpine
ADD ./ /app/
WORKDIR /app/
RUN ./mvnw package -DskipTests
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/complaints-api-0.0.1-SNAPSHOT.jar"]