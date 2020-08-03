FROM openjdk:11
ADD target/gs-spring-boot-docker-0.1.0.jar api-java.jar
ENTRYPOINT ["java", "-jar", "api-java.jar"]
