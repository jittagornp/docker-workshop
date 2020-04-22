# Run Mysql

### 1. Run Container 
```sh
$ docker run -d \
    --restart=always \
    --name=mysql \
    -e "MYSQL_ROOT_PASSWORD=NNpbLDqK" \
    -e "MYSQL_DATABASE=my-database" \
    -v /root/mysql:/var/lib/mysql \
    -p 3306:3306 mysql
```

### 2. Show Result
```sh
$ docker ps -a
$ docker images
```

### 3. Test

Connect to Database by Mysql Workbench

```plaintext
host : <DOCKER_HOST>  
port : 3306  
username : root  
password : NNpbLDqK  
```
