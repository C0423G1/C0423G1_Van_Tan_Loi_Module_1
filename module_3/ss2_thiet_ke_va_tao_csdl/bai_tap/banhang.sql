create database ban_hang;
use ban_hang ;
create table Customer(
cID int auto_increment primary key,
cName varchar(45),
cAge int);
create table `order`(
oID int auto_increment primary key,
cID int,
oDate date,
oTatalPrice double
);
create table orderdetail(
oID int,
pID int,
primary key(oID,pID),
foreign key(oID) references `order`(oID),
foreign key(pID) references product(pID)
);
create table product(
pID int auto_increment primary key,
pName varchar(45),
pPrice double);