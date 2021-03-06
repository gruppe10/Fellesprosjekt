CREATE TABLE Person(
	ansattId INT PRIMARY KEY NOT NULL,
    navn VARCHAR(50) NOT NULL,
    brukernavn VARCHAR(50) NOT NULL,
    passord VARCHAR(50) NOT NULL
);

CREATE TABLE Hendelse(
    hendelseId INT PRIMARY KEY NOT NULL ,
	starttid TIME NOT NULL,
	sluttid TIME NOT NULL,
    dato DATE NOT NULL,
	navn VARCHAR(50) NOT NULL,
	beskrivelse VARCHAR(300),
	lederId INT,
	FOREIGN KEY (lederId) REFERENCES Person(ansattId)
);

CREATE TABLE Deltakere (
    ansattId INT,
    hendelseId INT,
    status VARCHAR(15) NOT NULL DEFAULT 'IKKE_MOTTATT',
    PRIMARY KEY (ansattId, hendelseId),
    FOREIGN KEY (ansattId) REFERENCES Person(ansattId),
    FOREIGN KEY (hendelseId) REFERENCES Hendelse(hendelseId) ON DELETE CASCADE
);

CREATE TABLE Rom (
    romId INT PRIMARY KEY NOT NULL ,
	navn VARCHAR(50) NOT NULL
);

CREATE TABLE ReserverteRom (
    romId INT,
    hendelseId INT,
    PRIMARY KEY (romId, hendelseId),
    FOREIGN KEY(romId) REFERENCES Rom(romId),
    FOREIGN KEY(hendelseId) REFERENCES Hendelse(hendelseId) ON DELETE CASCADE
);
