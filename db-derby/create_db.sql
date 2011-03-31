CREATE TABLE Person (
        ansattId INT PRIMARY KEY NOT NULL,
        navn VARCHAR(50) NOT NULL,
        brukernavn VARCHAR(50) NOT NULL,
        passord VARCHAR(50) NOT NULL
);
CREATE TABLE Avtale (
        avtaleId INT PRIMARY KEY NOT NULL AUTO INCREMENT,
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
        avtaleId INT,
        status VARCHAR(15) NOT NULL DEFAULT 'IKKE_MOTTATT',
        FOREIGN KEY (ansattId) REFERENCES Person(ansattId),
        FOREIGN KEY (avtaleId) REFERENCES Mote(avtaleId)
);
CREATE TABLE Mote (
        avtaleId INT PRIMARY KEY NOT NULL AUTO INCREMENT,
	starttid TIME NOT NULL,
	sluttid TIME NOT NULL,
        dato DATE NOT NULL,
	navn VARCHAR(50) NOT NULL,
	beskrivelse VARCHAR(300),
	lederId INT,
	FOREIGN KEY(lederId) REFERENCES Person(ansattId)
);

CREATE TABLE Rom (
        romId INT PRIMARY KEY NOT NULL AUTO INCREMENT,
	navn VARCHAR(50) NOT NULL
);
CREATE TABLE ReserverteRom (
        romId INT PRIMARY KEY,
        avtaleId INT PRIMARY KEY,
        FOREIGN KEY(romId) REFERENCES Rom(romId),
        FOREIGN KEY(avtaleId) REFERENCES Mote(avtaleId)
);
