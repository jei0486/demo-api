FROM openjdk:11.0.11-jre-slim
#FROM openjdk:11.0.14.1-jre
EXPOSE 8088

RUN mkdir /app

COPY ./build/libs/*-SNAPSHOT.jar ./app/application.jar

ENTRYPOINT ["java","-jar","/app/application.jar"]