INSERT INTO oauth_client_details (
    client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove
) VALUES ('clientIdAuthorizationCode', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'read,write','authorization_code',
     'http://localhost:9001/callback', null, 36000, 36000, null, true);

INSERT INTO oauth_client_details (
    client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove
) VALUES ('clientIdClient', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'read,write','client_credentials',
     null, null, 36000, 36000, null, true);

INSERT INTO oauth_client_details (
    client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove
) VALUES ('clientIdImplicit', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'read,write','implicit',
     'http://localhost:9001/callback', null, 36000, 36000, null, true);

INSERT INTO oauth_client_details (
    client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove
) VALUES ('clientIdPassword', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'read,write','password',
     null, null, 36000, 36000, null, true);

INSERT INTO oauth_client_details (
    client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove
) VALUES ('all', '$2a$10$/1CPXEyPp816UIzMaLEQB.drwpyF5S9FX9pbHllHjUhS67VaDj5.y', 'read,write','authorization_code,client_credentials,implicit,password,refresh_token',
     'http://localhost:9001/callback', null, 36000, 36000, null, true);



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