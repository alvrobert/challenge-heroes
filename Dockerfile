FROM openjdk:8-jre-alpine
ADD target/challengue-0.0.1-*.jar client-service.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/client-service.jar", "--server.port=8080"]