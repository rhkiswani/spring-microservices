#!/usr/bin/env bash

function waitTillItsUp(){
    server_host=$1
    sleep_seconds=5

    while true; do
        echo "=================================================================="
        echo "Waiting for $2 docker to be up"
        echo "=================================================================="

        output=$(echo "" | nc $server_host $3)
        if [ "$output" != "" ]
        then
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

waitTillItsUp $1 $2