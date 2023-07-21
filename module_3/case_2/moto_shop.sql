CREATE DATABASE motorbike_strore;
use  motorbike_strore;
CREATE TABLE xe_moto (
    id_xe_moto INT AUTO_INCREMENT PRIMARY KEY,
    ten_mau VARCHAR(100),
    hang_san_xuat VARCHAR(100),
    nam_san_xuat INT,
    dung_tich_dong_co FLOAT,
    mo_ta TEXT,
    hinh_anh TEXT,
    id_hang_xe int,
    foreign key (id_hang_xe) REFERENCES hang_xe(id_hang_xe)
);
CREATE TABLE accounts (
    id_tai_khoan INT AUTO_INCREMENT PRIMARY KEY,
    id_role int , 
    tai_khoan VARCHAR(100),
	mat_khau VARCHAR(100),
	foreign key (id_role) REFERENCES role(id_role)
);
CREATE TABLE nguoi_mua (
    id_nguoi_mua INT AUTO_INCREMENT PRIMARY KEY,
    ten VARCHAR(100),
    thong_tin_lien_he VARCHAR(100),
    ngay_sinh DATE,
    gioi_tinh BIT(1),
    email VARCHAR(100),
    dia_chi VARCHAR(200),
    id_tai_khoan int,
    foreign key (id_tai_khoan) REFERENCES accounts(id_tai_khoan)
);
create table `role`(
id_role int primary key,
name_role VARCHAR(100));
CREATE TABLE danh_muc_xe (
    id_danh_muc INT AUTO_INCREMENT PRIMARY KEY,
    ten_danh_muc VARCHAR(100)
);

CREATE TABLE hang_xe (
    id_hang_xe INT AUTO_INCREMENT PRIMARY KEY,
    id_danh_muc INT,
    ten_loai_xe VARCHAR(100),
    FOREIGN KEY (id_danh_muc) REFERENCES danh_muc_xe(id_danh_muc)
);
CREATE TABLE binh_luan (
    id_binh_luan INT AUTO_INCREMENT PRIMARY KEY,
    id_xe_moto INT,
    noi_dung TEXT,
    diem_danh_gia FLOAT,
    FOREIGN KEY (id_xe_moto) REFERENCES xe_moto(id_xe_moto)
);
CREATE TABLE gio_hang (
    id_gio_hang INT AUTO_INCREMENT PRIMARY KEY,
    id_nguoi_mua INT,
    so_luong INT,
    FOREIGN KEY (id_nguoi_mua) REFERENCES nguoi_mua(id_nguoi_mua)
);
CREATE TABLE don_hang (
    id_don_hang INT AUTO_INCREMENT PRIMARY KEY,
    id_gio_hang INT,
    so_luong INT,
    tong_tien FLOAT,
    phuong_thuc_thanh_toan VARCHAR(100),
    FOREIGN KEY (id_gio_hang) REFERENCES gio_hang(id_gio_hang)
);
CREATE TABLE phu_kien (
  id_phu_kien int auto_increment primary key,
  id_gio_hang int,
  id_hang_xe int,
  id_loai_phu_kien int,
  ten_phu_kien varchar(100),
  gia_phu_kien double,
  FOREIGN KEY (id_gio_hang) REFERENCES gio_hang(id_gio_hang),
  FOREIGN KEY (id_hang_xe) REFERENCES hang_xe(id_hang_xe),
  FOREIGN KEY (id_loai_phu_kien) REFERENCES loai_phu_kien(id_loai_phu_kien)
);
create table loai_phu_kien (
id_loai_phu_kien int auto_increment primary key,
ten_loai_phu_kien varchar(45));

