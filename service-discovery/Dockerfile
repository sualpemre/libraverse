FROM openjdk:21-jdk

WORKDIR /usr/src/app

COPY target/service-discovery-*.jar service-discovery.jar

CMD ["java", "-jar", "service-discovery.jar"]