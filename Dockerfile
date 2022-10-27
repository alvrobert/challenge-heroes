FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/challengue-0.0.1-SNAPSHOT.jar client-service.jar
ENTRYPOINT ["java", "-jar", "/client-service.jar"]