# micro-service 微服务
## 技术栈  
>服务注册、发现：eureka  
API网关：zuul  
配置管理：config  
集群容错：hystrix  
服务负载：ribbon  
服务调用：feign  
API文档：swagger2  
代码简化：lombok  
链路跟踪：sleuth+zipkin  
安全认证：spring security(暂未实现)  
服务监控：actuator->spring-admin  
日志管理：logback  


## 架构图 
![springcloud微服务架构.png](https://upload-images.jianshu.io/upload_images/14770430-8a0ead61b781be6c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 启动步骤    
1.配置数据源和config  
2.windows直接下载该项目下nginx-1.12.2.zip并解压运行(端口8088，已配置zuul80端口和81端口集群)，其他系统需要自行配置nginx  
3.运行该项目下zipkin-server-2.11.12-exec.jar（端口9411）  
4.启动eureka集群（端口8751和8761）  
5.启动config-server（端口8888）  
6.启动spring-admin-ui（端口8086）  
7.启动zuul集群（端口80和81）  
8.启动user-service（端口8081和8084），该项目连接数据库，模拟服务提供者  
9.启动order-service（端口8082和8083），该项目未实际连接数据库，只是模拟连接数据库，模拟服务消费者  
**注意：每个微服务都可以搭建集群，此项目仅做演示所以只将eureka，zuul，service做了集群**  




