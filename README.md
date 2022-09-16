# FromZerotoExpert
Complete a JavaWeb Project. 帅地从零到一个完整的JavaWeb项目。

# 已完成部分
1. GitHub以及Git集成已完成，所有的push现在都在 dev 分支。
1. 因为JavaWeb是很久以前看的，现在回顾了一下 Servlet的内容，使用IDEA 的JavaEE模板构建了一个Web项目（里面甚至还有一个jsp文件）。因为零基础，所以暂时写了一个自定义的Servlet，可以访问。

# 实现
## 创建一个Web服务
参考的是B站播放量高的黑马的一个视频。
自己下载 Tomcat，与 IDEA集成，然后创建一个 包含 Maven和Web规范的JavaEE项目。
自己在src里面找到默认的模板，仿照写一个功能是 输出指定内容的Servlet即可。

打卡的要求是 要求打开 
> 创建一个 web 服务，在浏览器输入http://localhost/FromZerotoExpert这个地址后，出现一个 html 页面，页面展示 嗨，欢迎您来到 from zero to expert.。

Servlet的的部分没什么问题，但是设置 端口为80和 配置资源路径是靠自己摸索出来的。
端口的部分我知道改，但是嫌麻烦和排查原因困难所以使用的默认端口，默认URL的话是改的 Tomcat的配置选项：
Edit Configuration -> Deployment -> Application Context 设置为 **一个斜杠**。代表默认的**项目启动路径就是根路径**。