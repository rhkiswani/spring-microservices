#!/usr/bin/env bash

echo "current path $PWD"
echo "jar file path $1"
java jar -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$2 $1