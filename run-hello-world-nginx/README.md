# Run Hello World Nginx

### 1. Run Container 
```sh
$ docker run -d \
    --name=hello-world-nginx \
    -p 80:80 \
    --restart=always nginx
```

### 2. Show Result
```sh
$ docker ps -a
$ docker images
```

### 3. Test

> http://<HOST_NAME or IP>
