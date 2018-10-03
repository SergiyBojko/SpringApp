#!/bin/bash

docker network create --driver bridge my-net

docker rm --force db spring_c

docker run --name db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=user -e MYSQL_PASSWORD=123456 -e  MYSQL_DATABASE=liquibase_test -e MYSQL_ROOT_HOST=% --network my-net -d mysql:5

./mvnw package
docker build -t spring_app .
docker run --name spring_c --network my-net -p 8080:8080 -d spring_app

echo Done