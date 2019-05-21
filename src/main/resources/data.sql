INSERT INTO Customer(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, PREMIUM)
VALUES('David', 'Sodergren', 'david@gmail.com', '123', 'Femstenaveigen 2', 0);
INSERT INTO Customer(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, PREMIUM)
VALUES('Adam', 'Backstrom', 'adam@gmail.com', '123', 'Skanstull 2', 0);
INSERT INTO Customer(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, PREMIUM)
VALUES('Jonas', 'Hallstrom', 'jonas@gmail.com', '123', 'Skanstull 2', 0);
INSERT INTO Customer(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, PREMIUM)
VALUES('Lukas', 'Ninja', 'lukas@gmail.com', '123', 'Lunchhemgang 2', 0);


INSERT INTO Admin(FIRSTNAME, LASTNAME, EMAIL, PASSWORD)
VALUES('LukasAdmin', 'Halfgard', 'lukasadmin@gmail.com', '123');
INSERT INTO Admin(FIRSTNAME, LASTNAME, EMAIL, PASSWORD)
VALUES('David', 'Sodergren', 'davidadmin@gmail.com', '123');
INSERT INTO Admin(FIRSTNAME, LASTNAME, EMAIL, PASSWORD)
VALUES('Jonas', 'Halfstrom', 'jonasadmin@gmail.com', '123');
INSERT INTO Admin(FIRSTNAME, LASTNAME, EMAIL, PASSWORD)
VALUES('Adam', 'Backstrom', 'adamadmin@gmail.com', '123');



INSERT INTO Flower(NAME, DESCRIPTION, PRICE, PICTUREURL)
VALUES('Pellargon', 'Beutiful flower that comes in many colours', 200, 'wwww.testurl.com');
INSERT INTO Flower(NAME, DESCRIPTION, PRICE, PICTUREURL)
VALUES('Elephant ear', 'Beutiful flower that comes with round and crispy leafs, this flower can also be ' ||
  'eaten if you have a month with not so much money', 150, 'wwww.testurl.com');
INSERT INTO Flower(NAME, DESCRIPTION, PRICE, PICTUREURL)
VALUES('Rose', 'Beutiful rose in red and yellow, perfect as a gift to your loved one', 300, 'wwww.testurl.com');
