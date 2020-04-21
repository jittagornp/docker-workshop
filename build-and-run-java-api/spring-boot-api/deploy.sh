#!/bin/bash
rm -rf target

#build source code (.jar file)
docker run --rm -v $(pwd):/app -v /root/.m2:/root/.m2 maven:3.6.2-jdk-11 mvn install -f /app/pom.xml

# remove container and images
docker stop spring-boot-api || true
docker rm spring-boot-api || true
docker rmi spring-boot-api || true

# build docker image
docker build -t spring-boot-api .

# run container
docker run -d --name=spring-boot-api -p 3002:80 --restart=always --link=mysql spring-boot-api