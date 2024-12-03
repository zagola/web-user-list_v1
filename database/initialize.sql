create database webuserlist_v1;
use webuserlist_v1;
create table Users(UserId int NOT NULL UNIQUE AUTO_INCREMENT, UserName varchar(256), RoleId int);
create table Roles(RoleName varchar(256), RoleId int NOT NULL UNIQUE AUTO_INCREMENT);
insert into Roles (RoleName) values ("admin"), ("editor"), ("author"), ("contributor"), ("subscriber");
insert into Users (UserName, RoleId) values ("Maria", 1), ("Jan", 2), ("Kamil", 1), ("Iga", 2), ("Kasia", 5);
create user 'user'@'%' identified by 'pieski123';
grant select, insert, delete on webuserlist_v1.Users to 'user'@'%';
grant select, insert, delete on webuserlist_v1.Roles to 'user'@'%';
