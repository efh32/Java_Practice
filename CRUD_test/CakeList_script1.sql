CREATE DATABASE IF NOT EXISTS Bakery;

USE Bakery;

CREATE TABLE CakeList (
  `cake_id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(90) NOT NULL,
  primary key(`cake_id`)
);

INSERT INTO 
	CakeList (cake_id, name, description)
VALUES 
	('CID-00001', 'German Chocolate Cake', 'layered chocolate cake filled and topped with a coconut-pecan frosting'),
	('CID-00002', 'Neapolitan Cake', 'cake with vanilla, chocolate and strawberry layer'),
    ('CID-00003', 'Boston Cream Pie', 'sponge cake with cream and chocolate frosting');

SELECT * FROM CakeList;

CREATE TABLE PieList (
	`pie_id` varchar(45) NOT NULL,
    `name` varchar(45) NOT NULL,
	`primary_ingredient` varchar(90) NOT NULL,
    primary key(`pie_id`)
);


INSERT INTO 
	PieList (pie_id, name, primary_ingredient)
VALUES 
	('PID-00001', 'Apple Pie', 'Apples'),
	('PID-00002', 'Rhubarb Pie', 'Rhubarb'),
	('PID-00003', 'Key Lime Pie', 'Limes'),
    ('PID-00004', 'Banana Cream Pie', 'Banana');

SELECT * FROM PieList;

CREATE TABLE BakeryInventory (
	`name` varchar(45) NOT NULL,
    `id` varchar(45) NOT NULL,
    `price` double NOT NULL,
    `stock` int NOT NULL
);

INSERT INTO 
	BakeryInventory (name, id, price, stock)
VALUES 
	('Apple Pie', 'PID-00001', 24.99, 12),
    ('Rhubarb Pie', 'PID-00002', 28.99, 8),
    ('Key Lime Pie', 'PID-00003', 19.99, 10),
    ('Banana Cream Pie', 'PID-00004', 20.99, 9),
    ('German Chocolate Cake', 'CID-00001', 29.99, 8),
    ('Neapolitan Cake', 'CID-00002', 32.99, 15),
    ('Boston Cream Pie', 'CID-00003', 25.99, 22);
	
SELECT * FROM BakeryInventory;
