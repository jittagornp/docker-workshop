#!/bin/bash
rm -rf dist

#build source code (.jar file)
docker run --rm -v $(pwd):/web node:12.13.0 yarn install 
docker run --rm -v $(pwd):/web node:12.13.0 yarn build 

# remove container and images
docker stop vuejs-frontend || true
docker rm vuejs-frontend || true
docker rmi vuejs-frontend || true

# build docker image
docker build -t vuejs-frontend .

# run container
docker run -d --name=vuejs-frontend -p 3001:80 --restart=always vuejs-frontend