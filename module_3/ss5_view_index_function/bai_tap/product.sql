CREATE DATABASE demo;
USE demo;
CREATE TABLE products (
    id INT PRIMARY KEY,
    product_code VARCHAR(50),
    product_name VARCHAR(100),
    product_price DECIMAL(10, 2),
    product_amount INT,
    product_description VARCHAR(255),
    product_status VARCHAR(20)
);

INSERT INTO products (id, product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
    (1, 'P001', 'Product 1', 10.99, 100, 'Description 1', 'Active'),
    (2, 'P002', 'Product 2', 19.99, 50, 'Description 2', 'Active'),
    (3, 'P003', 'Product 3', 5.99, 200, 'Description 3', 'Inactive');
CREATE UNIQUE INDEX idx_product_code ON products (product_code);
CREATE INDEX idx_product_name_product_price ON products (product_name, product_price);
EXPLAIN SELECT * FROM products WHERE product_code = 'P001';
CREATE VIEW product_view AS
SELECT product_code, product_name, product_price, product_status
FROM products;
ALTER VIEW product_view AS
SELECT product_code, product_name, product_price, product_status, product_amount
FROM products;
DROP VIEW product_view;
DELIMITER //
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM products;
END;
DELIMITER ;
DELIMITER //
CREATE PROCEDURE add_product(IN p_code VARCHAR(50), IN p_name VARCHAR(100), IN p_price DECIMAL(10, 2), IN p_amount INT, IN p_desc VARCHAR(255), IN p_status VARCHAR(20))
BEGIN
    INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
    VALUES (p_code, p_name, p_price, p_amount, p_desc, p_status);
END;
DELIMITER ;
DELIMITER //
CREATE PROCEDURE update_product(IN p_id INT, IN p_name VARCHAR(100), IN p_price DECIMAL(10, 2), IN p_amount INT, IN p_desc VARCHAR(255), IN p_status VARCHAR(20))
BEGIN
    UPDATE products
    SET product_name = p_name, product_price = p_price, product_amount = p_amount, product_description = p_desc, product_status = p_status
    WHERE id = p_id;
END;
DELIMITER ;
DELIMITER //
CREATE PROCEDURE delete_product(IN p_id INT)
BEGIN
    DELETE FROM products WHERE id = p_id;
END;
DELIMITER ;

