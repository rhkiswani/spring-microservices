FROM picoded/ubuntu-openjdk-8-jdk
MAINTAINER kiswanim
VOLUME /tmp
ARG WAR_FILE
COPY ${WAR_FILE} web.war
COPY ./docker-enterypoint.sh docker-enterypoint.sh
USER root
RUN apt-get update && apt-get -y install netcat && apt-get clean
RUN chmod 777 web.war
RUN chmod 777 docker-enterypoint.sh & chmod +x docker-enterypoint.sh
