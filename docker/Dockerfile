FROM java:8
MAINTAINER Thiago Santos de Freitas <tsfreitas@gmail.com>

ENV spring.profiles.active production

EXPOSE 8080

COPY timeApi.jar app.jar

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java", "-jar", "/app.jar"]