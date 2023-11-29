CREATE DATABASE lv_watch;
CREATE TABLE app_role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name_role VARCHAR(255) NOT NULL,
    flag_deleted BOOLEAN,
    INDEX idx_flag_deleted (flag_deleted)
);

CREATE TABLE app_user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    flag_online BOOLEAN,
    flag_deleted BOOLEAN,
    INDEX idx_flag_online (flag_online),
    INDEX idx_flag_deleted (flag_deleted)
);

CREATE TABLE table_customer (
    id_customer INT AUTO_INCREMENT PRIMARY KEY,
    address_customer VARCHAR(255),
    cccd_customer VARCHAR(255),
    gender_customer VARCHAR(255),
    name_customer VARCHAR(255),
    phone_customer VARCHAR(255),
    id_type_customer INT,
    id_account INT,
    INDEX idx_id_type_customer (id_type_customer),
    INDEX idx_id_account (id_account),
    FOREIGN KEY (id_account) REFERENCES app_user(id)
);

CREATE TABLE table_machine_type (
    id_machine_type INT AUTO_INCREMENT PRIMARY KEY,
    name_machine_type VARCHAR(255)
);

CREATE TABLE table_order (
    id_order INT AUTO_INCREMENT PRIMARY KEY,
    date_time_order VARCHAR(255),
    status_order VARCHAR(255),
    id_customer INT,
    INDEX idx_id_customer (id_customer),
    FOREIGN KEY (id_customer) REFERENCES table_customer(id_customer)
);

CREATE TABLE table_order_detail (
    id_order_detail INT AUTO_INCREMENT PRIMARY KEY,
    price_watch DOUBLE,
    quantity_watch INT,
    id_order INT,
    id_watch INT,
    INDEX idx_id_order (id_order),
    INDEX idx_id_watch (id_watch),
    FOREIGN KEY (id_order) REFERENCES table_order(id_order),
    FOREIGN KEY (id_watch) REFERENCES table_watch(id_watch)
);

CREATE TABLE table_trademark_watch (
    id_trademark_watch INT AUTO_INCREMENT PRIMARY KEY,
    name_trademark_watch VARCHAR(255)
);

CREATE TABLE table_type_watch (
    id_type_watch INT AUTO_INCREMENT PRIMARY KEY,
    name_type_watch VARCHAR(255)
);

CREATE TABLE table_watch (
    id_watch INT AUTO_INCREMENT PRIMARY KEY,
    name_watch VARCHAR(255),
    phone_watch VARCHAR(255),
    url_image VARCHAR(255),
    price_watch DOUBLE,
    quantity_watch INT,
    id_type_watch INT,
    id_trademark_watch INT,
    id_machine_type INT,
    INDEX idx_id_type_watch (id_type_watch),
    INDEX idx_id_trademark_watch (id_trademark_watch),
    INDEX idx_id_machine_type (id_machine_type),
    FOREIGN KEY (id_type_watch) REFERENCES table_type_watch(id_type_watch),
    FOREIGN KEY (id_trademark_watch) REFERENCES table_trademark_watch(id_trademark_watch),
    FOREIGN KEY (id_machine_type) REFERENCES table_machine_type(id_machine_type)
);

CREATE TABLE user_role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    app_user_id INT,
    app_role_id INT,
    INDEX idx_app_user_id (app_user_id),
    INDEX idx_app_role_id (app_role_id),
    FOREIGN KEY (app_user_id) REFERENCES app_user(id),
    FOREIGN KEY (app_role_id) REFERENCES app_role(id)
);
