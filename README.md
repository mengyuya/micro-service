# micro-service 微服务
技术栈  
--------------
>服务注册、发现：eureka<br/>
API网关：zuul<br/>
配置管理：config<br/>
集群容错：hystrix<br/>
服务负载：ribbon<br/>
服务调用：feign<br/>
API文档：swagger2<br/>
代码简化：lombok<br/>
链路跟踪：sleuth+zipkin<br/>
安全认证：spring security(暂未实现)<br/>
服务监控：actuator->spring-admin<br/>

架构图  
--------------
![springcloud微服务架构.png](https://upload-images.jianshu.io/upload_images/14770430-8a0ead61b781be6c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##启动步骤  
    
1.配置数据源和config<br/>
2.windows直接下载该项目下nginx-1.12.2.zip并解压运行(端口8088，已配置zuul80端口和81端口集群)，其他系统需要自行配置nginx<br/>
3.运行该项目下zip-server-2.11.12-exec.jar（端口9411）<br/>
4.启动eureka集群（端口8751和8761）<br/>
5.启动config-server（端口8888）<br/>
6.启动spring-admin-ui（端口8086）<br/>
7.启动zuul集群（端口80和81）<br/>
8.启动user-service（端口8081），该项目连接数据库，模拟服务提供者<br/>
9.启动order-service（端口8082和8083），该项目未实际连接数据库，只是模拟连接数据库，模拟服务消费者<br/>




