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
	

CREATE TABLE Cakes (
	cake_id varchar(45) Primary Key NOT NULL,
  	cake_name varchar(45) NOT NULL,
  	description varchar(90) NOT NULL
);

INSERT INTO 
	Cakes (cake_id, cake_name, description)
VALUES 
	('CID-00001', 'German Chocolate Cake', 'layered chocolate cake filled and topped with a coconut-pecan frosting'),
	('CID-00002', 'Neapolitan Cake', 'cake with vanilla, chocolate and strawberry layer'),
    ('CID-00003', 'Boston Cream Pie', 'sponge cake with cream and chocolate frosting');

SELECT * FROM Cakes;

CREATE TABLE Bakeries (
	bakery_id varchar(45) PRIMARY KEY NOT NULL,
	bakery_name varchar(45) NOT NULL,
	city varchar(45) NOT NULL,
	state varchar(45) NOT NULL
);

INSERT INTO 
	Bakeries (bakery_id, bakery_name, city, state)
VALUES 
    ('BID-00077', 'Yoyo Bakery', 'Mountain View', 'California'),
    ('BID-00093', 'French Lick Bakery', 'French Lick', 'Indiana'),
    ('BID-00024', 'Palm Beach Bakery', 'Palm Beach', 'Florida');
	
SELECT * FROM Bakeries;

CREATE TABLE BakeryInventory (
	bakery_inventory_id varchar(45) PRIMARY KEY NOT NULL,
	dessert_name varchar(45) NOT NULL,
    dessert_id varchar(45) REFERENCES Cakes(cake_id) NOT NULL,
    price float NOT NULL,
    stock int NOT NULL,
	bakery_id varchar(45) REFERENCES Bakeries(bakery_id) NOT NULL
);

INSERT INTO 
	BakeryInventory (bakery_inventory_id, dessert_name, 
					 dessert_id, price, stock, bakery_id)
VALUES 
    ('BIn-00001', 'German Chocolate Cake', 'CID-00001', 29.99, 8, 'BID-00077'),
    ('BIn-00002', 'Neapolitan Cake', 'CID-00002', 32.99, 15, 'BID-00077'),
    ('BIn-00003', 'Boston Cream Pie', 'CID-00003', 25.99, 22, 'BID-00077'),
	('BIn-00004', 'German Chocolate Cake', 'CID-00001', 27.99, 13, 'BID-00093'),
    ('BIn-00005', 'Neapolitan Cake', 'CID-00002', 33.99, 24, 'BID-00093'),
    ('BIn-00006', 'Boston Cream Pie', 'CID-00003', 22.99, 14, 'BID-00093'),
	('BIn-00007', 'German Chocolate Cake', 'CID-00001', 30.99, 20, 'BID-00024'),
    ('BIn-00008', 'Neapolitan Cake', 'CID-00002', 27.99, 10, 'BID-00024'),
    ('BIn-00009', 'Boston Cream Pie', 'CID-00003', 32.99, 8, 'BID-00024');
	
SELECT * FROM BakeryInventory;

