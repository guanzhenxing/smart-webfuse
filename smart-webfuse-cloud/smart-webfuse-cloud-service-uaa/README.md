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