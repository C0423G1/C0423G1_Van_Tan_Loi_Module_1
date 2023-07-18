create database table_furama ;
use table_furama ;
create table vi_tri (
ma_vi_tri int auto_increment,
ten_vi_tri varchar(45),
primary key (ma_vi_tri));
create table trinh_do (
ma_trinh_do int auto_increment,
ten_trinh_do varchar(45),
primary key (ma_trinh_do));
create table bo_phan(
ma_bo_phan int auto_increment,
ten_bo_phan varchar(45),
primary key (ma_bo_phan));
create table nhan_vien(
ma_nhan_vien int auto_increment,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45) ,
luong double ,
so_dien_thoai int ,
email varchar(45),
dia_chi varchar(45),
primary key (ma_nhan_vien),
ma_vi_tri int ,
FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
ma_trinh_do int ,
foreign key (ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
ma_bo_phan int ,
foreign key (ma_bo_phan) REFERENCES bo_phan(ma_bo_phan));
create table loai_khach (
ma_loai_khach int auto_increment primary key ,
ten_loai_khach varchar(45)
);
create table khach_hang (
ma_khach_hang int auto_increment primary key,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_loai_khach int,
FOREIGN KEY (ma_loai_khach) REFERENCES loai_khach(ma_loai_khach));
create table loai_dich_vu (
ma_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45));
create table kieu_thue (
ma_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45));
create table dich_vu(
ma_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45),
dien_tich int ,
chi_phi_thue double,
so_nguoi_toi_da int ,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int ,
dich_vu_mien_phi_di_kem text,
ma_kieu_thue int ,
FOREIGN KEY(ma_kieu_thue) REFERENCES kieu_thue (ma_kieu_thue),
ma_loai_dich_vu int ,
FOREIGN KEY(ma_loai_dich_vu) REFERENCES loai_dich_vu (ma_loai_dich_vu)
);
create table hop_dong(
ma_hop_dong int auto_increment primary key,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int ,
FOREIGN KEY(ma_nhan_vien) REFERENCES nhan_vien (ma_nhan_vien),
ma_khach_hang int ,
FOREIGN KEY(ma_khach_hang) REFERENCES khach_hang (ma_khach_hang),
ma_dich_vu int ,
FOREIGN KEY(ma_dich_vu) REFERENCES dich_vu (ma_dich_vu));
create table dich_vu_di_kem (
ma_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45));
create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int auto_increment primary key,
ma_hop_dong int ,
FOREIGN KEY(ma_hop_dong) REFERENCES hop_dong (ma_hop_dong),
ma_dich_vu_di_kem int ,
FOREIGN KEY(ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem (ma_dich_vu_di_kem),
so_luong int);
insert table_furama.vi_tri(ten_vi_tri) value (" Quản Lý"),("Nhân Viên");
insert table_furama.trinh_do(ten_trinh_do) value ("Trung Cấp"),("Cao Đẳng"),("Đại Học"),("Sau Đại Học");
insert table_furama.bo_phan(ten_bo_phan) value ("Sale-Marketing"),("Hành chính"),("Phục vụ"),("Quản lý");
insert table_furama.nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) value (
"Nguyễn Văn An","1970-11-07","456231786",10000000,"0901234121","annguyen@gmail.com","295 Nguyễn Tất Thành, Đà Nẵng ",1,3,1),(
"Lê Văn Bình","	1997-04-09","654231234",7000000,"0934212314","binhlv@gmail.com","22 Yên Bái, Đà Nẵng",1,2,2),(
"Hồ Thị Yến","1995-12-12","999231723",14000000,"0412352315","thiyen@gmail.com","K234/11 Điện Biên Phủ, Gia Lai",1,3,2),(
"Võ Công Toản","1980-04-04","123231365",17000000,"0374443232","toan0404@gmail.com","77 Hoàng Diệu, Quảng Trị",1,4,4),(
"Nguyễn Bỉnh Phát","1999-12-09","454363232",6000000,"0902341231","phatphat@gmail.com","43 Yên Bái, Đà Nẵng",2,1,1),(
"Khúc Nguyễn An Nghi","2000-11-08","964542311",7000000,"0978653213","annghi20@gmail.com","294 Nguyễn Tất Thành, Đà Nẵng",2,2,3),(
"Nguyễn Hữu Hà","1993-01-01	","534323231",8000000,"0941234553","nhh0101@gmail.com","4 Nguyễn Chí Thanh, Huế",2,3,2),(
"Nguyễn Hà Đông","1989-09-03","	234414123",9000000," 0642123111","donghanguyen@gmail.com ","111 Hùng Vương, Hà Nội",2,4,4),(
"Tòng Hoang","1982-09-03","	256781231",	6000000,"0245144444","hoangtong@gmail.com","213 Hàm Nghi, Đà Nẵng",2,4,4),(
"Nguyễn Công Đạo","1994-01-08","755434343",8000000,"0988767111","nguyencongdao12@gmail.com","6 Hoà Khánh, Đồng Nai",2,3,2);
insert table_furama.loai_khach(ten_loai_khach) value ("Diamond"),("Platinium"),("Gold"),("silver"),("Member");
insert table_furama.khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) value (
"Nguyễn Thị Hào	","1970-11-07",0,"643431213","0945423362","thihao07@gmail.com","23 Nguyễn Hoàng, Đà Nẵng",5),(
"Phạm Xuân Diệu","1992-08-08",1,"865342123","0954333333","xuandieu92@gmail.com","K77/22 Thái Phiên, Quảng Trị",3),(
"Trương Đình Nghệ","1990-02-27",1,"488645199","0373213122","nghenhan2702@gmail.com","K323/12 Ông Ích Khiêm, Vinh",1),(
"Dương Văn Quan","1981-07-08",1,"543432111","0490039241","duongquan@gmail.com","K453/12 Lê Lợi, Đà Nẵng",1),(
"Hoàng Trần Nhi Nhi	","1995-12-09",0,"795453345","0312345678","nhinhi123@gmail.com","224 Lý Thái Tổ, Gia Lai",4),(
"Tôn Nữ Mộc Châu","2005-12-06",0,"732434215","0988888844","tonnuchau@gmail.com","	37 Yên Thế, Đà Nẵng",	4),(
"Nguyễn Mỹ Kim","1984-04-08",0,"856453123","0912345698","kimcuong84@gmail.com","K123/45 Lê Lợi, Hồ Chí Minh	",1),(
"Nguyễn Thị Hào","1999-04-08",0,"965656433","0763212345","haohao99@gmail.com","55 Nguyễn Văn Linh, Kon Tum	",3),(
"Trần Đại Danh","1994-07-01",1,"432341235","0643343433","danhhai99@gmail.com","24 Lý Thường Kiệt, Quảng Ngãi",	1),(
"Nguyễn Tâm Đắc","1989-07-01",1,"344343432","0987654321","dactam@gmail.com","22 Ngô Quyền, Đà Nẵng",2);
insert table_furama.kieu_thue(ten_kieu_thue) value ("year"),("month"),("day"),("hour");
insert table_furama.loai_dich_vu(ten_loai_dich_vu) value ("Villa"),("House"),("Room");
insert table_furama.dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,dich_vu_mien_phi_di_kem,ma_kieu_thue,ma_loai_dich_vu) value (
"Villa Beach Front",25000,1000000,10,"vip","Có hồ bơi",500,4,null,3,1),
("House Princess 01",14000,5000000,7,"vip","Có thêm bếp nướng",null,3,null,2,2),
("Room Twin 01",5000,1000000,2,"normal","Có tivi",null,null,"1 Xe máy,1 Xe đạp",4,3),
("Villa No Beach Front",22000,9000000,8,"normal","Có hồ bơi",300,3,null,3,1),
("House Princess 02",10000,4000000,5,"normal","Có thêm bếp nướng",null,2,null,3,2),
("Room Twin 02",3000,900000,2,"normal","Có tivi",null,null,"1 Xe máy",4,3);
insert table_furama.dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) value (
"Karaoke",10000,"giờ","tiện nghi, hiện tại"),(
"Thuê xe máy",10000,"chiếc"	,"hỏng 1 xe"),(
"Thuê xe đạp",20000,"chiếc","tốt"),(
"Buffet buổi sáng",15000,"suất","đầy đủ đồ ăn, tráng miệng"),(
"Buffet buổi trưa",90000,"suất","đầy đủ đồ ăn, tráng miệng"),(
"Buffet buổi tối",16000,"suất","đầy đủ đồ ăn, tráng miệng"
);
insert table_furama.hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu) value (
"2020-12-08","2020-12-08",0,3,1,3),(
"2020-07-14","2020-07-21",200000,7,3,1),(
"2021-03-15	","2021-03-17",50000,3,4,2),(
"2021-01-14","2021-01-18",100000,7,5,5),(
"2021-07-14","2021-07-15",0,7,2,6),(
"2021-06-01","2021-06-03",0,7,7,6),(
"2021-09-02","2021-09-05",100000,7,4,4),(
"2021-06-17","2021-06-18",150000,3,4,1),(
"2020-11-19","2020-11-19",0,3,4,3),(
"2021-04-12","2021-04-14",0,10,3,5),(
"2021-04-25","2021-04-25",0,2,2,1),(
"2021-05-25","2021-05-27",0,7,10,1);
insert table_furama.hop_dong_chi_tiet(so_luong,ma_hop_dong,ma_dich_vu_di_kem) value (
5,2,4),(
8,2,5),(
15,2,6),(
1,3,1),(
11,3,2),(
1,1,3),(
2,1,2),(
2,12,2);
-- task 2:
select*from table_furama.nhan_vien where ho_ten like 'T%' or  ho_ten like 'H%' or  ho_ten like 'K%' and length(ho_ten)<=15 ; 
-- task 3 : 
select*from table_furama.nhan_vien where (year(curdate()))- (year(ngay_sinh))>=18 and (dia_chi like "%Đà Nẵng%" or dia_chi like "%Quảng Trị%") ;
-- task 4:
select khach_hang.ma_khach_hang,
 khach_hang.ho_ten,
