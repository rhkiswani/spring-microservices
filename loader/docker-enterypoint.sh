#!/usr/bin/env bash

function waitTillItsUp(){
    server_host=$1
    sleep_seconds=3

    while true; do
        echo "=================================================================="
        echo "Waiting for $2 docker to be up"
        echo "=================================================================="

        output=$(nc -zv $server_host $3 2>&1 | grep open)
        if [[ "$output" =~ "open" ]]; then
            echo "=================================================================="
            echo "$2 is running and ready to process requests."
            echo "=================================================================="
            break
        fi

        echo "=================================================================="
        echo "$2 is warming up. Trying again in $sleep_seconds seconds..."
        echo "=================================================================="
        sleep $sleep_seconds
    done
}

function prepareFolders(){
    echo "===================================================================="
    echo "Prepare folders"
    echo "===================================================================="
    mkdir -p ./logs
}

function run(){
   echo "===================================================================="
   echo "Running $1 with $2 profile"
   echo "===================================================================="
   java  -jar -Dspring.profiles.active=$2 ./$1
}

function main (){
    waitTillItsUp $1 $2 $3
    prepareFolders
    run $4 $5
}

main $1 $2 $3 $4 $5
