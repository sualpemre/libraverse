FROM openjdk:21-jdk

WORKDIR /usr/src/app

COPY target/account-service-*.jar account-service.jar

CMD ["java", "-jar", "account-service.jar"]