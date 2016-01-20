--Dozenten
insert into Dozenten (DozentenID , Name, Vorname, Passwort) 
values ('DYC','Dyck','Eugen','test');
insert into Dozenten (DozentenID , Name, Vorname, Passwort) 
values ('HIL','Yanna','Hilbig','test2');
insert into Dozenten (DozentenID , Name, Vorname, Passwort) 
values ('GLR','Renè','Glass','test3');

--Klassen
insert into Klassen (Klassenbezeichnung, Klassendozent) 
values ('ibd2h14b','DYC');
insert into Klassen (Klassenbezeichnung, Klassendozent) 
values ('ibw2h14a','DYC');
insert into Klassen (Klassenbezeichnung, Klassendozent) 
values ('ibm2h14b','GLR');

--Studenten
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibd2h14bel','Ellerbrock','Dominik','ibd2h14b');
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibd2h14bst','Stussig','Conny','ibd2h14b');
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibd2h14bko','Kötter','Nick','ibd2h14b');
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibd2h14bhi','Hiller','Lennard','ibd2h14b');
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibw2h14aho','Hooge','Thomas','ibw2h14a');
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibw2h14ahe','Heumann','Alexander','ibw2h14a');
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibw2h14aha','Ha','Tuan','ibw2h14a');
insert into Studenten (StudentenID,Name,Vorname,Klasse) 
values ('ibw2h14akl','Klement','Fabio','ibw2h14a');

--Aufgabenpool
insert into Aufgabenpool (AufgabenpoolID,Dozent,Fach,Beschreibung) 
values (1,'DYC','PRG','Eugen´s Aufgaben');
insert into Aufgabenpool (AufgabenpoolID,Dozent,Fach,Beschreibung) 
values (5,'HIL','SEN','SEN Kram');
insert into Aufgabenpool (AufgabenpoolID,Dozent,Fach,Beschreibung) 
values (3,'GLR','AUV','Filmzeug');

--Aufgaben
insert into Aufgaben (AufgabenID,Bezeichnung,Beschreibung,Kategorie,Bearbeitungszeit,Pool) 
values (1,'Hello World','Erstes Programm mit Java','Tutorial','15min',1);
insert into Aufgaben (AufgabenID,Bezeichnung,Beschreibung,Kategorie,Bearbeitungszeit,Pool) 
values (2,'Array','So funtioniert ein Array','Tutorial','20min',1);
insert into Aufgaben (AufgabenID,Bezeichnung,Beschreibung,Kategorie,Bearbeitungszeit,Pool) 
values (4,'UML','UML-Diagramme','Diagramme','1h',5);
insert into Aufgaben (AufgabenID,Bezeichnung,Beschreibung,Kategorie,Bearbeitungszeit,Pool) 
values (3,'Dramaturgie','Erstellung einer Dramenstrucktur','Tutorial','20min',3);

--Gruppen
insert into Gruppen (GruppenID,Gruppenleiter,GruppenGroesse,Aufgabe) 
values (1,'ibd2h14bko',2,1);
insert into Gruppen (GruppenID,Gruppenleiter,GruppenGroesse,Aufgabe) 
values (3,'ibd2h14bst',2,2);

--StudentenInGruppen
insert into StudentenInGruppen (GruppenID,StudentenID) 
values (1,'ibd2h14bko');
insert into StudentenInGruppen (GruppenID,StudentenID) 
values (1,'ibd2h14bhi');
insert into StudentenInGruppen (GruppenID,StudentenID) 
values (3,'ibd2h14bel');
insert into StudentenInGruppen (GruppenID,StudentenID) 
values (3,'ibd2h14bst');


