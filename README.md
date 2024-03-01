# 在线考试系统

## 系统介绍

该项目是一个前后端分离，后端使用 SpringCloud，前端使用 VUE 和 Element-UI 组件库配合完成开发。

该项目使用spring cloud集成gateway和sentinel来控制访问,可以通过配置中心动态调整限流规则、熔断降级策略等参数，提高配置的灵活性和可维护性

## 端口管理

| 服务名称      | 服务     | 端口号 |
| ------------- | -------- | ------ |
| role-service  | 角色服务 | 8080   |
| score-service | 分数服务 | 8081   |
| paper-service | 试卷服务 | 8082   |
| exam-gateway  | 网关     | 10010  |


| 服务名称      | 服务     | 端口号 |
| ------------- | -------- | ------ |
| redis         |          | 6379  |
| nacos         |          | 8848  |
| sentinel      |          | 8858  |

## 环境

### Java 8

### centos 7

IP 192.168.32.2

### docker

![1709277967374](E:\onlineExam\images\1709277967374.jpg)

### MySQL

![1709278146728](E:\onlineExam\images\1709278146728.jpg)

### redis

![image-20240301153831630](C:\Users\18505\AppData\Roaming\Typora\typora-user-images\image-20240301153831630.png)



### nacos

![1709288178053](E:\onlineExam\images\1709288178053.jpg)

### sentinel

![image-20240301181811778](C:\Users\18505\AppData\Roaming\Typora\typora-user-images\image-20240301181811778.png)





## 控制台

### nacos

![1709288678501](E:\onlineExam\images\1709288678501.jpg)



### sentinel

![1709288947593](E:\onlineExam\images\1709288947593.jpg)





## 页面截图

![1709195362489](E:\onlineExam\images\1709195362489.jpg)

<center>登录</center>

![1709195394008](E:\onlineExam\images\1709195394008.jpg)

<center>试卷列表</center>

![1709195433488](E:\onlineExam\images\1709195433488.jpg)

<center>答题模块</center>

![1709195468781](E:\onlineExam\images\1709195468781.jpg)

<center>练习模式</center>

![1709195500825](E:\onlineExam\images\1709195500825.jpg)

<center>留言模块<center/>

![1709195552007](E:\onlineExam\images\1709195552007.jpg)

<center>后台管理</center>

![1709199590688](E:\onlineExam\images\1709199590688.jpg)

<center>学生成绩</center>
