CREATE DATABASE hotel_booking;
USE hotel_booking;

CREATE TABLE roles (
    id_role INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50)
);

CREATE TABLE accounts (
    id_account INT PRIMARY KEY AUTO_INCREMENT,
    account_name VARCHAR(100),
    password VARCHAR(100),
    id_role INT,
    FOREIGN KEY (id_role) REFERENCES roles(id_role)
);

CREATE TABLE levels (
    level_id INT PRIMARY KEY AUTO_INCREMENT,
    level_name VARCHAR(100)
);

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT,
    full_name VARCHAR(100),
    birth_date DATE,
    phone_number INT,
    email VARCHAR(45),
    PRIMARY KEY (employee_id),
    position_name VARCHAR(50),
    id_account INT, 
    FOREIGN KEY (id_account) REFERENCES accounts(id_account),
	level_id INT, 
    FOREIGN KEY (level_id) REFERENCES levels(level_id)
);

CREATE TABLE customer_types (
    customer_type_id INT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(45)
);

CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100),
    birth_date DATE,
    gender BIT(1),
    id_card_number VARCHAR(45),
    phone_number VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    customer_type_id INT,
    FOREIGN KEY (customer_type_id) REFERENCES customer_types(customer_type_id),
    id_account INT, 
    FOREIGN KEY (id_account) REFERENCES accounts(id_account)
);

CREATE TABLE service_types (
    service_type_id INT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(45)
);

CREATE TABLE services (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(45),
    area INT,
    rental_cost DOUBLE,
    max_capacity INT,
    room_standard VARCHAR(45),
    other_facilities VARCHAR(45),
    number_of_rooms INT,
    complementary_services TEXT,
    rent_type VARCHAR(45),
    service_type_id INT,
    FOREIGN KEY (service_type_id) REFERENCES service_types(service_type_id)
);

CREATE TABLE contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    start_date DATETIME,
    end_date DATETIME,
    deposit_amount DOUBLE,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    service_id INT,
    FOREIGN KEY (service_id) REFERENCES services(service_id)
);

CREATE TABLE complementary_services (
    complementary_service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(45),
    price DOUBLE,
    unit VARCHAR(10),
    `status` VARCHAR(45)
);

CREATE TABLE contract_details (
    contract_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_id INT,
    FOREIGN KEY (contract_id) REFERENCES contracts(contract_id),
    complementary_service_id INT,
    FOREIGN KEY (complementary_service_id) REFERENCES complementary_services(complementary_service_id),
    quantity INT
);

INSERT INTO roles (role_name)
VALUES
    ('Quản trị viên'),
    ('Quản lý'),
    ('Nhân viên'),
    ('Lễ tân'),
    ('Nhân viên phòng'),
    ('Đầu bếp'),
    ('Nhân viên phục vụ'),
    ('Chuyên viên spa'),
    ('Bảo vệ'),
    ('Kế toán');

INSERT INTO accounts (account_name, password, id_role)
VALUES
    ('admin123', 'admin_password', 1),
    ('manager1', 'manager_password', 2),
    ('staff101', 'staff_password', 3),
    ('reception1', 'reception_password', 4),
    ('housekeeping1', 'housekeeping_password', 5),
    ('chef123', 'chef_password', 6),
    ('waiter22', 'waiter_password', 7),
    ('spa101', 'spa_password', 8),
    ('security1', 'security_password', 9),
    ('accountant1', 'accountant_password', 10);

INSERT INTO levels (level_name)
VALUES
    ('Nhân viên cấp dưới'),
    ('Nhân viên cấp trung'),
    ('Nhân viên cấp cao'),
    ('Giám đốc điều hành'),
    ('Giám đốc kinh doanh');

INSERT INTO employees (full_name, birth_date, phone_number, email, position_name, id_account, level_id)
VALUES
    ('Nguyễn Văn A', '1990-05-15', 123456789, 'nguyen.van.a@example.com', 'Quản lý', 2, 3),
    ('Trần Thị B', '1985-10-20', 987654321, 'tran.thi.b@example.com', 'Nhân viên', 3, 1),
    ('Lê Hoàng C', '1995-08-25', 555123789, 'le.hoang.c@example.com', 'Lễ tân', 4, 2);

INSERT INTO customer_types (type_name)
VALUES
    ('Khách thường'),
    ('Khách VIP');

INSERT INTO customers (full_name, birth_date, gender, id_card_number, phone_number, email, address, customer_type_id, id_account)
VALUES
    ('Nguyễn Văn A', '1988-01-15', 1, 'AB123456', '555-1234', 'nguyen.van.a@example.com', '123 Đường ABC', 1, 1),
    ('Trần Thị B', '1990-03-20', 0, 'CD789012', '555-5678', 'tran.thi.b@example.com', '456 Đường XYZ', 2, 2),
    ('Lê Hoàng C', '1985-07-25', 1, 'EF345678', '555-9876', 'le.hoang.c@example.com', '789 Đường LMN', 1, 3);


INSERT INTO service_types (type_name)
VALUES
    ('Phòng'),
    ('Nhà hàng'),
    ('Spa');

INSERT INTO services (service_name, area, rental_cost, max_capacity, room_standard, other_facilities, number_of_rooms, complementary_services, rent_type, service_type_id)
VALUES
    ('Phòng Standard', 25, 100, 2, 'Standard', 'TV, Wi-Fi', 50, 'Dịch vụ khăn tắm, Dọn dẹp phòng', 'Theo giờ', 1),
    ('Phòng Deluxe', 35, 150, 3, 'Deluxe', 'TV, Wi-Fi, Mini bar', 30, 'Dịch vụ khăn tắm, Dọn dẹp phòng, Truy cập spa', 'Theo giờ', 1),
    ('Nhà hàng A', 100, 0, 50, 'Fine Dining', 'Bar, Âm nhạc trực tiếp', 1, 'Thực đơn lựa chọn, Dịch vụ rượu vang', 'Hàng ngày', 2);

INSERT INTO contracts (start_date, end_date, deposit_amount, customer_id, employee_id, service_id)
VALUES
    ('2023-07-01 12:00:00', '2023-07-05 12:00:00', 200, 1, 1, 1),
    ('2023-08-10 14:00:00', '2023-08-15 10:00:00', 300, 2, 1, 2),
    ('2023-09-20 10:00:00', '2023-09-25 14:00:00', 150, 3, 2, 3),
    ('2023-10-05 15:00:00', '2023-10-10 12:00:00', 250, 1, 3, 1),
    ('2023-11-15 13:00:00', '2023-11-20 10:00:00', 180, 2, 2, 2),
    ('2023-12-25 16:00:00', '2023-12-30 11:00:00', 220, 3, 1, 3);

INSERT INTO complementary_services (service_name, price, unit, `status`)
VALUES
    ('Bữa sáng', 15, 'Người', 'Có sẵn'),
    ('Đưa đón sân bay', 50, 'Chuyến', 'Có sẵn');

INSERT INTO contract_details (contract_id, complementary_service_id, quantity)
VALUES
    (1, 1, 2),
    (1, 2, 1),
    (2, 1, 3),
    (2, 2, 2),
    (3, 1, 1),
    (3, 2, 1);
