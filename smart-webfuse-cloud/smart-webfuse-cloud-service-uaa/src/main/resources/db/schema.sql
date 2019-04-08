create table oauth_access_token (
  authentication_id varchar(256) NOT NULL,
  token_id varchar(256),
  token bytea,
  user_name varchar(256),
  client_id varchar(256),
  authentication bytea,
  refresh_token varchar(256),
  primary key (authentication_id)
);

create table oauth_refresh_token (
  token_id varchar(256),
  token bytea,
  authentication bytea
);

create table app_user (
  user_email varchar(256) NOT NULL,
  user_pass varchar(256) NOT NULL,
  user_role varchar(256) NOT NULL,
  primary key (user_email)
);