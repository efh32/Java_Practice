-- Database: Bakery

-- DROP DATABASE IF EXISTS "Bakery";

CREATE DATABASE "Bakery"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	

CREATE TABLE CakeList (
	cake_id varchar(45) Primary Key NOT NULL,
  	cake_name varchar(45) NOT NULL,
  	description varchar(90) NOT NULL
);

INSERT INTO 
	CakeList (cake_id, cake_name, description)
VALUES 
	('CID-00001', 'German Chocolate Cake', 'layered chocolate cake filled and topped with a coconut-pecan frosting'),
	('CID-00002', 'Neapolitan Cake', 'cake with vanilla, chocolate and strawberry layer'),
    ('CID-00003', 'Boston Cream Pie', 'sponge cake with cream and chocolate frosting');

SELECT * FROM CakeList;

CREATE TABLE PieList (
	pie_id varchar(45) PRIMARY KEY NOT NULL,
    pie_name varchar(45) NOT NULL,
	primary_ingredient varchar(90) NOT NULL
);


INSERT INTO 
	PieList (pie_id, pie_name, primary_ingredient)
VALUES 
	('PID-00001', 'Apple Pie', 'Apples'),
	('PID-00002', 'Rhubarb Pie', 'Rhubarb'),
	('PID-00003', 'Key Lime Pie', 'Limes'),
    ('PID-00004', 'Banana Cream Pie', 'Banana');

SELECT * FROM PieList;

CREATE TABLE BakeryInventory (
	dessert_name varchar(45) PRIMARY KEY NOT NULL,
    dessert_id varchar(45) NOT NULL,
    price float NOT NULL,
    stock int NOT NULL
);


INSERT INTO 
	BakeryInventory (dessert_name, dessert_id, price, stock)
VALUES 
	('Apple Pie', 'PID-00001', 24.99, 12),
    ('Rhubarb Pie', 'PID-00002', 28.99, 8),
    ('Key Lime Pie', 'PID-00003', 19.99, 10),
    ('Banana Cream Pie', 'PID-00004', 20.99, 9),
    ('German Chocolate Cake', 'CID-00001', 29.99, 8),
    ('Neapolitan Cake', 'CID-00002', 32.99, 15),
    ('Boston Cream Pie', 'CID-00003', 25.99, 22);
	
SELECT * FROM BakeryInventory;