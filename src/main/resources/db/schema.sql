--操作
DROP TABLE IF EXISTS action;
CREATE TABLE IF NOT EXISTS action (
  id BIGINT AUTO_INCREMENT ,  --操作id
  name VARCHAR(200) NOT NULL, --操作名称。全局唯一：包名.类型.方法名
  display_name VARCHAR(200) NOT NULL, --显示出来的名称（API名称）。
  biz_type VARCHAR(20) NULL,  --服务类型（待定）
  api_url VARCHAR(200) NOT NULL,  --Restful API。显示用
  enabled TINYINT DEFAULT TRUE
);
CREATE PRIMARY KEY ON action(id);

--资源
DROP TABLE IF EXISTS resource;
CREATE TABLE IF NOT EXISTS resource(
  id BIGINT AUTO_INCREMENT ,  --资源ID
  client_type VARCHAR(16) NULL, --客户端类型，取值：app，web，admin
  name VARCHAR(200) NOT NULL, -- 资源标识符，客户端控制用，全局唯一
  display_name VARCHAR(200) NOT NULL, --显示名称
  tag VARCHAR(50) NULL, --资源标签
  enabled TINYINT DEFAULT TRUE
);
CREATE PRIMARY KEY ON resource(id);

--权限
DROP TABLE IF EXISTS permission;
CREATE TABLE IF NOT EXISTS permission (
  id BIGINT AUTO_INCREMENT ,  --权限id
  name VARCHAR(64) NOT NULL,  --权限名称
  display_name VARCHAR(64) NOT NULL,  --权限显示名称
  status VARCHAR(8) NOT NULL, --状态，ENABLED（启用）,DISABLE（禁用）
  enabled TINYINT DEFAULT TRUE
);
CREATE PRIMARY KEY ON permission (id);
CREATE UNIQUE INDEX unique_permission_name ON permission(name);

-- 角色
DROP TABLE IF EXISTS role;
CREATE TABLE IF NOT EXISTS role (
  id BIGINT AUTO_INCREMENT ,  --角色id
  name VARCHAR(64) NOT NULL,  --角色名称
  display_name VARCHAR(64) NOT NULL,  --角色显示名称
  scope VARCHAR(16) NULL,  --角色作用域，global:应用内全局角色；app：app端角色；admin：管理端角色；web: web端角色
  -- realm_id BIGINT NULL ,  --领域的ID
  enabled TINYINT DEFAULT TRUE
);
CREATE PRIMARY KEY ON role (id);
CREATE UNIQUE INDEX unique_role_name ON role(name);

-- 用户
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
  id BIGINT AUTO_INCREMENT , --用户ID
  username VARCHAR(45) NOT NULL,  --用户名
  password VARCHAR(64) NOT NULL,  --密码
  account_non_expired TINYINT NULL, --用户是否过期
  account_non_locked TINYINT NULL,  --用户是否被锁
  credentials_non_expired TINYINT NULL, --证书是否存在
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP(),
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP(),
  enabled TINYINT DEFAULT TRUE
);
CREATE PRIMARY KEY ON user (id);

--用户角色关联
DROP TABLE IF EXISTS user_role;
CREATE TABLE IF NOT EXISTS user_role (
  id BIGINT AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL
);

--角色权限关联
DROP TABLE IF EXISTS role_permission;
CREATE TABLE IF NOT EXISTS role_permission (
  id BIGINT AUTO_INCREMENT,
  role_id BIGINT NOT NULL,
  permission_id BIGINT NOT NULL
);

--权限操作关联
DROP TABLE IF EXISTS permission_action;
CREATE TABLE IF NOT EXISTS permission_action(
  id BIGINT AUTO_INCREMENT,
  permission_id BIGINT NOT NULL,
  action_id BIGINT NOT NULL
);

--权限资源关联
DROP TABLE IF EXISTS permission_resource;
CREATE TABLE IF NOT EXISTS permission_resource(
  id BIGINT AUTO_INCREMENT,
  permission_id BIGINT NOT NULL,
  resource_id BIGINT NOT NULL
);




