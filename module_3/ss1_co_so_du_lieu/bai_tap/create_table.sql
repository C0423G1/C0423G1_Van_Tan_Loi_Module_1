create database student_management1;
use student_management1;
create table Class (
id_class int auto_increment,
name_class varchar(100),
primary key (id_class)
);
create table Teacher (
id_teacher int auto_increment,
name_teacher varchar(100),
ago_teacher int ,
country_teacher varchar(100),
primary key (id_teacher));