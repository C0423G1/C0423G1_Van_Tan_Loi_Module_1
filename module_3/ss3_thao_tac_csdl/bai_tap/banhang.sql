create database hang;
use hang ;
create table customer(
c_id int auto_increment primary key,
c_name varchar(45),
c_age int);
create table orders(
o_id int auto_increment primary key,
c_id int,
o_date date,
o_tatalprice double
);
create table product(
p_id int auto_increment primary key,
p_name varchar(45),
p_price double);
create table orderdetail(
o_id int,
p_id int,
od_qty int,
primary key(o_id,p_id),
foreign key(o_id) references orders(o_id),
foreign key(p_id) references product(p_id)
);
-- ----------------------------------------------------------------------------------------------------------------------------------
INSERT INTO customer (c_id, c_name, c_age)
VALUES (1, 'Minh Quan', 10),
       (2, 'Ngoc Oanh', 20),
       (3, 'Hong Ha', 50);
INSERT INTO orders (o_id, c_id, o_date)
VALUES (1, 1, '2006-03-21'),
       (2, 2, '2006-03-23'),
       (3, 1, '2006-03-16');
INSERT INTO product (p_id, p_name, p_price)
VALUES (1, 'May Giat', 3),
       (2, 'Tu Lanh', 5),
       (3, 'Dieu Hoa', 7),
       (4, 'Quat', 1),
       (5, 'Bep Dien', 2);
INSERT INTO orderdetail (o_id, p_id, od_qty)
VALUES (1, 1, 3),
       (1, 3, 7),
       (1, 4, 2),
       (2, 1, 3),
       (2, 5, 4),
       (2, 3, 3);
-- ------------------------------------------[Bài tập] Thao tác với CSDL Quản lý bán hàngAssignment---------------------------------- 
use hang ;
SELECT o_id, o_date, o_tatalprice
FROM orders;
SELECT c.c_name AS customer_name, p.p_name AS product_name
FROM customer c
JOIN orders o ON c.c_id = o.c_id
JOIN orderdetail od ON o.o_id = od.o_id
JOIN product p ON od.p_id = p.p_id;
SELECT c.c_name AS customer_name
FROM customer c
LEFT JOIN orders o ON c.c_id = o.c_id
WHERE o.o_id IS NULL;
SELECT o.o_id AS order_id, o.o_date AS order_date,
    SUM(od.od_qty * p.p_price) AS total_price
FROM orders o
JOIN orderdetail od ON o.o_id = od.o_id
JOIN product p ON od.p_id = p.p_id
GROUP BY o.o_id, o.o_date;



