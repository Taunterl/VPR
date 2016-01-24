drop table IF EXISTS Klassen;
drop table IF EXISTS Studenten;
drop table IF EXISTS StudentenInGruppen;
drop table IF EXISTS Gruppen;
drop table IF EXISTS Aufgaben;
drop table IF EXISTS Aufgabenpools;
drop table IF EXISTS Dozenten;

create table Dozenten (
    DozentenID varchar(3) Primary Key,
    Name varchar(20),
    Vorname varchar(20),
    Passwort varchar(20) not null
);

create table Klassen(
    Klassenbezeichnung varchar(8) Primary Key,
    Klassendozent varchar(3),
    Foreign Key (Klassendozent) references Dozenten
);

create table Studenten(
    StudentenID varchar(10) Primary Key,
    Name varchar(20) not null,
    Nachname varchar(20) not null,
    Bild varchar2(30), /* Default "Default Pfad"*/
    Klasse varchar(8),
    Foreign Key (Klasse) references Klassen (Klassenbezeichnung)
);

create table Aufgabenpool(
    AufgabenpoolID number(3) Primary Key,
    Dozent varchar(3),
    Fach varchar(3),
    Beschreibung  long,
    Foreign key (Dozent) references Dozenten (DozentenID)
); 

create table Aufgaben(
    AufgabenId number(3) Primary Key,
    Bezeichnung varchar(20),
    Beschreibung varchar(1280),
    Kategorie varchar(10),
    Bearbeitungszeit varchar(5),
    Pool number,
    Foreign Key (pool) references Aufgabenpool(AufgabenpoolID)  
    );
    
create table Gruppen(
    GruppenID number(3) Primary Key,
    Gruppenleiter varchar(10),
    GruppenGroesse number(2),
    Aufgabe number(3),
    Foreign Key (Gruppenleiter) references Studenten(StudentenID),
    Foreign Key (Aufgabe) references Aufgaben(AufgabenId)
);

Create table StudentenInGruppen(
    GruppenID number(3),
    StudentenID varchar(10),
    Foreign Key (GruppenID) references Gruppen(GruppenID),
    Foreign Key (StudentenID) references Studenten(StudentenID)
);

-- ----------------------------
-- Records of Dozenten
-- ----------------------------
INSERT INTO "main"."Dozenten" VALUES (1, 'Dyck', 'Eugen', 'test');
INSERT INTO "main"."Dozenten" VALUES (2, 'Hilbig', 'Yana', 'test');

-- ----------------------------
-- Records of Aufgabenpool
-- ----------------------------
INSERT INTO "main"."Aufgabenpool" VALUES (1, 1, 'OPR', 'GUI_Grundlagen');
INSERT INTO "main"."Aufgabenpool" VALUES (2, 2, 'SEN', 'SVN');
INSERT INTO "main"."Aufgabenpool" VALUES (3, 1, 'OPR', 'Android');


-- ----------------------------
-- Records of Aufgaben
-- ----------------------------
INSERT INTO "main"."Aufgaben" VALUES (1, 'Würfelaufgabe', 'Programmieren Sie einen Würfel', 'GUI', '2h', 1);
INSERT INTO "main"."Aufgaben" VALUES (2, 'Mehrere Szenen', 'Programmieren Sie mehrere Szenen in einem Programm', 'GUI', '1h', 1);
INSERT INTO "main"."Aufgaben" VALUES (3, 'SVN Repositorie', 'Legen Sie ein Lokales Repositorie an', 'SVN', '30min', 2);
INSERT INTO "main"."Aufgaben" VALUES (4, 'SVN SYNC', 'Checken Sie in ihrem Repository aus', 'SVN', '10min', 2);
INSERT INTO "main"."Aufgaben" VALUES (5, 'Anwendung auf Smartphone', 'Starten Sie Ihre Anwendung auf dem Smartphone', 'Android', '20min', 3);
INSERT INTO "main"."Aufgaben" VALUES (6, 'Communitcator', 'Bauen Sie eine Chat!', 'Android', '30min', 3);





