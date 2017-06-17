-- Rename this file to V0002__R001_Master_data_MYSQL.sql.mysql if the database used is not MariaDB 10.0.27


-- ** insert some transport points ** --
INSERT INTO TRANSPORTPOINT (ID ,modificationCounter, Name ,CGLocation ,Country ,City ,LocationAddress, GPSCoordination) 
VALUES (1, 1, "Berlin Niederlassung", true, 'City1', 'Germany', 'Potsdamer platz 10243 Berlin', '52.5457966,13.5066605');
INSERT INTO TRANSPORTPOINT (ID ,modificationCounter, Name ,CGLocation ,Country ,City ,LocationAddress, GPSCoordination) 
VALUES (2, 1,"Hannover Niederlassung", true, 'City2', 'Germany', 'Potsdamer platz 10243 Berlin', '52.5457966,13.5066605');
INSERT INTO TRANSPORTPOINT (ID ,modificationCounter, Name ,CGLocation ,Country ,City ,LocationAddress, GPSCoordination) 
VALUES (3, 1,"Frankfurt Niederlassung", true, 'City3', 'Germany', 'Potsdamer platz 10243 Berlin', '52.5457966,13.5066605');
INSERT INTO TRANSPORTPOINT (ID ,modificationCounter, Name ,CGLocation ,Country ,City ,LocationAddress, GPSCoordination)
VALUES (4, 1,"Duesseldorf Niederlassung", true, 'City4', 'Germany', 'Potsdamer platz 10243 Berlin', '52.5457966,13.5066605');
INSERT INTO TRANSPORTPOINT (ID ,modificationCounter, Name ,CGLocation ,Country ,City ,LocationAddress, GPSCoordination) 
VALUES (5, 1,"Stuttgart Niederlassung", true, 'City5', 'Germany', 'Potsdamer platz 10243 Berlin', '52.5457966,13.5066605');
INSERT INTO TRANSPORTPOINT (ID ,modificationCounter, Name ,CGLocation ,Country ,City ,LocationAddress, GPSCoordination) 
VALUES (6, 1,"Muenchen Niederlassung", true, 'City6', 'Germany', 'Potsdamer platz 10243 Berlin', '52.5457966,13.5066605');
INSERT INTO TRANSPORTPOINT (ID ,modificationCounter, Name ,CGLocation ,Country ,City ,LocationAddress, GPSCoordination) 
VALUES (7, 1,"Berlin Flughafen", false, 'City6', 'Germany', 'Potsdamer platz 10243 Berlin', '52.5457966,13.5066605');

-- ** insert some Capgemini members points ** --
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus) 
VALUES (101, 1, 'user1', 'mo@mo.de', '15315326266', 'Mortiz platz 10243 Berlin', true);
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus) 
VALUES (102, 1, 'user2', 'mo2@mo.de', '15315326266', 'Mortiz platz 10243 Berlin', true);
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus) 
VALUES (103, 1, 'user3', 'mo3@mo.de', '15315326266', 'Mortiz platz 10243 Berlin', true);
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus) 
VALUES (104, 1, 'user4', 'mo4@mo.de', '15315326266', 'Morits platz 10243 Berlin', true);

-- ** some offer **
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status) 
VALUES (1,1, 101, 1, 2, '2017-05-10 23:59:59', 15, 3, 'medium', true);
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status) 
VALUES (2,1, 101, 3, 4, '2017-05-10 23:59:59', 10, 1, 'small', true);
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status) 
VALUES (3,1, 101, 5, 6, '2017-05-10 23:59:59', 5, 2, 'large', true);
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status) 
VALUES (4,1, 101, 1, 6, '2017-05-10 23:59:59', 20, 4, 'small', true);
--INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status) VALUES (5,0, 101, 3, 6, '2017-05-10 23:59:59', 12, 5, 'medium', true);

-- ** some requests ** --
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped) 
VALUES (1, 1, 103, 1, 2, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 2, 'medium', 1);
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped) 
VALUES (2,1, 104, 3, 6, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 1, 'medium', 1);
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped) 
VALUES (3,1, 103, 1, 6, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 1, 'medium', 1);
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped) 
VALUES (4,1, 102, 2, 6, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 2, 'medium', 1);


--- 
INSERT INTO RESTAURANTTABLE (id, modificationCounter, number, state) VALUES (101, 1, 1, 2);
INSERT INTO RESTAURANTTABLE (id, modificationCounter, number, state) VALUES (102, 1, 2, 0);
INSERT INTO RESTAURANTTABLE (id, modificationCounter, number, state) VALUES (103, 1, 3, 0);
INSERT INTO RESTAURANTTABLE (id, modificationCounter, number, state) VALUES (104, 1, 4, 0);
INSERT INTO RESTAURANTTABLE (id, modificationCounter, number, state) VALUES (105, 1, 5, 0);

INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (1, 1, 'Meal', 'Schnitzel');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (2, 1, 'Meal', 'Goulasch');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (3, 1, 'Meal', 'Pfifferlinge');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (4, 1, 'Meal', 'Salat');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (5, 1, 'Meal', 'Pizza');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (6, 1, 'Meal', 'Flammkuchen');

INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (7, 1, 'SideDish', 'Pommes');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (8, 1, 'SideDish', 'Reis');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (9, 1, 'SideDish', 'Brot');
INSERT INTO PRODUCT (id, modificationCounter, dType, description) VALUES (10, 1, 'SideDish', 'Knödel');

INSERT INTO PRODUCT (id, modificationCounter, alcoholic, dType, description) VALUES (11, 1, false, 'Drink', 'Wasser');
INSERT INTO PRODUCT (id, modificationCounter, alcoholic, dType, description) VALUES (12, 1, false, 'Drink', 'Cola');
INSERT INTO PRODUCT (id, modificationCounter, alcoholic, dType, description) VALUES (13, 1, false, 'Drink', 'Bier');
INSERT INTO PRODUCT (id, modificationCounter, alcoholic, dType, description) VALUES (14, 1, false, 'Drink', 'Wein / Apfelwein');

INSERT INTO OFFER (id, modificationCounter, state, price, mealId, sideDishId, drinkId, name, description) VALUES (1, 1, 0, 6.99, 1, 7, 12, 'Schnitzel-Menü', 'Description of Schnitzel-Menü');
INSERT INTO OFFER (id, modificationCounter, state, price, mealId, sideDishId, drinkId, name, description) VALUES (2, 1, 0, 7.99, 2, 8, 13, 'Goulasch-Menü', 'Description of Goulasch-Menü');
INSERT INTO OFFER (id, modificationCounter, state, price, mealId, sideDishId, drinkId, name, description) VALUES (3, 1, 0, 8.99, 3, 10, 14, 'Pfifferlinge-Menü', 'Description of Pfifferlinge-Menü');
INSERT INTO OFFER (id, modificationCounter, state, price, mealId, sideDishId, drinkId, name, description) VALUES (4, 1, 0, 5.99, 4, 9, 11, 'Salat-Menü', 'Description of Salat-Menü');
INSERT INTO OFFER (id, modificationCounter, state, price, mealId, sideDishId, drinkId, name, description) VALUES (5, 1, 0, 1.20, null, null, 12, 'Cola', 'Description of Salat-Menü');
INSERT INTO OFFER (id, modificationCounter, state, price, mealId, sideDishId, drinkId, name, description) VALUES (6, 1, 0, 6.23, 5, null, 12, 'Pizza-Menü', 'Description of Pizza-Menü');
INSERT INTO OFFER (id, modificationCounter, state, price, mealId, sideDishId, drinkId, name, description) VALUES (7, 1, 0, 5.99, 6, null, 12, 'Flammkuchen-Menü', 'Description of Flammkuchen-Menü');

INSERT INTO RESTAURANTORDER (id, modificationCounter, tableId, state) VALUES (1, 1, 101, 1);

INSERT INTO ORDERPOSITION (id, modificationCounter, offerId, state, drinkState, orderId, price, offerName, comment) VALUES (1, 1, 1, 2, 2, 1, 6.99, 'Schnitzel-Menü', 'mit Ketschup');
INSERT INTO ORDERPOSITION (id, modificationCounter, offerId, state, drinkState, orderId, price, offerName, comment) VALUES (2, 1, 2, 2, 2, 1, 7.99, 'Goulasch-Menü', '');
INSERT INTO ORDERPOSITION (id, modificationCounter, offerId, state, drinkState, orderId, price, offerName, comment) VALUES (3, 1, 3, 2, 2,  1, 8.99, 'Pfifferlinge-Menü','');
INSERT INTO ORDERPOSITION (id, modificationCounter, offerId, state, drinkState, orderId, price, offerName, comment) VALUES (4, 1, 4, 2, 2, 1, 5.99, 'Salat-Menü', '');
INSERT INTO ORDERPOSITION (id, modificationCounter, offerId, state, drinkState, orderId, price, offerName, comment) VALUES (5, 1, 5, 2, 2, 1, 5.99, 'Cola', '');

INSERT INTO BILL (id, modificationCounter, payed, total, tip) VALUES (1, 1, TRUE, 14.98, 1.3);

INSERT INTO BILLORDERPOSITION (billId, orderPositionsId) VALUES (1,1);
INSERT INTO BILLORDERPOSITION (billId, orderPositionsId) VALUES (1,2);

INSERT INTO BILL (id, modificationCounter, payed, total,tip) VALUES (2, 1, TRUE, 14.98, 1.4);

INSERT INTO BILLORDERPOSITION (billId, orderPositionsId) VALUES (2,3);
INSERT INTO BILLORDERPOSITION (billId, orderPositionsId) VALUES (2,4);

INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (1, 0, 3, 'chief', 'Charly', 'Chief');
INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (2, 0, 0, 'cook', 'Carl', 'Cook');
INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (3, 0, 1, 'waiter', 'Willy', 'Waiter');
INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (4, 0, 2, 'barkeeper', 'Bianca', 'Barkeeper');