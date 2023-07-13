
create database quanlysinhvien;
use quanlysinhvien;
create table class
(
class_id int not null auto_increment primary key,
class_name varchar(60) not null,
start_date datetime not null,
status bit
);
create table student
(
student_id int not null auto_increment primary key,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
status bit,
class_id int not null,
foreign key (class_id) references class (class_id)
);
create table `subject`
(
sub_id int not null auto_increment primary key,
sub_name varchar(30) not null,
credit tinyint not null default 1 check ( credit >= 1 ),
status bit default 1
);
create table mark
(
mark_id int not null auto_increment primary key,
sub_id int not null,
student_id int not null,
mark float default 0 check ( mark between 0 and 100),
examtimes tinyint default 1,
unique (sub_id, student_id),
foreign key (sub_id) references subject (sub_id),
foreign key (student_id) references student (student_id)
);
-- ----------------------------------------------------------------------------------------------------------------------
INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO class
VALUES (3, 'B3', current_date, 0);
INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, status, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO mark (sub_id, student_id, mark, examtimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
-- ----------------------------------------------------------------------------------------------------------------------
select *
from student;
select *
from student
where status = true;
select *
from subject
where credit < 10;
select s.student_id, s.student_name, c.class_name
from student s join class c on s.class_id = c.class_id;
select s.student_id, s.student_name, c.class_name
from student s join class c on s.class_id = c.class_id
where c.class_name = 'A1';
select s.student_id, s.student_name, sub.sub_name, m.mark
from student s join mark m on s.student_id = m.student_id join subject sub on m.sub_id = sub.sub_id;
select s.student_id, s.student_name, sub.sub_name, m.mark
from student s join mark m on s.student_id = m.student_id join subject sub on m.subi_d = sub.sub_id
where sub.sub_name = 'CF';
-- -------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------[Bài tập] Truy vấn dữ liệu với CSDL Quản lý sinh viên--------------------------------
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT *
FROM student
WHERE student_name LIKE 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12:
SELECT *
FROM class
WHERE MONTH(start_date) = 12;
-- Hiển thị tất cả các thông tin môn học có số tín chỉ trong khoảng từ 3 đến 5:
SELECT *
FROM subject
WHERE credit BETWEEN 3 AND 5;
-- Thay đổi mã lớp (ClassID) của sinh viên có tên 'Hung' thành 2:
UPDATE student
SET class_id = 2
WHERE student_name = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần, nếu trùng sắp theo tên tăng dần:
SELECT s.student_name AS StudentName, sub.sub_name AS SubName, m.mark AS Mark
FROM student s
JOIN mark m ON s.student_id = m.student_id
JOIN subject sub ON m.sub_id = sub.sub_id
ORDER BY m.mark DESC, s.student_name ASC;
-- ----------------------------------------------------------------------------------------------------------------------------------