FROM openjdk:11
EXPOSE 8088

RUN mkdir /app

COPY ./build/libs/*-SNAPSHOT.jar ./app/application.jar

ENTRYPOINT ["java","-jar","/app/application.jar"]