FROM openjdk:8-jdk-alpine
MAINTAINER Vikash
EXPOSE 8761
ADD /target/eureka-server-service-0.0.1-SNAPSHOT.jar eureka-server-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","eureka-server-service-0.0.1-SNAPSHOT.jar"]