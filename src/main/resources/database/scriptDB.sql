CREATE DATABASE vandrc

USE vandrc

CREATE TABLE customers(
customerID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45),
surname varchar(45),
mail varchar(45),
password varchar(45),
discount double
);

CREATE TABLE workers(
workerID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45),
surname varchar(45),
mail varchar(45),
password varchar(45)
);

CREATE TABLE allergens(
allergenID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45)
);

CREATE TABLE tools(
toolID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(45),
path varchar(200)
);

CREATE TABLE tags(
tagID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
toolID int,
tagName varchar(45),
FOREIGN KEY (toolID) REFERENCES tools(toolID)
);

CREATE TABLE orders(
orderID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
workerID int,
customerID int,
inDate date,
outDate date,
status varchar(45),
value int, -- float
size int,
sizeType varchar(45),
description varchar(255),
allergenDescription varchar(255),
phoneNumber varchar(15)
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

