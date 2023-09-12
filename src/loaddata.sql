-- Include your INSERT SQL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO cs421;

-- Remember to put the INSERT statements for the tables with foreign key references
--    ONLY AFTER the parent tables!

-- This is only an example of how you add INSERT statements to this file.
--   You may remove it.
--INSERT INTO MYTEST01 (id, value) VALUES(4, 1300);
-- A more complex syntax that saves you typing effort.
--INSERT INTO MYTEST01 (id, value) VALUES
-- (7, 5144)
--,(3, 73423)
--,(6, -1222)
--;

INSERT INTO Category (cname, prioritynum) VALUES
('Health Care worker', 1)
,('Children below 10', 2)
,('Essential Service Worker', 3)
,('Everybody else', 4)  --?
,('Teacher', 2)
,('Elderly (>= 65)', 1)

;

INSERT INTO Person (hinsurnum, name, gender, dob, phone, city, postalcd, streetaddr, regdate, cname) VALUES
('16411001 3267','Abdul','male','02/13/1973','1-119-597-1486','Laval','H7K 3K7','4624 Rue du Pirée','01/14/2021','Health Care worker')
,('16630206 9841','Jane Doe','female','10/08/1985','1-591-397-5435','Montreal','H1T 2R9','6817 43 Av','01/20/2021','Children below 10')
,('16761123 8648','Zenaida','female','03/21/2010','1-512-580-2125','Laval','H7R 4X4','1073 40E Av','01/10/2021','Essential Service Worker')
,('16721125 0878','Sage','female','05/05/1982','1-985-478-1731','Montreal','H2R 2E7','7503 Rue St Denis','11/04/2020','Teacher')
,('16370119 0492','Tamekah','male','03/16/1995','1-289-106-9144','Laval','H7M 2R6','1731 Rue Le Royer','01/15/2021','Everybody else')
,('97721125 7778','Jack','male','07/05/1950','1-777-478-1731','Montreal','H7R 2A7','7503 Rue St catherine','12/04/2020','Elderly (>= 65)')
,('97700125 7678','Bob','male','07/05/1982','1-797-478-1673','Montreal','H8R 1B7','6662 50E Av','12/04/2020','Teacher')
,('98821125 7778','Jane','female','11/05/1991','1-557-478-1731','Montreal','H7A 3A9','7798 Rue Uni','12/04/2020','Teacher')
;

INSERT INTO Vaccine (vname, waitperiod, doses) VALUES
('Pfizer-BioNTech','2 month',2)
,('Moderna','1 month',3)
;

INSERT INTO VaccLocation (locname, lcity,lpostalcd,lstreetaddr) VALUES
('Jewish General','Montreal','H2B 1K3','2180 rue Fleury Est')
,('Hôpital Jean-Talon','Laval','H2X 1A2','7193 Sed St.')
,('GLEN super hospital','Montreal','H2X 0C1','7134 Purus. Ave')
,('Hôtel-Dieu de Montréal','Montreal','H7K 1A3','8168 Vestibulum Rd.')
,('Hôpital Santa-Cabrini','Quebec city','H7A 5K2','P.O. Box 126, 193 Ipsum. Road')
;

INSERT INTO VaccineBatch (vname, batchno, mfgdate,exprydate,numdoses, locname) VALUES
('Pfizer-BioNTech','16910817 1241','01/05/2021','09/19/2023',30,'Jewish General')
,('Pfizer-BioNTech','16110220 6073','12/30/2020','07/03/2023',30,'Hôpital Jean-Talon')
,('Moderna','16940311 3203','11/21/2020','04/15/2022',40,'GLEN super hospital')
,('Pfizer-BioNTech','16660806 5931','12/04/2020','06/24/2023',30,'Hôtel-Dieu de Montréal')
,('Pfizer-BioNTech','16581006 3858','01/21/2021','12/15/2023',40,'Hôpital Santa-Cabrini')
,('Pfizer-BioNTech','16942777 3209','10/21/2020','04/15/2023',40,'Jewish General')
;

