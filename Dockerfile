FROM openjdk:8-jre-alpine
ADD target/zipkin-service-two-1.0-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]