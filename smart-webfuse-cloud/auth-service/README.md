# User Account and Authentication（UAA）Server - 用户与权限认证服务

UAA是一个用于管理账户、用户鉴权等的服务。


## 术语

- 应用：App应用、Web应用、应用服务或者第三方应用，拥有唯一的appId。
- 领域：Realm，角色的定义范围。包括<global:应用内全局角色>；<comp:组件内角色>；业务角色<group:IM群角色；forum:论坛版块角色>
- 角色：Role，一组权限的集合。角色必须定义在指定领域内
- 资源：Resource，主要应用于前端UI元素可见性方面的权限管控
- 操作：Action，主要应用于服务端api调用合法性方面的管控
- 权限：Permission，一组“资源+操作”的组合，并具备一个用户易于理解的名称
- 模板：Template，一个或多个“角色+权限+资源”的镜像内容，某一组件在某一个租户下一般会有一个默认的模板内容；根据面向主体分为两类：用户模板，管理员模板；
- 用户模板：User Template,普通用户角色对应的权限集合
- 管理员模板：Admin Template,管理员角色对应的权限集合


## 重要的参考资料


## 踩过的坑

**AuthorizationServerConfig 、 WebSecurityConfig 和 ResourceServerConfig 的顺序**

- WebSecurityConfigurerAdapter 是默认情况下 spring security 的 http 配置
- ResourceServerConfigurerAdapter 是默认情况下 spring security oauth2 的 http 配置

AuthorizationServerConfig 的 order 为 0， ResourceServerConfig 的 order 为 1， WebSecurityConfig 默认为 100。 
所以，ResourceServerConfig 的优先级是高于 WebSecurityConfig 的，优先级高的 http 配置是可以覆盖优先级低的配置的。具体要怎么配置就看代码结构了。
不正确的位置配置会引起 "User must be authenticated with Spring Security before authorization can be completed." 和 "Full authentication is required to access this resource oauth2."

**Authorize Requests**

关于`void configure(HttpSecurity http)`这个方法踩了很多次坑。具体见[6.4 Authorize Requests](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#jc-authorize-requests)

```
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()                                                                ①
            .antMatchers("/resources/**", "/signup", "/about").permitAll()                  ②
            .antMatchers("/admin/**").hasRole("ADMIN")                                      ③
            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            ④
            .anyRequest().authenticated()                                                   ⑤
            .and()
        // ...
        .formLogin();
}
```
- ① 对请求进行授权，这个方法下面的都是授权的配置
- ② 添加匹配器，允许匹配的请求不需要进行认证（permitAll()）
- ③ 添加匹配器，只有具有“ADMIN”角色的认证用户才能访问“/admin”接口
- ④ 添加匹配器，只有同时拥有“ADMIN”角色和“DBA”角色的认证用户才能访问“/db”接口
- ⑤ 对其他的所有请求都需要身份认证。

所有的匹配器`antMatchers`必须要放在`.anyRequest().authenticated()`之前配置。因为会存在覆盖关系，故AuthorizeConfigProvider的定义需要指定先后顺序，使用@Order。



