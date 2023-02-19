FROM openjdk:17
EXPOSE 8080
ADD target/quote-service.jar quote-service.jar
ENTRYPOINT ["java", "-jar", "/quote-service.jar"]