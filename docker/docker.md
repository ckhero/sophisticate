## Docker
#### 简介
     
    
#### 常用命令
    docker pull    拉取或者更新指定镜像
    
    docker push     将镜像推送至远程仓库
    
    docker rm    删除容器
    
    docker rmi    删除镜像
    
    docker images    列出所有镜像
    
    docker ps    列出所有容器
    
   
###### 删除镜像
    docker rmi -f(可选参数,强制删除) [IMAGE ID] 
    #批量删除 
    docker rmi $(docker images | awk '{if($3="[IMAGE ID]") print $3}')
    
###### PS
    docker ps [OPTIONS]
    OPTIONS说明：
    
    -a :显示所有的容器，包括未运行的。
    
    -f :根据条件过滤显示的内容。
    
    --format :指定返回值的模板文件。
    
    -l :显示最近创建的容器。
    
    -n :列出最近创建的n个容器。
    
    --no-trunc :不截断输出。
    
    -q :静默模式，只显示容器编号。
    
    -s :显示总的文件大小。
    
###### 删除容器
    ## 运行中
    docker kill [CONTAINER ID]
    ## 运行中所有
    docker kill $(docker ps -a -q)
    ## 未运行
    docker rm [CONTAINER ID]
    ## 未运行所有
    docker rm $(docker ps -a -q)


###### 进入容器
    docker exec [OPTIONS] CONTAINER COMMAND [ARG...]
    OPTIONS说明：
    
    -d :分离模式: 在后台运行
    
    -i :即使没有附加也保持STDIN 打开
    
    -t :分配一个伪终端
    
    eg: docker exec -it [CONTAINER ID] /bin/bash
    
###### 构建镜像
    #当前目录dockerfile
    docker build -t [IMAGE NAME]:[IMAGE VERSION] .
    # 远程
    docker build github.com/creack/docker-firefox
    # 指定Dockerfile
    docker build -f /path/to/a/Dockerfile .
    
###### 构建TAG
    docker tag [LOCAL IMAGE ID] [REMOTE IMAGE NAME]:[IAMGE VERSION]
    
###### 以前台形式运行
    CMD ["nginx", "-g", "daemon off;"]
    
###### 运行容器
    使用docker镜像nginx:latest以后台模式启动一个容器,并将容器命名为mynginx。
   
    docker run --name mynginx -d nginx:latest
    使用镜像nginx:latest以后台模式启动一个容器,并将容器的80端口映射到主机随机端口。
    
    docker run -P -d nginx:latest
    使用镜像 nginx:latest，以后台模式启动一个容器,将容器的 80 端口映射到主机的 80 端口,主机的目录 /data 映射到容器的 /data。
    
    docker run -p 80:80 -v /data:/data -d nginx:latest
    绑定容器的 8080 端口，并将其映射到本地主机 127.0.0.1 的 80 端口上。
    
    $ docker run -p 127.0.0.1:80:8080/tcp ubuntu bash
    使用镜像nginx:latest以交互模式启动一个容器,在容器内执行/bin/bash命令。
    
    runoob@runoob:~$ docker run -it nginx:latest /bin/bash
    root@b8573233d675:/# 
   
###### 无法拉取镜像的坑
    https://blog.csdn.net/quanqxj/article/details/79479943
    
 [2019年最新docker面试题和答案！](https://blog.csdn.net/lixiao0320/article/details/94348042)
 [CMD！](https://www.jianshu.com/p/78f4591b7ff0)
    
