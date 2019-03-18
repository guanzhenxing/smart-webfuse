# smart-webfuse

一些示例项目。比如：微服务示例项目等。

## smart-webfuse-cloud

参考[中国式微服务技术栈2.0](http://jskillcloud.com/post/2018-05-27-msa-tech-stack-chinese-style/) 和[微服务2.0技术栈选型手册](http://jskillcloud.com/post/2018-05-29-msa-2.0-tech-stack-selection)

在[微服务2.0技术栈选型手册](http://jskillcloud.com/post/2018-05-29-msa-2.0-tech-stack-selection)中，作者[杨波](http://jskillcloud.com/top/about/)列了以下的图：

![微服务基础架构](http://jskillcloud.com/img/post/2018052902/msa_arch.png)

![微服务架构总体技术体系](http://jskillcloud.com/img/post/2018052902/msa_system.png)

所以在此demo中大概完成以下组件内容：

**核心支撑组件:**

- 服务注册发现Eureka+Ribbon/Feign
- 配置中心Spring Cloud Config
- 服务网关Zuul(Spring Cloud Zuul)
- 认证授权中心Spring Security OAuth2
- 服务框架Spring MVC/Boot

**监控反馈组件:**

- 限流熔断和流聚合Hystrix/Turbine
- 数据总线Kafka
- 日志监控ELK
- 调用链监控(ZipKin)
- Metrics监控KairosDB
- 健康检查和告警ZMon

### 服务注册与发现

#### 服务注册

服务注册中心基于Eureka。

在此Demo中使用单节点的Eureka，如果是生产环境，可以使用多节点来保证高可用。

#### 服务发现

服务发现使用Ribbon和Feign。

内部微服务直连可以直接走Ribbon客户端软负载，网关上也可以部署Ribbon，这时网关相当于一个具有路由和软负载能力的超级客户端。

使用Feign是有的时候会使用api-jar模式。


### 分布式配置中心

分布式配置中心应该能够集中化管理应用不同环境、不同集群的配置，配置修改后能够实时推送到应用端，并且具备规范的权限、流程治理等特性。

Spring Cloud Config产品，但是功能远远达不到生产级，只能小规模场景下用，中大规模企业级场景不建议采用。但由于此项目是Demo级别的，所以使用的是Spring Cloud Config，在生产中一样可以进行切换为Apollo。

可以使用：

- [ctripcorp/apollo](https://github.com/ctripcorp/apollo)：携程框架部门研发的分布式配置中心。
- [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)，可以参考的项目有：
    - [spring-cloud-config-admin](https://github.com/dyc87112/spring-cloud-config-admin)
    - [config-keeper](https://www.oschina.net/p/configkeeper)
    
### 服务网关

可以选择的网关产品有：Spring Cloud Gateway、Zuul、Kong等。

这里为了演示项目，选择Spring Cloud Gateway。

### 认证授权中心

OAuth2是一种基于令牌Token的授权框架，已经得到众多大厂的支持，可以认为是事实上的微服务安全协议标准，适用于多种场景。

Spring Security OAuth2是Spring Security基础上的一个扩展，支持四种主要的OAuth2 Flows，基本可以作为微服务认证授权中心的推荐产品。

### 通用服务框架

基于Spring Boot，实现以下功能：

- 注册到Eureka
- 服务发现（Ribbon和Feign）
- Hystrix熔断器
- ...

### 限流熔断和流聚合Hystrix+Turbine

Turbine是和Hystrix配套的一个流聚合服务，能够对Hystrix监控数据流进行聚合，聚合以后可以在Hystrix Dashboard上看到集群的流量和性能情况。

### 数据总线Kafka

在监控一块，日志和Metrics等数据可以通过Kafka做收集、存储和转发，相当于中间增加了一个大容量缓冲，能够应对海量日志数据的场景。
除了日志监控数据收集，Kafka在业务大数据分析，IoT等场景都有广泛应用。
如果对Kafka进行适当定制增强，还可以用于传统消息中间件场景。

### 日志监控ELK

ELK（ElasticSearch/Logstash/Kibana）是日志监控一块的标配技术栈。

[ELK + Kafka参考部署架构](http://jskillcloud.com/img/post/20180527/elk_kafka_deployment.png)

### 调用链监控

可以使用的产品有：Zipkin，CAT

Spring Cloud支持基于Zipkin的调用链监控，Zipkin还不能算一款企业级调用链监控产品，充其量只能算是一个半成品，很多重要的企业级特性缺失。

CAT是一款更完整的企业级调用链监控产品，甚至已经接近一个APM（Application Performance Management）产品的范畴，它不仅支持调用链的查询和可视化，还支持细粒度的调用性能数据统计报表。

由于是Demo产品，所以这边的选择是Zipkin

### Metrics监控KairosDB

### 健康检查和告警ZMon






