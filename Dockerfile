#基于镜像
FROM centos
#作者
MAINTAINER lidong
#声明变量
ENV ROOT_PATH /usr/local/
#设置工作目录 用户进入容器之后终端默认路径
WORKDIR ROOT_PATH
#安装VIM
RUN yum -y install vim
RUN yum -y install net-tools
#对外暴露端口
EXPOSE 8090
#输出工作下的所有文件夹和文件
RUN ls -lh
#dockerfile命令
FROM java:8
ADD springbootlearn-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar app.jar