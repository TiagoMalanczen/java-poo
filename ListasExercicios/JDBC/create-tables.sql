CREATE DATABASE banco_db;
USE banco_db;

CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    holder VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);

INSERT INTO account (holder, balance) VALUES 
('Tiago', 1500.00),
('Carlos', 300.00);