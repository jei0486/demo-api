# demo-api

### Dockerfile  (도커라이징)
### application profile 별 설정

### docker cmd
docker build --tag mysqldb -f Dockerfile_MySQL .
docker run -d -p 3306:3306 --name mydb -v /home/ubuntu/mysqldata:/var/lib/mysql mysqldb
docker run -d --name mydb -v /home/ubuntu/mysqldata:/var/lib/mysql mysqldb
docker run --rm -d -p 8888:8888 --name demo-api --link docker_mysql_1:mysql --net docker_default jei0486/demo-api
docker run --rm -d -p 9099:9099 --name demo-fe --link docker_mysql_1:mysql --net docker_default jei0486/demo-fe

#### Docker file ver 1
FROM gradle:7.5.1-jdk11-alpine AS build
COPY --chown=gradle:gradle ./ /home/demo-api
WORKDIR /home/demo-api
RUN gradle build --no-daemon --stacktrace

FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
RUN mkdir /app

COPY --from=build /home/demo-api/build/libs/*.jar /app/application.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app/application.jar"]
####

### Docker file ver 2
FROM openjdk:11
EXPOSE 8088

RUN mkdir /app

COPY ./build/libs/*-SNAPSHOT.jar ./app/application.jar

ENTRYPOINT ["java","-jar","/app/application.jar"]
####