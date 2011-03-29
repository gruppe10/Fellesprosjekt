CREATE TABLE Person (
           ansattnr INT PRIMARY KEY NOT NULL,
           navn VARCHAR(50) NOT NULL,
           brukernavn VARCHAR(50) NOT NULL,
           passord VARCHAR(50) NOT NULL
);
CREATE TABLE Hendelse (
           avtaleID INT PRIMARY KEY NOT NULL,
   starttid TIME NOT NULL,
   sluttid TIME NOT NULL,
           dato DATE NOT NULL,
   navn VARCHAR(50) NOT NULL,
   beskrivelse VARCHAR(300),
   lederID INT,
   FOREIGN KEY (lederID) REFERENCES Person(ansattnr)
);
CREATE TABLE Deltakere (
           ansattnr INT,
           avtaleID INT,
           FOREIGN KEY (ansattnr) REFERENCES Person(ansattnr),
           FOREIGN KEY (avtaleID) REFERENCES Hendelse(avtaleID)
);
CREATE TABLE Avtale (
           avtaleID INT PRIMARY KEY NOT NULL,
   starttid TIME NOT NULL,
   sluttid TIME NOT NULL,
           dato DATE NOT NULL,
   navn VARCHAR(50) NOT NULL,
   beskrivelse VARCHAR(300),
   lederID INT,
   FOREIGN KEY(lederID) REFERENCES Person(ansattnr)
);
CREATE TABLE Notis (
   notisID INT PRIMARY KEY NOT NULL,            
   innhold VARCHAR(50) NOT NULL,
   personID INT,
   FOREIGN KEY(personID) REFERENCES Person(ansattnr)
);
CREATE TABLE Rom (
           romID INT PRIMARY KEY NOT NULL,
   navn VARCHAR(50) NOT NULL
);
CREATE TABLE ReserverteRom (
           romID INT,
           avtaleID int,
           FOREIGN KEY(romID) REFERENCES Rom(romID),
           FOREIGN KEY(avtaleID) REFERENCES Avtale(avtaleID)
);