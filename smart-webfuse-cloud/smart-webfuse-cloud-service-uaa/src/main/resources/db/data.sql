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


insert into user(id, name, login, password) values (1,'admin','admin','$2a$10$ZCoYzZYVgOrdGG/Tn9Ts2eltuV/DsyIPvJIKW8IoZginOcBIe9M7u');
insert into user(id, name, login, password) values (2,'jesen','jesen','$2a$10$ZCoYzZYVgOrdGG/Tn9Ts2eltuV/DsyIPvJIKW8IoZginOcBIe9M7u');
insert into user(id, name, login, password) values (3,'hing','hing','$2a$10$ZCoYzZYVgOrdGG/Tn9Ts2eltuV/DsyIPvJIKW8IoZginOcBIe9M7u');

insert into role(id, name) values (1,'ROLE_ADMIN');
insert into role(id, name) values (2,'ROLE_USER');
insert into role(id, name) values (3,'ROLE_GUEST');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,3);
insert into user_role(user_id, role_id) values (3,3);