create database hang_hoa;
use hang_hoa;
create table phieu_xuat(
so_px int primary key,
ngay_xuat date
);
create table vat_tu(
ma_vtu int primary key,
ten_vtu varchar(45));
create table chi_tiet_phieu_xuat(
so_px int,
ma_vtu int,
dg_xuat double,
sl_xuat double,
primary key(so_px,ma_vtu),
foreign key(so_px) references phieu_xuat(so_px),
foreign key(ma_vtu) references vat_tu(ma_vtu));
create table phieu_nhap(
so_pn int primary key,
ngay_nhap date);
create table chi_tiet_phieu_nhap (
so_pn int,
ma_vtu int,
dg_nhap double,
sl_nhap double,
primary key(so_pn,ma_vtu),
foreign key(so_pn) references phieu_nhap(so_pn),
foreign key(ma_vtu) references vat_tu(ma_vtu));
create table nha_cc(
ma_ncc int auto_increment primary key,
ten_ncc varchar(45),
dia_chi varchar(100)
);
create table sdt(
ma_ncc int ,
phone varchar(20) primary key,
foreign key(ma_ncc) references nha_cc(ma_ncc));
create table don_dh(
so_dh int auto_increment primary key,
ngay_dh date,
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc));
create table chi_tiet_don_hang(
so_dh int,
ma_vtu int,
primary key(so_dh,ma_vtu),
foreign key(so_dh)references don_dh(so_dh),
foreign key(ma_vtu) references vat_tu(ma_vtu));