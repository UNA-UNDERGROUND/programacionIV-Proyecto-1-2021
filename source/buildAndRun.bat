@echo off
call mvn clean package
call docker build -t com.progra4/proyecto1 .
call docker rm -f proyecto1
call docker run -d -p 9080:9080 -p 9443:9443 --name proyecto1 com.progra4/proyecto1