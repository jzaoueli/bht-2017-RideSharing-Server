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

-- ** insert some CG members points ** --
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus, CreationDate)
VALUES (1, 1, 'admin', '-', '-', '-', true, '2017-06-01 12:00:00');
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus, CreationDate)
VALUES (101, 1, 'user1', 'mo@mo.de', '15315326266', 'Mortiz platz 10243 Berlin', true, '2017-06-01 12:00:00');
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus, CreationDate)
VALUES (102, 1, 'user2', 'mo2@mo.de', '15315326266', 'Mortiz platz 10243 Berlin', true, '2017-06-01 12:00:00');
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus, CreationDate)
VALUES (103, 1, 'user3', 'mo3@mo.de', '15315326266', 'Mortiz platz 10243 Berlin', true, '2017-06-01 12:00:00');
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus, CreationDate)
VALUES (104, 1, 'user4', 'mo4@mo.de', '15315326266', 'Morits platz 10243 Berlin', true, '2017-06-01 12:00:00');
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus, CreationDate)
VALUES (105, 1, 'chief', 'mo4@mo.de', '15315326266', 'Morits platz 10243 Berlin', true, '2017-06-01 12:00:00');
INSERT INTO CGMEMBER (id, modificationCounter, Name, EmailAddress, MobileNumber, CGHomeLocation, ValidationStatus, CreationDate)
VALUES (106, 1, 'waiter', 'mo4@mo.de', '15315326266', 'Morits platz 10243 Berlin', true, '2017-06-01 12:00:00');

-- ** some offer **
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status, CreationDate)
VALUES (1,1, 101, 1, 2, '2017-05-10 23:59:59', 15, 3, 'medium', true, '2017-06-01 12:00:00');
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status, CreationDate)
VALUES (2,1, 101, 3, 4, '2017-05-10 23:59:59', 10, 1, 'small', true, '2017-06-01 12:00:00');
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status, CreationDate)
VALUES (3,1, 101, 5, 6, '2017-05-10 23:59:59', 5, 2, 'large', true, '2017-06-01 12:00:00');
INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status, CreationDate)
VALUES (4,1, 101, 1, 6, '2017-05-10 23:59:59', 20, 4, 'small', true, '2017-06-01 12:00:00');
--INSERT INTO RSOFFER (ID ,modificationCounter,UserID ,FromLocation , ToLocation , DepartureTime ,Delay ,NumberOfPlaces ,LuggageSpace , Status) VALUES (5,0, 101, 3, 6, '2017-05-10 23:59:59', 12, 5, 'medium', true);

-- ** some requests ** --
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped, CreationDate)
VALUES (1, 1, 103, 1, 2, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 2, 'medium', 1, '2017-06-01 12:00:00');
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped, CreationDate)
VALUES (2,1, 104, 3, 6, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 1, 'medium', 1, '2017-06-01 12:00:00');
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped, CreationDate)
VALUES (3,1, 103, 1, 6, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 1, 'medium', 1, '2017-06-01 12:00:00');
INSERT INTO REQUEST (ID ,modificationCounter,UserID ,FromLocation, ToLocation , EarliestDepartureTime , LatestDepartureTime , NumberOfPlaces , LuggageSpace , RSOfferIDMapped, CreationDate)
VALUES (4,1, 102, 2, 6, '2017-05-10 23:59:59', '2017-05-10 23:59:59', 2, 'medium', 1, '2017-06-01 12:00:00');

--- 
INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (1, 0, 3, 'chief', 'Charly', 'Chief');
INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (2, 0, 0, 'cook', 'Carl', 'Cook');
INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (3, 0, 1, 'waiter', 'Willy', 'Waiter');
INSERT INTO STAFFMEMBER (id, modificationCounter, role, login, firstname, lastname) VALUES (4, 0, 2, 'barkeeper', 'Bianca', 'Barkeeper');