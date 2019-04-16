-- Wyczyszczenie bazy

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS users;

-- Tabela z użytkownikami
CREATE TABLE `users` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `firstName` varchar(255) NOT NULL,
                       `lastName` varchar(255) NOT NULL,
                       `login` varchar(255) NOT NULL,
                       `password` varchar(255) NOT NULL,
                       PRIMARY KEY (`id`),
                       UNIQUE KEY `UK_ow0gan20590jrb00upg3va2fn` (`id`)
);


CREATE TABLE `customers` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `firstName` varchar(255) NOT NULL,
                           `lastName` varchar(255) NOT NULL,
                           `telephoneNumber` varchar(255) NOT NULL,
                           `visitDate` date DEFAULT NULL,
                           `visitTime` time DEFAULT NULL,
                           `assignedHairdresser` varchar(255) DEFAULT NULL,
                           `additionalInfo` varchar(500) DEFAULT NULL,
                           `comments` varchar(500) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `UK_ow0gan20590jrb00upg3va2fn` (`id`)
);

-- Testowi fryzjerzy
INSERT INTO users (login, password, firstName, lastName) VALUES ('jnowak', 'jnowak', 'Jan', 'Nowak');
INSERT INTO users (login, password, firstName, lastName) VALUES ('jkowalki', 'jkowalki', 'Jan', 'Kowalski');
INSERT INTO users (login, password, firstName, lastName) VALUES ('sgomez', 'sgomez', 'Selena', 'Gomez');
INSERT INTO users (login, password, firstName, lastName) VALUES ('admin', 'admin', 'Ędward', 'Ącki');


-- testowi petenci

INSERT INTO customers (firstName, lastName, telephoneNumber, visitDate, visitTime, assignedHairdresser, additionalInfo, comments)
VALUES ('Cameron', 'Diaz', '700100100', '2019-01-01', '10:00:01', 'jkowalki', 'średniej długości włosy', 'Lubi ... wiecie co');
INSERT INTO customers (firstName, lastName, telephoneNumber, visitDate, visitTime, assignedHairdresser, additionalInfo, comments)
VALUES ('Rocky', 'Balboa', '111222333', '2019-01-01', '10:30:01', 'jkowalki', 'Na łyso', 'bywa agresywny');
INSERT INTO customers (firstName, lastName, telephoneNumber, visitDate, visitTime, assignedHairdresser, additionalInfo, comments)
VALUES ('Jack', 'Sparrow', '378378378', '2019-01-01', '11:00:01', 'jnowak', 'Długie kołtuny', 'rzadko się myje');
INSERT INTO customers (firstName, lastName, telephoneNumber, visitDate, visitTime, assignedHairdresser, additionalInfo, comments)
VALUES ('Pamela', 'Anderson', '530530530', '2019-01-02', '12:00:01', 'sgomez', 'platyna', 'cycki zasłaniają świat');
INSERT INTO customers (firstName, lastName, telephoneNumber, visitDate, visitTime, assignedHairdresser, additionalInfo, comments)
VALUES ('Anna', 'Grodzka', '666666666', '2019-01-02', '13:00:01', 'sgomez', 'Lubi grzywkę', 'babochłop');

INSERT INTO customers (firstName, lastName, telephoneNumber, visitDate, visitTime, assignedHairdresser, additionalInfo, comments)
VALUES ('Donald', 'Trump', '987987987', '2019-01-03', '13:30:01', 'jnowak', 'Zawsze tupecik', 'Daje napiwki');
INSERT INTO customers (firstName, lastName, telephoneNumber)
VALUES ('Łukasz', 'Józefowicz', '654645654');
INSERT INTO customers (firstName, lastName, telephoneNumber)
VALUES ('Przemysław', 'Karcz', '987987987');
INSERT INTO customers (firstName, lastName, telephoneNumber)
VALUES ('Rafał', 'Kowalski', '234234234');
INSERT INTO customers (firstName, lastName, telephoneNumber)
VALUES ('Marcin', 'Podsiadły', '765765765');