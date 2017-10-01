create schema ns_asset_mgt;

create table role(role_id VARCHAR(255) PRIMARY KEY, role_name VARCHAR(255));

create table user(user_id VARCHAR(255) PRIMARY KEY, department_identifier VARCHAR(255),is_account_non_expired INTEGER, is_account_non_locked INTEGER,
is_credentials_non_expired INTEGER, is_enabled INTEGER, ministry_description VARCHAR(255), name VARCHAR(255), 
password VARCHAR(255), position VARCHAR(255), role_id VARCHAR(255), username VARCHAR(255))