# smart-webfuse

本项目分为两个子项目：smart-webfuse-admin和smart-webfuse-cloud。

smart-webfuse-admin是一个单体的实验性项目，smart-webfuse-cloud是一个实验性的微服务项目。

## smart-webfuse-admin

## smart-webfuse-cloud

本项目是基于Spring Boot、Spring Cloud等框架搭建的微服务项目。

### 快速开始

### 技术栈

* Spring Boot - 基于Spring的约定大于配置的产品级别项目构建框架。本项目中使用的是基于Spring Boot封装的基本开发框架[webfuse](https://github.com/guanzhenxing/webfuse)。
* Eureka - Eureka是Netflix开发的服务发现框架，本身是一个基于REST的服务。用于服务注册和故障转移。
* Feign - 一种HTTP客户端，可用于服务发现。它提供了多种负载均衡策略来实现客户端负载均衡。
* Ribbon - 是一种声明式、模板化的HTTP客户端。可用于服务发现。
* Hystrix - 熔断器，容错管理工具，该框架目标在于通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。
* Spring Cloud OAuth2 - 基于Spring Security和OAuth2的安全开发框架。
* Spring Cloud Config - 集中式配置管理中心开发框架。
* Spring Cloud Zuul - 基于Zuul的网关。
* Spring Cloud Bus - 事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。
* Spring Cloud Stream - Spring数据流操作开发包，封装了与Redis、Rabbit、Kafka等发送接收消息。
* Spring Cloud Sleuth - 日志收集工具框架，封装了Dapper和log-based追踪以及Zipkin和HTrace操作，为SpringCloud应用实现了一种分布式追踪解决方案。
* Zipkin - Zipkin是Twitter的一个开源项目，它基于Google Dapper实现。使用它来收集各个服务器上请求链路的跟踪数据。
* Turbine - 用于Hystrix数据的整合。


### 应用架构

* 服务注册
* 服务发现
* 负载均衡
* 配置管理
* 断路器
* API网关
* 每个服务一个数据库
* 消息驱动的微服务
* 事件源
* CQRS
* 访问令牌
* 消费者驱动的契约测试
* 日志聚合
* 应用监控
* 审计日志
* 分布式追踪
* 异常追踪
* 健康监测
* 每个服务一个容器

#### 系统架构图

#### 服务组件图











