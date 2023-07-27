create database booking_tour;
use booking_tour;

CREATE TABLE roles (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(50),
    description TEXT
);

CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    username VARCHAR(100) UNIQUE,
    passwords VARCHAR(255),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE loai_khach_hang (
    loai_khach_hang_id INT PRIMARY KEY,
    loai_khach_hang VARCHAR(100),
    mo_ta TEXT
);
CREATE TABLE khach_hang (
    khach_hang_id INT PRIMARY KEY,
    ho_ten VARCHAR(255),
    email VARCHAR(255),
    so_dien_thoai VARCHAR(20),
    dia_chi TEXT,
    loai_khach_hang_id INT,
    account_id INT,
    FOREIGN KEY (loai_khach_hang_id) REFERENCES loai_khach_hang(loai_khach_hang_id),
        FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
CREATE TABLE khu_vuc_tour (
    khu_vuc_tour_id INT PRIMARY KEY,
    khu_vuc_tour VARCHAR(100),
    mo_ta TEXT
);
create table employees_types(
id_employees_types int primary key auto_increment,
name_employees_types varchar(100));

create table employees(
id_employees int primary key auto_increment,
name_employees varchar(100),
so_dien_thoai varchar(10),
email varchar(100),
gender bit(1),
id_employees_types INT,
FOREIGN KEY (id_employees_types) REFERENCES employees_types(id_employees_types)
);

CREATE TABLE tour (
    tour_id INT PRIMARY KEY,
    ten_tour VARCHAR(255),
    mo_ta TEXT,
    gia DECIMAL(10, 2),
    ngay_bat_dau DATE,
    ngay_ket_thuc DATE,
    so_cho_trong INT,
    id_employees int,
    khu_vuc_tour_id INT,
    FOREIGN KEY (khu_vuc_tour_id) REFERENCES khu_vuc_tour(khu_vuc_tour_id),
	FOREIGN KEY (id_employees) REFERENCES employees(id_employees)
);

CREATE TABLE booking (
    booking_id INT PRIMARY KEY,
    khach_hang_id INT,
    ngay_dat DATE,
    tour_id INT,
	so_ve INT,
    FOREIGN KEY (tour_id) REFERENCES tour(tour_id),
    FOREIGN KEY (khach_hang_id) REFERENCES khach_hang(khach_hang_id)
);





