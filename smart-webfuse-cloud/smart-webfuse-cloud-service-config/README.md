
# 配置中心

## Spring Cloud Config

Spring Cloud Config可以作为配置中心。但是官方没有提供界面，操作比较难。可以参见一些第三方的扩展项目：

- https://github.com/dyc87112/spring-cloud-config-admin
- https://www.oschina.net/p/configkeeper

可以在demo环境使用。

## Apollo

[ctripcorp/apollo](https://github.com/ctripcorp/apollo)是携程开源的配置中心，是一个生产级别的开源项目。建议在生产环境的时候使用它。

## 项目现状

项目是用来做一个微服务测试的，暂时的做法是使用Spring Cloud Config作为配置中心，使用本地的文本配置文件作为配置项。后期考虑使用数据库。 

