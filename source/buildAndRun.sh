#!/bin/sh
mvn clean package && docker build -t com.progra4/proyecto1 .
docker rm -f proyecto1 || true && docker run -d -p 9080:9080 -p 9443:9443 --name proyecto1 com.progra4/proyecto1