-- Tạo cơ sở dữ liệu
CREATE DATABASE hotel_management;

-- Sử dụng cơ sở dữ liệu
USE hotel_management;

-- Bảng table_role (vai trò)
CREATE TABLE table_role (
    id_role INT PRIMARY KEY,
    name_role VARCHAR(255)
);

-- Bảng table_type_customer (loại khách hàng)
CREATE TABLE table_type_customer (
    id_type_customer INT PRIMARY KEY,
    name_type_customer VARCHAR(255),
    level_type_customer INT,
    discount_type_customer DECIMAL(5, 2)
);

-- Bảng table_account (tài khoản)
CREATE TABLE table_account (
    id_account INT PRIMARY KEY,
    user_name VARCHAR(255),
    password_name VARCHAR(255),
    id_role INT,
    id_image_avatar INT,
    FOREIGN KEY (id_role) REFERENCES table_role(id_role)
);

-- Bảng table_employee_customer (nhân viên khách hàng)
CREATE TABLE table_employee_customer (
    id_employee_customer INT PRIMARY KEY,
    name_employee_customer VARCHAR(255),
    cccd_employee_customer VARCHAR(255),
    phone_employee_customer VARCHAR(20),
    gender_employee_customer VARCHAR(10),
    email_employee_customer VARCHAR(255),
    address_employee_customer VARCHAR(255),
    stk_employee_customer VARCHAR(20),
    id_account INT,
    FOREIGN KEY (id_account) REFERENCES table_account(id_account)
);

-- Bảng table_type_employee (loại nhân viên)
CREATE TABLE table_type_employee (
    id_type_employee INT PRIMARY KEY,
    name_type_employee VARCHAR(255)
);

-- Bảng table_employee (nhân viên)
CREATE TABLE table_employee (
    id_employee INT PRIMARY KEY,
    name_employee VARCHAR(255),
    cccd_employee VARCHAR(255),
    phone_employee VARCHAR(20),
    gender_employee VARCHAR(10),
    email_employee VARCHAR(255),
    wage_employee DECIMAL(10, 2),
    address_employee VARCHAR(255),
    id_type_employee INT,
    id_account INT,
    FOREIGN KEY (id_type_employee) REFERENCES table_type_employee(id_type_employee),
    FOREIGN KEY (id_account) REFERENCES table_account(id_account)
);

-- Bảng table_customer (khách hàng)
CREATE TABLE table_customer (
    id_customer INT PRIMARY KEY,
    name_customer VARCHAR(255),
    cccd_customer VARCHAR(255),
    phone_customer VARCHAR(20),
    gender_customer VARCHAR(10),
    stk_customer VARCHAR(20),
    email_customer VARCHAR(255),
    address_customer VARCHAR(255),
    id_type_customer INT,
    id_account INT,
    FOREIGN KEY (id_type_customer) REFERENCES table_type_customer(id_type_customer),
    FOREIGN KEY (id_account) REFERENCES table_account(id_account)
);

-- Bảng table_hotel (khách sạn)
CREATE TABLE table_hotel (
    id_hotel INT PRIMARY KEY,
    name_hotel VARCHAR(255),
    address_hotel VARCHAR(255),
    phone_hotel VARCHAR(20),
    description_hotel TEXT,
    applications_hotel TEXT,
    id_employee_customer INT,
    FOREIGN KEY (id_employee_customer) REFERENCES table_employee_customer(id_employee_customer)
);

-- Bảng table_type_room_hotel (loại phòng khách sạn)
CREATE TABLE table_type_room_hotel (
    id_type_hotel INT PRIMARY KEY,
    name_type_hotel VARCHAR(255),
    price_type_hotel DECIMAL(10, 2),
    id_hotel INT,
    FOREIGN KEY (id_hotel) REFERENCES table_hotel(id_hotel)
);

-- Bảng table_image_hotel (ảnh khách sạn)
CREATE TABLE table_image_hotel (
    id_image_hotel INT PRIMARY KEY,
    url_image_hotel VARCHAR(255),
    id_type_hotel INT,
    FOREIGN KEY (id_type_hotel) REFERENCES table_type_room_hotel(id_type_hotel)
);

-- Bảng table_hotel_detail (chi tiết khách sạn)
CREATE TABLE table_hotel_detail (
    id_hotel_detail INT PRIMARY KEY,
    date_hotel_detail DATE,
    price_hotel_detail DECIMAL(10, 2),
    id_type_hotel INT,
    FOREIGN KEY (id_type_hotel) REFERENCES table_type_room_hotel(id_type_hotel)
);

-- Bảng table_applications_hotel (ứng dụng khách sạn)
CREATE TABLE table_applications_hotel (
    id_applications_hotel INT PRIMARY KEY,
    name_applications_hotel VARCHAR(255)
);

-- Bảng table_applications_hotel_detail (chi tiết ứng dụng khách sạn)
CREATE TABLE table_applications_hotel_detail (
    id_applications_hotel_detail INT PRIMARY KEY,
    id_applications_hotel INT,
    id_hotel INT,
    FOREIGN KEY (id_applications_hotel) REFERENCES table_applications_hotel(id_applications_hotel),
    FOREIGN KEY (id_hotel) REFERENCES table_hotel(id_hotel)
);
-- Bảng table_order_bill (hóa đơn đặt phòng)
CREATE TABLE table_order_bill (
    id_order INT PRIMARY KEY,
    date_order DATE,
    date_start DATE,
    date_end DATE,
    sum_price DECIMAL(10, 2),
    id_customer INT,
	name_customer VARCHAR(255),
    phone_customer VARCHAR(20),
	id_hotel_detail INT,
    status_order VARCHAR(255),
    FOREIGN KEY (id_customer) REFERENCES table_customer(id_customer),
	FOREIGN KEY (id_hotel_detail) REFERENCES table_hotel_detail(id_hotel_detail)
);




