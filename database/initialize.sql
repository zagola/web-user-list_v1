create database webuserlist_v1;
use webuserlist_v1;
create table users(user_id int NOT NULL UNIQUE AUTO_INCREMENT, user_name varchar(256), role_id int);
create table roles(role_name varchar(256), role_id int NOT NULL UNIQUE AUTO_INCREMENT);
insert into roles (role_name) values ("admin"), ("editor"), ("author"), ("contributor"), ("subscriber");
insert into users (user_name, role_id) values ("Iga", 1), ("Jannik", 2), ("Jasmine", 1), ("Naomi", 2), ("Karolina", 5);
create user 'user'@'%' identified by 'pieski123';
grant select, insert, delete on webuserlist_v1.users to 'user'@'%';
grant select, insert, delete on webuserlist_v1.roles to 'user'@'%';
