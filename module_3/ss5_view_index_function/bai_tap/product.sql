-- Bước 1: Tạo cơ sở dữ liệu demo
CREATE DATABASE demo;
USE demo;

-- Bước 2: Tạo bảng products với các trường dữ liệu sau:
CREATE TABLE products (
  id INT PRIMARY KEY AUTO_INCREMENT,
  product_code VARCHAR(20),
  product_name VARCHAR(100),
  product_price DECIMAL(10,2),
  product_amount INT,
  product_description VARCHAR(255),
  product_status VARCHAR(20)
);

-- Chèn một số dữ liệu mẫu cho bảng products
INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
  ('P001', 'Product 1', 10.99, 100, 'Description 1', 'Active'),
  ('P002', 'Product 2', 19.99, 50, 'Description 2', 'Active'),
  ('P003', 'Product 3', 5.99, 200, 'Description 3', 'Inactive');

-- Bước 3: Tạo Unique Index và Composite Index trên bảng products
CREATE UNIQUE INDEX idx_product_code ON products (product_code);
CREATE INDEX idx_product_name_product_price ON products (product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM products WHERE product_code = 'P001';

-- So sánh câu truy vấn trước và sau khi tạo index
-- Sau tạo index
EXPLAIN SELECT * FROM products WHERE product_name = 'Product 1' AND product_price = 10.99;

-- Trước khi tạo index
DROP INDEX idx_product_name_product_price ON products;
EXPLAIN SELECT * FROM products WHERE product_name = 'Product 1' AND product_price = 10.99;

-- Bước 4: Tạo view lấy về các thông tin: product_code, product_name, product_price, product_status từ bảng products
CREATE VIEW product_info AS
SELECT product_code, product_name, product_price, product_status
FROM products;

-- Tiến hành sửa đổi view
ALTER VIEW product_info AS
SELECT product_code, product_name, product_price, product_amount
FROM products;

-- Tiến hành xoá view
DROP VIEW product_info;

-- Bước 5: Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE get_all_products()
BEGIN
  SELECT * FROM products;
END //
DELIMITER ;

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE add_product(
  IN p_product_code VARCHAR(20),
  IN p_product_name VARCHAR(100),
  IN p_product_price DECIMAL(10,2),
  IN p_product_amount INT,
  IN p_product_description VARCHAR(255),
  IN p_product_status VARCHAR(20)
)
BEGIN
  INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
  VALUES (p_product_code, p_product_name, p_product_price, p_product_amount, p_product_description, p_product_status);
END //
DELIMITER ;

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
CREATE PROCEDURE update_product(
  IN p_product_id INT,
  IN p_product_name VARCHAR(100),
  IN p_product_price DECIMAL(10,2),
  IN p_product_amount INT,
  IN p_product_description VARCHAR(255),
  IN p_product_status VARCHAR(20)
)
BEGIN
  UPDATE products
  SET product_name = p_product_name,
      product_price = p_product_price,
      product_amount = p_product_amount,
      product_description = p_product_description,
      product_status = p_product_status
  WHERE id = p_product_id;
END //
DELIMITER ;

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
CREATE PROCEDURE delete_product(
  IN p_product_id INT
)
BEGIN
  DELETE FROM products WHERE id = p_product_id;
END //
DELIMITER ;
