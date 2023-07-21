create database dong_ho ;
use dong_ho;
CREATE TABLE `admin` (
    ma_quan_tri INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255)
);
create table tai_khoan (
ma_tai_khoan int primary key auto_increment,
ten_tai_khoan varchar(100),
mat_khau varchar(100),
ma_quan_tri int ,
 FOREIGN KEY (ma_quan_tri) REFERENCES `admin`(ma_quan_tri)
);
CREATE TABLE nguoi_mua (
    ma_nguoi_mua INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255),
    gender bit(1),
    phone varchar(20),
    email varchar(45),
    ma_tai_khoan int,
    FOREIGN KEY (ma_tai_khoan) REFERENCES tai_khoan(ma_tai_khoan)
);
CREATE TABLE hang_dong_ho (
    ma_hang INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255)
);
CREATE TABLE dong_ho (
    ma_dong_ho INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255),
    gia DECIMAL(10, 2),
    ma_hang INT,
    FOREIGN KEY (ma_hang) REFERENCES hang_dong_ho(ma_hang)
);
CREATE TABLE gio_hang (
    ma_gio_hang INT PRIMARY KEY AUTO_INCREMENT,
    ma_nguoi_mua INT,
    ma_dong_ho int,
    so_luong int,
    FOREIGN KEY (ma_nguoi_mua) REFERENCES nguoi_mua(ma_nguoi_mua),
	FOREIGN KEY (ma_dong_ho) REFERENCES dong_ho(ma_dong_ho)
);
CREATE TABLE don_hang (
    ma_don_hang INT PRIMARY KEY AUTO_INCREMENT,
    ma_gio_hang INT,
    ngay_len_don date,
    ngay_giao_hang date,
    FOREIGN KEY (ma_gio_hang) REFERENCES gio_hang(ma_gio_hang)
);

