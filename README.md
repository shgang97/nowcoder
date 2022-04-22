# nowcoder
### community project of imitation nowcoder

###  仿牛论坛区项目

- **项目地址**：https://github.com/shgang97/nowcoder

- **技术选型**：SpringBoot+SpringMVC+Mybatis+MySQL+Redis+thymleaf

- **项目描述**：本项目采用微服务架构的思想，主要涉及模块有权限模块、核心模块、性能模块、通知模块、搜素模块和其他模块。完成了社区首页代码的编写，实现了分页功能，登录模块后台代码的编写，解决了帖子审核、评论、异常等功能的开发，从中学习到了技术栈等。

<a href="https://github.com/shgang97/nowcoder">
  <img align="center" src="https://github-readme-stats.vercel.app/api/pin/?username=shgang97&repo=nowcoder&bg_color=000000&title_color=00ff00&icon_color=ffff33&text_color=ffffff" /></a>



## 项目开发步骤

### 一、社区登录模块

1. 自动发送邮件：用于激活注册账号
2. 开发注册功能
3. 生成验证码
4. 开发登录功能、退出功能
5. 显示登录信息
6. 账号设置：修改头像、密码
7. 检查登录状态
   - 使用拦截器：通过自定义注解加在需要拦截的方法上



### 二、发布帖子模块

1. 实现敏感词过滤：基于前缀树实现一个敏感词的过滤器
1. 发布帖子
1. 展示帖子详情
1. 显示评论、添加评论
1. 发送私信、显示私信

## 项目效果展示



### 一、社区首页

实现首页分页功能

<img src="./effectpicture/indexpage2022-04-08_01-43-45.jpg" style="zoom:25%;" />

<img src="./effectpicture/indexpage12022-04-08_01-43-17.jpg" alt="indexpage12022-04-08_0143-17" style="zoom:25%;" />



### 二、登录模块

1. 开发注册功能

<img src="./effectpicture/mlogin/register2022-04-14_02-45-55.jpg" alt="register2022-04-14_02-45-55" style="zoom:25%;" />

2. 开发登录功能

<img src="./effectpicture/mlogin/login2022-04-14_02-49-49.jpg" alt="login2022-04-14_02-49-49" style="zoom:25%;" />



<img src="./effectpicture/mlogin/loginpostXnip2022-04-14_02-51-50.jpg" alt="loginpostXnip2022-04-14_02-51-50" style="zoom:25%;" />
