CREATE DATABASE QRTESTING;

USE QRTESTING;

insert into users(email, name, user_name) VALUES('omardominguezfuentes@gmail.com', 'Omar', 'omardf_00'),
('prueba123@gmail.com', 'Prueba', 'prueba123'),
('juan@gmail.com', 'Juan', 'juan123');

INSERT INTO user_detail(date_of_birth, direction, last_name, phone_number)
VALUES
(GETDATE(), 'C/Pepito de los palotes 1', 'Domínguez Fuentes', '+34123456789'),
(GETDATE(), 'C/Lon Ángeles', 'prueba prueba', '+34987654321'),
(GETDATE(), 'C/Subida las Escaleras', 'Barroso Sánchez', '+34918273645');

UPDATE users
SET user_detail_id=1
WHERE user_id=1;

UPDATE users
SET user_detail_id=2
WHERE user_id=2;

UPDATE users
SET user_detail_id=3
WHERE user_id=3;

INSERT INTO role(role_name) VALUES
('RESTRICTED_USER'), ('BASIC_USER'), ('EDITOR'), ('ADMIN'), ('OWNER');

INSERT INTO user_role(user_id, role_id) VALUES
(1,3),
(1,4),
(1,5),
(2,2),
(2,3),
(3,1);