count(hop_dong.ma_khach_hang) as so_lan_dat_phong 
from table_furama.khach_hang 
join table_furama.hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
where  khach_hang.ma_loai_khach = 1 
group by hop_dong.ma_khach_hang 
order by so_lan_dat_phong ;
-- task 5:
select khach_hang.ma_khach_hang,
khach_hang.ho_ten,
loai_khach.ten_loai_khach,
ifnull(hop_dong.ma_hop_dong,"") as ma_hop_dong ,
ifnull(dich_vu.ten_dich_vu,"") as ten_dich_vu,
ifnull(hop_dong.ngay_lam_hop_dong,"") as ngay_lam_hop_dong,
ifnull(hop_dong.ngay_ket_thuc,"") as ngay_ket_thuc,
ifnull((dich_vu.chi_phi_thue + (dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong)),0) as tong_tien 
from loai_khach
left join khach_hang on loai_khach.ma_loai_khach=khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem=hop_dong_chi_tiet.ma_dich_vu_di_kem
left join dich_vu on hop_dong.ma_dich_vu=dich_vu.ma_dich_vu
order by khach_hang.ma_khach_hang;
-- task 6 :
SELECT d.ma_dich_vu, d.ten_dich_vu, d.dien_tich, d.chi_phi_thue, l.ten_loai_dich_vu
FROM dich_vu d
JOIN loai_dich_vu l ON d.ma_loai_dich_vu = l.ma_loai_dich_vu
WHERE d.ma_dich_vu NOT IN (
  SELECT DISTINCT ma_dich_vu
  FROM hop_dong
  WHERE YEAR(ngay_lam_hop_dong) = 2021 AND QUARTER(ngay_lam_hop_dong) = 1
);     
-- task 7 :
     SELECT
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.so_nguoi_toi_da,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
    JOIN loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
    JOIN hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = 2020
    AND hop_dong.ma_khach_hang  NOT IN  (
        SELECT ma_khach_hang
        FROM hop_dong
        WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2021
    );