INSERT INTO Vial (vname,batchno,vialid) VALUES
('Pfizer-BioNTech','16910817 1241','16981215 9680')
,('Pfizer-BioNTech','16110220 6073','16370721 6960')
,('Moderna','16940311 3203','16741004 2829')
,('Moderna','16940311 3203','16741004 2830')
,('Pfizer-BioNTech','16660806 5931','16010830 3181')
,('Pfizer-BioNTech','16581006 3858','16800703 8923')
,('Pfizer-BioNTech','16942777 3209','77770703 8917')
,('Pfizer-BioNTech','16942777 3209','77770703 8918')
,('Pfizer-BioNTech','16942777 3209','77770703 8919')
;

INSERT INTO Hospital (locname) VALUES
('Jewish General')
,('Hôpital Jean-Talon')
,('GLEN super hospital')
,('Hôtel-Dieu de Montréal')
,('Hôpital Santa-Cabrini')
;

INSERT INTO Nurse (licensenum, name, locname) VALUES
('16040111 4509','Preston','Jewish General')
,('16251212 4799','Keefe','Hôpital Jean-Talon')
,('16831205 4375','Harlan','GLEN super hospital')
,('16021127 7314','Chantale','Hôtel-Dieu de Montréal')
,('16800628 8628','Melanie','Hôpital Santa-Cabrini')
,('77770111 7709','Amy','Jewish General')
;

INSERT INTO VaccDates (locname, vdate) VALUES
('Jewish General','03/20/2021')
,('Hôpital Jean-Talon','02/06/2021')
,('GLEN super hospital','02/06/2021')
,('Hôtel-Dieu de Montréal','01/27/2021')
,('Hôpital Santa-Cabrini','07/28/2021')
,('Jewish General','01/20/2021')
;

INSERT INTO VaccSlot (locname,vdate,vtime,vslot, hinsurnum,asgndate, licensenum, vname,batchno,vialid) VALUES
('Jewish General','03/20/2021','12:00',6,'16411001 3267','01/21/2020','16040111 4509','Pfizer-BioNTech','16910817 1241','16981215 9680')
,('Hôpital Jean-Talon','02/06/2021','08:30',8,'16630206 9841','09/30/2020','16251212 4799','Pfizer-BioNTech','16110220 6073','16370721 6960')
,('GLEN super hospital','02/06/2021','14:30',1,'16761123 8648','07/11/2020','16831205 4375','Moderna','16940311 3203','16741004 2829')
,('GLEN super hospital','02/06/2021','15:30',2,'16721125 0878','01/01/2021','16831205 4375','Moderna','16940311 3203','16741004 2830')
,('Hôtel-Dieu de Montréal','01/27/2021','16:00',10,'16721125 0878','12/31/2020','16021127 7314','Pfizer-BioNTech','16660806 5931','16010830 3181')
,('Hôpital Santa-Cabrini','07/28/2021','09:00',9,'16370119 0492','10/21/2020','16800628 8628','Pfizer-BioNTech','16581006 3858','16800703 8923')
,('Jewish General','01/20/2021','09:30',3,'97721125 7778','11/21/2020','77770111 7709','Pfizer-BioNTech','16942777 3209','77770703 8917')
,('Jewish General','03/20/2021','10:30',4,'97700125 7678','11/21/2020','77770111 7709','Pfizer-BioNTech','16942777 3209','77770703 8918')
,('Jewish General','03/20/2021','11:30',5,'98821125 7778','11/21/2020','77770111 7709','Pfizer-BioNTech','16942777 3209','77770703 8919')
,('Jewish General','03/20/2021','12:30',7,null,null,null,null,null,null)
,('Jewish General','03/20/2021','13:30',8,null,null,null,null,null,null)
,('Jewish General','03/20/2021','14:30',9,null,null,null,null,null,null)
;

INSERT INTO NurseAssignments (licensenum, locname,vdate) VALUES
('16040111 4509','Jewish General','03/20/2021')
,('16251212 4799','Hôpital Jean-Talon','02/06/2021')
,('16831205 4375','GLEN super hospital','02/06/2021')
,('16021127 7314','Hôtel-Dieu de Montréal','01/27/2021')
,('16800628 8628','Hôpital Santa-Cabrini','07/28/2021')
,('77770111 7709','Jewish General', '01/20/2021')
,('77770111 7709','Jewish General', '03/20/2021')
;

