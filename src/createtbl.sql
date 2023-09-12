-- Include your create table DDL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO cs421;

-- Remember to put the create table ddls for the tables with foreign key references
--    ONLY AFTER the parent tables has already been created.

-- This is only an example of how you add create table ddls to this file.
--   You may remove it.
--CREATE TABLE MYTEST01
--(
--  id INTEGER NOT NULL
-- ,value INTEGER
 --,PRIMARY KEY(id)
--);
CREATE TABLE Category
(cname VARCHAR(30) NOT NULL,
 prioritynum INTEGER,
 PRIMARY KEY (cname));

CREATE TABLE Person
(hinsurnum VARCHAR(50) NOT NULL,
 name VARCHAR(30) NOT NULL ,
 gender VARCHAR(10) ,
 dob DATE NOT NULL ,
 phone VARCHAR(30) NOT NULL ,
 city VARCHAR(50) ,
 postalcd VARCHAR(50) ,
 streetaddr VARCHAR(50) ,
 regdate DATE NOT NULL ,
 cname VARCHAR(30) NOT NULL,
 PRIMARY KEY (hinsurnum),
 FOREIGN KEY (cname) REFERENCES Category);

CREATE TABLE Vaccine
(vname VARCHAR(30) NOT NULL,
 waitperiod VARCHAR(30) NOT NULL ,
 doses INTEGER NOT NULL ,
 PRIMARY KEY (vname));

CREATE TABLE VaccLocation
(locname VARCHAR(30) NOT NUll,
 lcity VARCHAR(30) NOT NULL ,
 lpostalcd VARCHAR(30) NOT NULL ,
 lstreetaddr VARCHAR(50) NOT NULL ,
 PRIMARY KEY (locname));

CREATE TABLE VaccineBatch
(vname VARCHAR(30) NOT NULL ,
 batchno VARCHAR(30) NOT NUll,
 mfgdate DATE NOT NULL ,
 exprydate DATE NOT NULL ,
 numdoses INTEGER NOT NULL ,
 locname VARCHAR(30) NOT NUll,
 PRIMARY KEY (vname, batchno),
 FOREIGN KEY (vname)  REFERENCES Vaccine,
 FOREIGN KEY (locname) REFERENCES VaccLocation
);

CREATE TABLE Vial
(vname VARCHAR(30) NOT NULL ,
 batchno VARCHAR(30) NOT NULL ,
 vialid VARCHAR(50) NOT NULL UNIQUE ,
 PRIMARY KEY (vname, batchno, vialid),
 FOREIGN KEY (vname, batchno) REFERENCES VaccineBatch);

CREATE TABLE Hospital
(locname VARCHAR(30) NOT NUll,
 PRIMARY KEY (locname),
 FOREIGN KEY (locname) REFERENCES VaccLocation);

CREATE TABLE Nurse
(licensenum VARCHAR(50) NOT NUll,
 name VARCHAR(30) NOT NULL ,
 locname VARCHAR(30) ,
 PRIMARY KEY (licensenum),
 FOREIGN KEY (locname) REFERENCES Hospital);

CREATE TABLE VaccDates
(locname VARCHAR(30) NOT NUll,
 vdate DATE NOT NUll,
 PRIMARY KEY (locname, vdate),
 FOREIGN KEY (locname) REFERENCES VaccLocation);

CREATE TABLE VaccSlot
(locname VARCHAR(30) NOT NUll,
 vdate DATE NOT NUll,
 vtime TIME NOT NUll,
 vslot INTEGER NOT NUll,
 hinsurnum VARCHAR(50),
 asgndate DATE,
 licensenum VARCHAR(50),
 vname VARCHAR(30) ,
 batchno VARCHAR(30) ,
 vialid VARCHAR(50) ,
 PRIMARY KEY (locname, vdate, vtime, vslot),
 FOREIGN KEY (locname, vdate) REFERENCES VaccDates,
 FOREIGN KEY (licensenum) REFERENCES Nurse,
 FOREIGN KEY (hinsurnum) REFERENCES Person,
 FOREIGN KEY (vname, batchno, vialid) REFERENCES Vial);

CREATE TABLE NurseAssignments
(licensenum VARCHAR(50) NOT NUll,
 locname VARCHAR(30) NOT NUll,
 vdate DATE NOT NUll,
 PRIMARY KEY (licensenum, locname, vdate),
 FOREIGN KEY (licensenum) REFERENCES Nurse,
 FOREIGN KEY (locname, vdate) REFERENCES VaccDates);
