-- 这一部分是公共配置，也就是不管在哪个系统哪个环境中都会使用到的
insert into properties (`key`,`value`,application,profile,label) values ('management.endpoints.enabled-by-default','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('management.endpoints.web.exposure.include','*','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('management.endpoint.health.show-details','always','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('management.endpoint.shutdown.enabled','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('management.endpoint.env.enabled','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('spring.cloud.loadbalancer.retry.enabled','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('spring.http.converters.preferred-json-mapper','jackson','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('spring.http.encoding.charset','UTF-8','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('spring.http.encoding.enabled','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('spring.http.encoding.force','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('eureka.client.healthcheck','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('eureka.instance.prefer-ip-address','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('ribbon.OkToRetryOnAllOperations','false','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('ribbon.eager-load.enabled','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('feign.compression.request.enabled','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('feign.compression.response.enabled','true','application','default','master');
insert into properties (`key`,`value`,application,profile,label) values ('feign.hystrix.enabled','true','application','default','master');

-- 这一部分是开发环境的公共配置
insert into properties (`key`,`value`,application,profile,label) values ('eureka.client.service-url.defaultZone','http://eureka-admin:eureka-admin-pwd@localhost:2000/eureka/','application','dev','master');
insert into properties (`key`,`value`,application,profile,label) values ('ribbon.MaxAutoRetries','1','application','dev','master');
insert into properties (`key`,`value`,application,profile,label) values ('ribbon.MaxAutoRetriesNextServer','2','application','dev','master');
insert into properties (`key`,`value`,application,profile,label) values ('ribbon.ConnectTimeout','3000','application','dev','master');
insert into properties (`key`,`value`,application,profile,label) values ('ribbon.ReadTimeout','5000','application','dev','master');
insert into properties (`key`,`value`,application,profile,label) values ('ribbon.ServerListRefreshInterval','2000','application','dev','master');
insert into properties (`key`,`value`,application,profile,label) values ('hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds','10000','application','dev','master');