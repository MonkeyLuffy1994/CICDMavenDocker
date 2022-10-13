FROM maven:3.6.3-openjdk-15 as maven

COPY . /tmp/

WORKDIR /tmp

RUN --mount=type=cache,target=/root/.m2  mvn clean package -Dmaven.test.skip

FROM openjdk:15-jdk-alpine

COPY --from=maven /tmp/web_router/target/web_router-1.0-SNAPSHOT.jar ./web_router-1.0-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "./web_router-1.0-SNAPSHOT.jar"]