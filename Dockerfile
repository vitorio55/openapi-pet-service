FROM openjdk:11-jre-slim
ARG JAR_FILE=./build/libs/openapi-pet-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN mkdir -p ./config
COPY ./build/resources/main/application.properties ./config
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]