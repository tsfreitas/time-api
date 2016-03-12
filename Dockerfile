FROM java:8
MAINTAINER Thiago Santos de Freitas <tsfreitas@gmail.com>

RUN apt-get update

ENV spring.profiles.active production

EXPOSE 8080

COPY target/timeApi.jar app.jar

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java", "-jar", "/app.jar"]