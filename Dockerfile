#FROM gradle:7.5.1-jdk11-alpine AS build
#ARG DEPENDENCY=build/dependency
#COPY --chown=gradle:gradle ./ /home/demo-api
#WORKDIR /home/demo-api
#RUN gradle build --no-daemon --stacktrace

FROM openjdk:11.0.11-jre
EXPOSE 8088
RUN mkdir /app
COPY ./build/libs/*-SNAPSHOT.jar ./app/application.jar
ENTRYPOINT ["java","-jar","/app/application.jar"]