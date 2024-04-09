-- データベースが存在しない場合のみ作成
CREATE DATABASE IF NOT EXISTS reservation_system;
USE reservation_system;

-- 顧客テーブル
CREATE TABLE IF NOT EXISTS customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

-- 店舗テーブル
CREATE TABLE IF NOT EXISTS stores (
    store_id INT AUTO_INCREMENT PRIMARY KEY,
    store_name VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL
);

-- サービステーブル
CREATE TABLE IF NOT EXISTS services (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    store_id INT NOT NULL,
    service_name VARCHAR(50) NOT NULL,
    duration INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (store_id) REFERENCES stores(store_id)
);

-- 売上テーブル
CREATE TABLE IF NOT EXISTS sales (
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    store_id INT NOT NULL,
    sale_date DATE NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (store_id) REFERENCES stores(store_id)
);

-- 予約テーブル
CREATE TABLE IF NOT EXISTS reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    service_id INT NOT NULL,
    reservation_date DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (service_id) REFERENCES services(service_id)
);

-- 顧客テーブルにデータを挿入
INSERT INTO customers (customer_name, email, phone)
VALUES ('Jane Doe', 'jane.doe@example.com', '0987654321'),
       ('Alice Smith', 'alice.smith@example.com', '1122334455'),
       ('Bob Johnson', 'bob.johnson@example.com', '2233445566');

-- 店舗テーブルにデータを挿入
INSERT INTO stores (store_name, address)
VALUES ('Store 1', '123 Main St'),
       ('Store 2', '456 Broadway St'),
       ('Store 3', '789 Wall St');

-- サービステーブルにデータを挿入
INSERT INTO services (store_id, service_name, duration, price)
VALUES (1, 'Service 1', 60, 100.00),
       (1, 'Service 2', 90, 150.00),
       (1, 'Service 3', 120, 200.00),
       (2, 'Service 4', 30, 50.00),
       (2, 'Service 5', 60, 100.00),
       (2, 'Service 6', 90, 150.00),
       (3, 'Service 7', 120, 200.00),
       (3, 'Service 8', 30, 50.00),
       (3, 'Service 9', 60, 100.00);

-- 予約テーブルにデータを挿入
INSERT INTO reservations (customer_id, service_id, reservation_date, status)
VALUES (1, 1, '2023-01-01 10:00:00', 'CONFIRMED'),
       (2, 2, '2023-01-02 14:00:00', 'CONFIRMED'),
       (3, 3, '2023-01-03 16:00:00', 'CONFIRMED');

-- 売上テーブルにデータを挿入
INSERT INTO sales (store_id, sale_date, total_amount)
VALUES (1, '2022-12-30', 1500.00),
       (2, '2022-12-29', 2000.00);