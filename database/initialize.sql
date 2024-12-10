create database webuserlist_v1;
use webuserlist_v1;
create table Users(UserId int NOT NULL UNIQUE AUTO_INCREMENT, UserName varchar(256), RoleId int);
create table Roles(RoleName varchar(256), RoleId int NOT NULL UNIQUE AUTO_INCREMENT);
insert into Roles (RoleName) values ("admin"), ("editor"), ("author"), ("contributor"), ("subscriber");
insert into Users (UserName, RoleId) values ("Iga", 1), ("Jannik", 2), ("Jasmine", 1), ("Naomi", 2), ("Karolina", 5);
create user 'user'@'%' identified by 'pieski123';
grant select, insert, delete on webuserlist_v1.Users to 'user'@'%';
grant select, insert, delete on webuserlist_v1.Roles to 'user'@'%';
