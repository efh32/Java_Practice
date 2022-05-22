CREATE DATABASE IF NOT EXISTS Bakery;

USE Bakery;

CREATE TABLE CakeList (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(90) NOT NULL,
  `price` int NOT NULL,
  `stock` int NOT NULL,
  primary key(`id`)
);

DROP TABLE CakeList;

INSERT INTO CakeList (id, name, description, price, stock)
VALUES ('ID-00001', 'German Chocolate Cake', 'layered chocolate cake filled and topped with a coconut-pecan frosting', 30, 12);

INSERT INTO CakeList (id, name, description, price, stock)
VALUES ('ID-00022', 'Neapolitan Cake', 'cake with vanilla, chocolate and strawberry layer', 35, 7);

SELECT * FROM CakeList

