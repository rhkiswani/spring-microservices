FROM picoded/ubuntu-openjdk-8-jdk
MAINTAINER kiswanim
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} loader.jar
COPY ./docker-enterypoint.sh docker-enterypoint.sh
USER root
RUN apt-get update && apt-get -y install netcat && apt-get clean
RUN chmod 777 loader.jar
RUN chmod 777 docker-enterypoint.sh & chmod +x docker-enterypoint.sh
