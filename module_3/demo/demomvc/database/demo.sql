-- Tạo cơ sở dữ liệu
CREATE DATABASE product_management;
USE product_management;

-- Tạo bảng "products"
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    product_price DECIMAL(10, 2) NOT NULL,
    product_description TEXT,
    manufacturer VARCHAR(100) NOT NULL
);

-- Thêm dữ liệu mẫu vào bảng "products"
INSERT INTO products (product_name, product_price, product_description, manufacturer) VALUES
('Sản phẩm A', 100.00, 'Mô tả sản phẩm A.', 'Nhà sản xuất X'),
('Sản phẩm B', 200.00, 'Mô tả sản phẩm B.', 'Nhà sản xuất Y'),
('Sản phẩm C', 300.00, 'Mô tả sản phẩm C.', 'Nhà sản xuất Z'),
('Sản phẩm D', 150.00, 'Mô tả sản phẩm D.', 'Nhà sản xuất X'),
('Sản phẩm E', 250.00, 'Mô tả sản phẩm E.', 'Nhà sản xuất Y'),
('Sản phẩm F', 180.00, 'Mô tả sản phẩm F.', 'Nhà sản xuất Z'),
('Sản phẩm G', 220.00, 'Mô tả sản phẩm G.', 'Nhà sản xuất X'),
('Sản phẩm H', 280.00, 'Mô tả sản phẩm H.', 'Nhà sản xuất Y'),
('Sản phẩm I', 350.00, 'Mô tả sản phẩm I.', 'Nhà sản xuất Z'),
('Sản phẩm J', 120.00, 'Mô tả sản phẩm J.', 'Nhà sản xuất X');
