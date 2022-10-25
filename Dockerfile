FROM gradle:7.5.1-jdk11-alpine AS build
COPY --chown=gradle:gradle ./ /home
WORKDIR /home
RUN gradle build --no-daemon

FROM openjdk:11
EXPOSE 8088
RUN mkdir /app

COPY --from=build /home/build/libs/*-SNAPSHOT.jar ./app/application.jar

ENTRYPOINT ["java","-jar","/app/application.jar"]
