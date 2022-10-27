FROM gradle:7.4.1-jdk11-alpine AS build
COPY --chown=gradle:gradle ./ /home/demo-api
WORKDIR /home/demo-api
RUN gradle build --no-daemon --stacktrace

FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
RUN mkdir /app

COPY --from=build /home/demo-api/build/libs/*.jar /app/application.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app/application.jar"]