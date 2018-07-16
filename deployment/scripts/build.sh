#!/usr/bin/env bash

export DOCKER_HOST=unix:///var/run/docker.sock

mvn -f ../../pom.xml clean install