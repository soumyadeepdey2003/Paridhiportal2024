FROM openjdk:20
EXPOSE 6002
COPY ./target/PortalRestAPI.jar /app/PortalRestAPI.jar
COPY src/main/resources/application.properties /app/application.properties
WORKDIR /app
ENTRYPOINT ["java", "-jar", "PortalRestAPI.jar"]

