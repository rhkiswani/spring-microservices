#!/usr/bin/env bash

function main(){
   #password can be encrypted env variable but for the lack of time i'm gonna put it here
#   docker run -p 3306:3306 --name mysql -e MYSQL_USER=root -e MYSQL_ROOT_PASSWORD=Mrk_9626 -e MYSQL_DATABASE=atms  -d mysql:5.7
#   ./wait-for-service.sh mysql 3306
   docker-compose up --build
}

main