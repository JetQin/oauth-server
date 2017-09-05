drop table if exists user_role;
drop table if exists role;
drop table if exists user;

CREATE TABLE user ( 
  user_id BIGINT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(50) NOT NULL, 
  email VARCHAR(50), 
  password VARCHAR(500), 
  activated BOOLEAN DEFAULT FALSE, 
  activationkey VARCHAR(50) DEFAULT NULL, 
  resetpasswordkey VARCHAR(50) DEFAULT NULL, 
  primary key (user_id)
 ); 
 
 
 CREATE TABLE role ( 
  role_id bigint not null auto_increment,
  role_name varchar(50) not null,
  role_description VARCHAR(50), 
  PRIMARY KEY (role_id)
 ); 
 

 CREATE TABLE user_role ( 
   user_id BIGINT NOT NULL, 
   role_id BIGINT NOT NULL, 
   FOREIGN KEY (user_id) REFERENCES user (user_id), 
   FOREIGN KEY (role_id) REFERENCES role (role_id), 
   UNIQUE INDEX user_authority_idx_1 (user_id, role_id), 
   primary key(user_id,role_id)
 ); 
 
drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);
 
drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);
 
drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(255)
);
 
drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);
 
drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(255), authentication LONG VARBINARY
);
 
drop table if exists oauth_approvals;
create table oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT CURRENT_TIMESTAMP
);
 
drop table if exists clientdetails;
create table clientdetails (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);


 INSERT INTO user (user_name,email, password, activated) VALUES ('admin', 'admin@mail.me', 'b8f57d6d6ec0a60dfe2e20182d4615b12e321cad9e2979e0b9f81e0d6eda78ad9b6dcfe53e4e22d1', true); 
 INSERT INTO user (user_name,email, password, activated) VALUES ('user', 'user@mail.me', 'd6dfa9ff45e03b161e7f680f35d90d5ef51d243c2a8285aa7e11247bc2c92acde0c2bb626b1fac74', true); 
 INSERT INTO user (user_name,email, password, activated) VALUES ('rajith', 'rajith@abc.com', 'd6dfa9ff45e03b161e7f680f35d90d5ef51d243c2a8285aa7e11247bc2c92acde0c2bb626b1fac74', true); 
 INSERT INTO role (role_name) VALUES ('ROLE_USER'); 
 INSERT INTO role (role_name) VALUES ('ROLE_ADMIN'); 
 INSERT INTO user_role (user_id,role_id) VALUES (1, 1); 
 INSERT INTO user_role (user_id,role_id) VALUES (1, 2); 
 INSERT INTO user_role (user_id,role_id) VALUES (2, 1); 
 INSERT INTO user_role (user_id,role_id) VALUES (3, 1);