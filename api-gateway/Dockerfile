FROM openjdk:21-jdk

WORKDIR /usr/src/app

COPY target/api-gateway-*.jar api-gateway.jar

CMD ["java", "-jar", "api-gateway.jar"]