--     task 8 :
SELECT DISTINCT ho_ten
FROM khach_hang;

SELECT ho_ten
FROM khach_hang
GROUP BY ho_ten;

SELECT DISTINCT kh.ho_ten
FROM khach_hang kh
INNER JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang;
-- task 9 :
select  month(hop_dong.ngay_lam_hop_dong) as thang,
count( distinct  hop_dong.ma_khach_hang) as so_luong_khach_hang
from hop_dong 
where year(hop_dong.ngay_lam_hop_dong) = 2021 
group by  month(hop_dong.ngay_lam_hop_dong);
-- task 10 :
select hop_dong.ma_hop_dong,
hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc,
hop_dong.tien_dat_coc,
sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from hop_dong
join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong,
hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc,
hop_dong.tien_dat_coc ;
-- task 11 :
select dich_vu_di_kem.ma_dich_vu_di_kem,
dich_vu_di_kem.ten_dich_vu_di_kem
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
join khach_hang on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
join loai_khach on loai_khach.ma_loai_khach=khach_hang.ma_loai_khach
where khach_hang.ma_loai_khach =1
and (khach_hang.dia_chi like '%Vinh%' or khach_hang.dia_chi like '%Quảng Ngãi%');
-- task 12 
SELECT hop_dong.ma_hop_dong,
       nhan_vien.ho_ten AS ho_ten_nhan_vien,
       khach_hang.ho_ten AS ho_ten_khach_hang,
       khach_hang.so_dien_thoai,
       dich_vu.ten_dich_vu,
       IFNULL(SUM(hop_dong.tien_dat_coc),0)AS tien_dat_coc,
       IFNULL(SUM(hop_dong_chi_tiet.so_luong),0) AS so_luong_dich_vu_di_kem
