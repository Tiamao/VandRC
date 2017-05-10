CREATE DATABASE vandrc;

USE vandrc;

CREATE TABLE customers(
customerID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45),
surname varchar(45),
mail varchar(70),
password varchar(32),
status boolean
);

CREATE TABLE workers(
workerID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45),
surname varchar(45),
mail varchar(45),
password varchar(32),
status boolean
);

CREATE TABLE allergens(
allergenID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45),
status boolean
);

CREATE TABLE tools(
toolID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45),
path varchar(200),
status boolean
);

CREATE TABLE tags(
tagID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
toolID int,
tagName varchar(45),
FOREIGN KEY (toolID) REFERENCES tools(toolID)
);

CREATE TABLE statuses(
statusID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
description varchar(30)
);

CREATE TABLE gallery(
galleryID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
title varchar(30),
photoPath varchar(255)
);

CREATE TABLE products(
productID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
galleryID int,
description text,
workerID int,
modificationDate date,
warnings text,
status boolean,
FOREIGN KEY (galleryID) REFERENCES gallery(galleryID),
FOREIGN KEY (workerID) REFERENCES workers(workerID)
);

CREATE TABLE orders(
orderID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
productID int,
workerID int,
customerID int,
inDate date,
outDate date,
statusID int,
price decimal,
size int,
sizeType varchar(45),
description text,
phoneNumber varchar(15),
discount double,
FOREIGN KEY (workerID) REFERENCES workers(workerID),
FOREIGN KEY (customerID) REFERENCES customers(customerID),
FOREIGN KEY (statusID) REFERENCES statuses(statusID),
FOREIGN KEY (productID) REFERENCES products(productID)
);

CREATE TABLE toolsInOrder(
tioID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
orderID int,
toolID int,
FOREIGN KEY (toolID) REFERENCES tools(toolID),
FOREIGN KEY (orderID) REFERENCES orders(orderID)
);

CREATE TABLE allergensInOrder(
aioID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
orderID int,
allergenID int,
FOREIGN KEY (allergenID) REFERENCES allergens(allergenID),
FOREIGN KEY (orderID) REFERENCES orders(orderID)
);

CREATE TABLE allergensInProduct(
aimID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
productID int,
allergenID int,
FOREIGN KEY (allergenID) REFERENCES allergens(allergenID),
FOREIGN KEY (productID) REFERENCES products(productID)
);