FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/sadahsn/footbal-league.git

FROM maven:3.5-jdk-8-alpine AS build
WORKDIR /app
COPY --from=clone /app/footbal-league /app
RUN mvn install package 

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar"]
