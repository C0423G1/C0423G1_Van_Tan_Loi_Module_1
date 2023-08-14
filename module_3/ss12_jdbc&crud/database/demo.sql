create database demo_thi;
use demo_thi;
create table category (
id int primary key auto_increment,
name_category varchar(255));
create table book (
id_book int primary key auto_increment,
title varchar(255),
page_size	int,
author	varchar(255),
id int,
foreign key (id) references category(id)
);
select book.id_book,book.title,book.page_size,book.author,category.name_category 
from book 
join category on category.id=book.id;
INSERT INTO demo_thi.book (title,page_size,author,id) VALUES (?,?,?,?);
select * from category;
DELETE FROM demo_thi.book WHERE id_book = 14;
