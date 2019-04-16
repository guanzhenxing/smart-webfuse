INSERT INTO oauth_client_details (
client_id, client_secret, scope, authorized_grant_types,web_server_redirect_uri, authorities, access_token_validity,refresh_token_validity, additional_information, autoapprove
) VALUES (
'browser', null, 'ui','password,refresh_token',null, null, 36000, 36000, null, true);

INSERT INTO oauth_client_details (
client_id, client_secret, scope, authorized_grant_types,web_server_redirect_uri, authorities, access_token_validity,refresh_token_validity, additional_information, autoapprove
) VALUES (
'statistics-service', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'server','client_credentials,refresh_token',null, null, 36000, 36000, null, true);

INSERT INTO oauth_client_details (
client_id, client_secret, scope, authorized_grant_types,web_server_redirect_uri, authorities, access_token_validity,refresh_token_validity, additional_information, autoapprove
) VALUES (
'account-service', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'server','client_credentials,refresh_token',null, null, 36000, 36000, null, true);

INSERT INTO oauth_client_details (
client_id, client_secret, scope, authorized_grant_types,web_server_redirect_uri, authorities, access_token_validity,refresh_token_validity, additional_information, autoapprove
) VALUES (
'notification-service', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'server','client_credentials,refresh_token',null, null, 36000, 36000, null, true);

insert into users (username,password,enabled) values ('admin','$2a$10$ZCoYzZYVgOrdGG/Tn9Ts2eltuV/DsyIPvJIKW8IoZginOcBIe9M7u',true);
insert into users (username,password,enabled) values ('jesen','$2a$10$ZCoYzZYVgOrdGG/Tn9Ts2eltuV/DsyIPvJIKW8IoZginOcBIe9M7u',true);
insert into users (username,password,enabled) values ('hing','$2a$10$ZCoYzZYVgOrdGG/Tn9Ts2eltuV/DsyIPvJIKW8IoZginOcBIe9M7u',true);

insert into authorities (username,authority) values ('admin','ROLE_ADMIN');
insert into authorities (username,authority) values ('jesen','ROLE_USER_ADMIN');
insert into authorities (username,authority) values ('hing','ROLE_API_ADMIN');

insert into groups (id,group_name) values (1,'webfuse');

insert into group_authorities (group_id,authority) values (1,'ROLE_MONITOR_ADMIN');
insert into group_authorities (group_id,authority) values (1,'ROLE_USER');

insert into group_members (username,group_id) values ('admin',1);
insert into group_members (username,group_id) values ('jesen',1);
insert into group_members (username,group_id) values ('hing',1);