FROM hop_dong
left JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
JOIN khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
JOIN nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
JOIN dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE hop_dong.ma_dich_vu IN (
        SELECT ma_dich_vu
        FROM hop_dong
        WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2020 AND
        QUARTER(hop_dong.ngay_lam_hop_dong) = 4
    )
  AND hop_dong.ma_dich_vu NOT IN (
        SELECT ma_dich_vu
        FROM hop_dong
        WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2021 AND
        MONTH(hop_dong.ngay_lam_hop_dong) IN (1, 2, 3, 4, 5, 6)
    )
GROUP BY hop_dong.ma_hop_dong;
-- task 13 : 
SELECT dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) AS so_lan_su_dung
FROM hop_dong_chi_tiet 
JOIN dich_vu_di_kem  ON  hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
HAVING  sum(hop_dong_chi_tiet.so_luong) = (
  SELECT MAX(so_lan_su_dung)
  FROM (
    SELECT sum(hop_dong_chi_tiet.so_luong)AS so_lan_su_dung
    FROM hop_dong_chi_tiet
    GROUP BY ma_dich_vu_di_kem
  ) AS temp
);
-- task 14
set sql_mode =0 ;
SELECT
    hd.ma_hop_dong,
    dv.ten_dich_vu,
    dvdk.ten_dich_vu_di_kem,
    COUNT(hdct.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM
    hop_dong hd
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
    JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY
    dvdk.ma_dich_vu_di_kem
HAVING
    so_lan_su_dung = 1;
    set sql_mode =1;
-- task 15 :
SELECT nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
FROM nhan_vien
JOIN trinh_do ON nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
JOIN bo_phan ON nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
JOIN hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
WHERE YEAR(hop_dong.ngay_lam_hop_dong) IN (2021, 2020)
GROUP BY nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
HAVING COUNT(hop_dong.ma_nhan_vien) < 4;
-- task 16
SET SQL_SAFE_UPDATES = 0;
DELETE FROM nhan_vien
WHERE nhan_vien.ma_nhan_vien NOT IN (select * from
    (SELECT nhan_vien.ma_nhan_vien
    FROM nhan_vien
    LEFT JOIN hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
    WHERE YEAR(hop_dong.ngay_lam_hop_dong) IN (2019,2020,2021)) as temp
);
-- task 17 :
SET SQL_SAFE_UPDATES = 0;
UPDATE khach_hang
JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
SET khach_hang.ma_loai_khach = 1
WHERE khach_hang.ma_khach_hang IN ( select*from (
    SELECT khach_hang.ma_khach_hang
    FROM khach_hang
    WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2021
    AND khach_hang.ma_loai_khach = 2 
    AND (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong + dich_vu.chi_phi_thue)  > 10000000) as temp
);
SET SQL_SAFE_UPDATES = 1;
-- task 18 :
alter table khach_hang 
add count int ;
update khach_hang
left JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
set count = 1 
WHERE YEAR(hop_dong.ngay_lam_hop_dong) < 2021;
-- task 19 : 
UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem IN (
    SELECT ma_dich_vu_di_kem
    FROM hop_dong_chi_tiet
    JOIN hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
    WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2020
    GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
    HAVING sum(hop_dong_chi_tiet.so_luong) > 10
);
-- task 20 :
SELECT ma_nhan_vien AS id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
FROM nhan_vien
UNION ALL
SELECT ma_khach_hang AS id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
FROM khach_hang;
-- task 21 : 
CREATE VIEW v_nhan_vien AS
SELECT nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.ngay_sinh, nhan_vien.so_cmnd, nhan_vien.luong, nhan_vien.so_dien_thoai, nhan_vien.email, nhan_vien.dia_chi, vi_tri.ten_vi_tri, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan
FROM nhan_vien
JOIN vi_tri ON nhan_vien.ma_vi_tri = vi_tri.ma_vi_tri
JOIN trinh_do ON trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
JOIN bo_phan ON bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
JOIN hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
WHERE nhan_vien.dia_chi like "%Huế%"
AND DATE(hop_dong.ngay_lam_hop_dong) = 2021-07-14;
-- task 22 :
UPDATE nhan_vien
SET dia_chi = 'Liên Chiểu'
WHERE ma_nhan_vien IN (
    SELECT nhan_vien.ma_nhan_vien
    FROM nhan_vien
    JOIN vi_tri ON nhan_vien.ma_vi_tri = vi_tri.ma_vi_tri
    JOIN trinh_do ON trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
    JOIN bo_phan ON bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
    JOIN hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
    WHERE nhan_vien.dia_chi LIKE '%Hải Châu%'
    AND DATE(hop_dong.ngay_lam_hop_dong) = '2019-12-12'
);









