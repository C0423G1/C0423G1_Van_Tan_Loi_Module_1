CREATE DATABASE travel_tour_booking;
USE travel_tour_booking;
CREATE TABLE roles (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50)
);
CREATE TABLE accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    account_username VARCHAR(100) UNIQUE,
    account_password VARCHAR(100),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);
CREATE TABLE customer_types (
    customer_type_id INT PRIMARY KEY,
    customer_type_name VARCHAR(100)
);
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(255),
    customer_id_card VARCHAR(20),
    customer_gender BIT(1),
    customer_email VARCHAR(255),
    customer_phone VARCHAR(20),
    customer_address TEXT,
    customer_type_id INT,
    account_id INT,
    FOREIGN KEY (customer_type_id) REFERENCES customer_types(customer_type_id),
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
CREATE TABLE employee_types (
    employee_type_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_type_name VARCHAR(100)
);
CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(100),
    employee_phone VARCHAR(10),
    employee_email VARCHAR(100),
    employee_gender BIT(1),
    employee_type_id INT,
    FOREIGN KEY (employee_type_id) REFERENCES employee_types(employee_type_id)
);
CREATE TABLE tour_places (
    tour_places_id INT PRIMARY KEY,
    tour_places_name VARCHAR(100)
);
CREATE TABLE tours (
    tour_id INT PRIMARY KEY,
    tour_name VARCHAR(255),
    tour_description TEXT,
    tour_price DOUBLE,
    tour_available_seats INT,
    start_date DATE,
    end_date DATE,
    employee_id INT,
    place_start VARCHAR(100),
    place_end VARCHAR(100),
    tour_places_id INT,
    FOREIGN KEY (tour_places_id) REFERENCES tour_places(tour_places_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);
CREATE TABLE bookings (
    booking_id INT PRIMARY KEY,
    customer_id INT,
    booking_date DATE,
    tour_id INT,
    quantity INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (tour_id) REFERENCES tours(tour_id)
);
INSERT INTO roles (role_name) VALUES
('Quản trị viên'),
('Nhân viên'),
('Khách hàng');
INSERT INTO accounts (account_username, account_password, role_id) VALUES
('admin_user', 'admin_password', 1),
('employee_user', 'employee_password', 2),
('customer_user', 'customer_password', 3);
INSERT INTO customer_types (customer_type_id, customer_type_name) VALUES
(1, 'Thường'),
(2, 'VIP');
INSERT INTO customers (customer_id, customer_name, customer_id_card, customer_gender, customer_email, customer_phone, customer_address, customer_type_id, account_id) VALUES
(1, 'Nguyễn Văn A', '1234567890', 1, 'nguyenvana@example.com', '1234567890', '123 Đường ABC, Thành phố', 1, 3),
(2, 'Trần Thị B', '9876543210', 0, 'tranthib@example.com', '9876543210', '456 Đường XYZ, Thị trấn', 2, 3);
INSERT INTO employee_types (employee_type_id, employee_type_name) VALUES
(1, 'Hướng dẫn viên'),
(2, 'Lái xe');
INSERT INTO employees (employee_id, employee_name, employee_phone, employee_email, employee_gender, employee_type_id) VALUES
(1, 'Nguyễn Văn B', '9876543211', 'nguyenvanb@example.com', 1, 1),
(2, 'Trần Thị C', '1234567891', 'tranthic@example.com', 0, 2);
INSERT INTO tour_places (tour_places_id, tour_places_name) VALUES
(1, 'Biển Đảo'),
(2, 'Núi Rừng');
INSERT INTO tours (tour_id, tour_name, tour_description, tour_price, tour_available_seats, start_date, end_date, employee_id, place_start, place_end, tour_places_id) VALUES
(1, 'Kỳ nghỉ biển thư giãn', 'Thưởng thức nắng, cát và sóng trên bãi biển tuyệt đẹp.', 500.00, 50, '2023-08-15', '2023-08-22', 1, 'Thành phố A', 'Biển Đảo', 1),
(2, 'Cuộc phiêu lưu đồi núi', 'Trải nghiệm chuyến trekking hấp dẫn qua cảnh đẹp của núi rừng.', 800.00, 30, '2023-09-10', '2023-09-17', 2, 'Thị trấn B', 'Núi Rừng', 2);
INSERT INTO bookings (booking_id, customer_id, booking_date, tour_id, quantity) VALUES
(1, 1, '2023-07-31', 1, 2),
(2, 2, '2023-08-01', 2, 1);