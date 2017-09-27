insert into role(role_id, role_name) values('1', 'INSTITUTION');
insert into role(role_id, role_name) values('2', 'SUPPLIER');
insert into role(role_id, role_name) values('3', 'NS');

insert into user(user_id, department_identifier, ministry_description, name, role_id, username, password, 
is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) 
values('testuser','Test','National Security' , 'Test', '3', 'test', 'test', 1, 1, 1, 1);

