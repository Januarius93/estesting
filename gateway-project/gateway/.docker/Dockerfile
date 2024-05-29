FROM amazoncorretto:20-alpine-jdk AS build
EXPOSE 8181:8181
COPY /target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]