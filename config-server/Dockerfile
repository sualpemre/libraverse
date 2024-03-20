FROM openjdk:21-jdk

WORKDIR /usr/src/app

COPY target/config-server-*.jar config-server.jar

CMD ["java", "-jar", "config-server.jar"]