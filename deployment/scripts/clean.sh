#!/usr/bin/env bash

function stopIfRunning (){
    if [ ! "$(docker ps -q -f name=$1)" ]; then
        if [ "$(docker ps -aq -f status=exited -f name=$1)" ]; then
            docker rm $1
        fi
    fi
    if [ "$(docker ps -q -f name=$1)" ]; then
        docker stop $1
        docker rm $1
    fi

}

function main(){
   stopIfRunning "web"
   stopIfRunning "loader"
   stopIfRunning "mysql"
}

main