-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.4.17-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database academy
CREATE DATABASE IF NOT EXISTS `academy` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `academy`;

-- Dump della struttura di tabella academy.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `siglaCategoria` varchar(5) NOT NULL,
  `descrizioneCategoria` varchar(30) NOT NULL,
  PRIMARY KEY (`siglaCategoria`),
  UNIQUE KEY `descrizioneCategoria` (`descrizioneCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dump dei dati della tabella academy.categoria: ~1 rows (circa)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`siglaCategoria`, `descrizioneCategoria`) VALUES
	('INF01', 'Informatica'),
	('WEB33', 'Web Design');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Dump della struttura di tabella academy.corso
CREATE TABLE IF NOT EXISTS `corso` (
  `idCorso` int(11) NOT NULL AUTO_INCREMENT,
  `titolo` varchar(100) NOT NULL,
  `programma` text NOT NULL,
  `crediti` tinyint(2) NOT NULL DEFAULT 0,
  `descrizione` text NOT NULL,
  `idOperatore` int(11) NOT NULL,
  `siglaCategoria` varchar(5) NOT NULL DEFAULT '0',
  `idCorsoPropedeutico` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCorso`),
  UNIQUE KEY `titolo` (`titolo`),
  KEY `FK_corso_categoria` (`siglaCategoria`),
  KEY `FK_corso_operatore` (`idOperatore`),
  KEY `FK_corso_corso` (`idCorsoPropedeutico`),
  CONSTRAINT `FK_corso_categoria` FOREIGN KEY (`siglaCategoria`) REFERENCES `categoria` (`siglaCategoria`),
  CONSTRAINT `FK_corso_corso` FOREIGN KEY (`idCorsoPropedeutico`) REFERENCES `corso` (`idCorso`),
  CONSTRAINT `FK_corso_operatore` FOREIGN KEY (`idOperatore`) REFERENCES `operatore` (`idOperatore`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- Dump dei dati della tabella academy.corso: ~8 rows (circa)
/*!40000 ALTER TABLE `corso` DISABLE KEYS */;
INSERT INTO `corso` (`idCorso`, `titolo`, `programma`, `crediti`, `descrizione`, `idOperatore`, `siglaCategoria`, `idCorsoPropedeutico`) VALUES
	(2, 'Java Base', 'OOP, Algoritmi, Classi', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ut justo finibus, tristique neque eget, semper mauris. Quisque arcu nunc, vestibulum sagittis suscipit vitae, dapibus non urna. Nam at orci efficitur, tincidunt quam a, blandit augue. Aenean molestie aliquet est sit amet feugiat. Donec blandit augue sed augue tristique, et semper felis lacinia. Nulla neque dolor, lacinia eget vehicula a, commodo quis erat. Quisque ultricies dui vel dictum ultricies. Integer dictum blandit risus, eget rutrum justo eleifend et.', 1, 'INF01', NULL),
	(4, 'Corso Test', 'OOP, Algoritmi, Classi', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ut justo finibus, tristique neque eget, semper mauris. Quisque arcu nunc, vestibulum sagittis suscipit vitae, dapibus non urna. Nam at orci efficitur, tincidunt quam a, blandit augue. Aenean molestie aliquet est sit amet feugiat. Donec blandit augue sed augue tristique, et semper felis lacinia. Nulla neque dolor, lacinia eget vehicula a, commodo quis erat. Quisque ultricies dui vel dictum ultricies. Integer dictum blandit risus, eget rutrum justo eleifend et.', 4, 'INF01', NULL),
	(5, 'Java ae', 'OOP, Algoritmi, Classi', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ut justo finibus, tristique neque eget, semper mauris. Quisque arcu nunc, vestibulum sagittis suscipit vitae, dapibus non urna. Nam at orci efficitur, tincidunt quam a, blandit augue. Aenean molestie aliquet est sit amet feugiat. Donec blandit augue sed augue tristique, et semper felis lacinia. Nulla neque dolor, lacinia eget vehicula a, commodo quis erat. Quisque ultricies dui vel dictum ultricies. Integer dictum blandit risus, eget rutrum justo eleifend et.', 4, 'INF01', NULL),
	(6, 'Java a4e', 'OOP, Algoritmi, Classi', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ut justo finibus, tristique neque eget, semper mauris. Quisque arcu nunc, vestibulum sagittis suscipit vitae, dapibus non urna. Nam at orci efficitur, tincidunt quam a, blandit augue. Aenean molestie aliquet est sit amet feugiat. Donec blandit augue sed augue tristique, et semper felis lacinia. Nulla neque dolor, lacinia eget vehicula a, commodo quis erat. Quisque ultricies dui vel dictum ultricies. Integer dictum blandit risus, eget rutrum justo eleifend et.', 4, 'INF01', NULL),
	(14, 'Corso Web', 'HTML5, CSS3, JavaScript', 33, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ut justo finibus, tristique neque eget, semper mauris. Quisque arcu nunc, vestibulum sagittis suscipit vitae, dapibus non urna. Nam at orci efficitur, tincidunt quam a, blandit augue. Aenean molestie aliquet est sit amet feugiat. Donec blandit augue sed augue tristique, et semper felis lacinia. Nulla neque dolor, lacinia eget vehicula a, commodo quis erat. Quisque ultricies dui vel dictum ultricies. Integer dictum blandit risus, eget rutrum justo eleifend et.', 1, 'WEB33', NULL),
	(15, 'Html', 'Html, css, javascript', 10, 'corso HTML', 1, 'WEB33', NULL),
	(16, 'Spring Boot', 'Dependency Injection, Inversion of Control, etc', 5, 'Introduzione a Spring Boot', 1, 'INF01', NULL),
	(17, 'Prova corso', 'prova corso informatica', 10, 'prova', 1, 'INF01', NULL),
	(18, 'Giorgio Giovanni', 'fadfasdf', 0, 'asdf', 1, 'INF01', 4);
/*!40000 ALTER TABLE `corso` ENABLE KEYS */;

-- Dump della struttura di tabella academy.esame
CREATE TABLE IF NOT EXISTS `esame` (
  `idEsame` int(11) NOT NULL AUTO_INCREMENT,
  `dataOra` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `idOperatore` int(11) NOT NULL DEFAULT 0,
  `costo` double NOT NULL DEFAULT 0,
  `idCorso` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idEsame`),
  KEY `FK_esame_operatore` (`idOperatore`),
  KEY `FK_esame_corso` (`idCorso`),
  CONSTRAINT `FK_esame_corso` FOREIGN KEY (`idCorso`) REFERENCES `corso` (`idCorso`),
  CONSTRAINT `FK_esame_operatore` FOREIGN KEY (`idOperatore`) REFERENCES `operatore` (`idOperatore`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

-- Dump dei dati della tabella academy.esame: ~12 rows (circa)
/*!40000 ALTER TABLE `esame` DISABLE KEYS */;
INSERT INTO `esame` (`idEsame`, `dataOra`, `idOperatore`, `costo`, `idCorso`) VALUES
	(12, '2021-05-13 21:11:51', 1, 150, 4),
	(13, '2021-05-13 21:11:56', 4, 175, 4),
	(15, '2021-05-17 15:59:03', 4, 140, 6),
	(16, '2021-05-13 21:12:05', 4, 150, 4),
	(18, '2021-05-25 22:17:12', 1, 99, 2),
	(19, '2021-05-25 10:30:00', 1, 135, 15),
	(20, '2021-05-20 13:25:00', 1, 300, 2),
	(21, '2021-05-29 10:36:00', 1, 150, 2),
	(22, '2022-05-22 10:41:00', 1, 300, 2),
	(23, '2022-06-18 10:44:00', 1, 300, 4),
	(24, '2021-05-30 10:52:00', 1, 150, 15),
	(25, '2021-05-29 11:33:00', 1, 150, 14);
/*!40000 ALTER TABLE `esame` ENABLE KEYS */;

-- Dump della struttura di tabella academy.operatore
CREATE TABLE IF NOT EXISTS `operatore` (
  `idOperatore` int(11) NOT NULL AUTO_INCREMENT,
  `nominativo` varchar(50) NOT NULL DEFAULT '0',
  `idUtenteAuth` int(11) NOT NULL,
  PRIMARY KEY (`idOperatore`),
  UNIQUE KEY `idUtenteAuth` (`idUtenteAuth`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dump dei dati della tabella academy.operatore: ~2 rows (circa)
/*!40000 ALTER TABLE `operatore` DISABLE KEYS */;
INSERT INTO `operatore` (`idOperatore`, `nominativo`, `idUtenteAuth`) VALUES
	(1, 'Saverio', 7),
	(4, 'Nicholas', 12);
/*!40000 ALTER TABLE `operatore` ENABLE KEYS */;

-- Dump della struttura di tabella academy.prenotazione_esame
CREATE TABLE IF NOT EXISTS `prenotazione_esame` (
  `idPrenotazione` int(11) NOT NULL AUTO_INCREMENT,
  `dataPrenotazione` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `prezzoAcquisto` double NOT NULL DEFAULT 0,
  `prezzoRimborso` double DEFAULT 0,
  `stato` char(1) NOT NULL,
  `dataAnnullamento` timestamp NULL DEFAULT NULL,
  `idUtente` int(11) NOT NULL,
  `idEsame` int(11) NOT NULL,
  PRIMARY KEY (`idPrenotazione`),
  UNIQUE KEY `idUtente_idEsame` (`idUtente`,`idEsame`,`stato`) USING BTREE,
  KEY `FK_prenotazione_esame_esame` (`idEsame`),
  CONSTRAINT `FK_prenotazione_esame_esame` FOREIGN KEY (`idEsame`) REFERENCES `esame` (`idEsame`),
  CONSTRAINT `FK_prenotazione_esame_utente` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`idUtente`),
  CONSTRAINT `CC1` CHECK (`stato` = 'a' or `stato` = 'r' or `stato` = 'p' or `stato` = 's')
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

-- Dump dei dati della tabella academy.prenotazione_esame: ~11 rows (circa)
/*!40000 ALTER TABLE `prenotazione_esame` DISABLE KEYS */;
INSERT INTO `prenotazione_esame` (`idPrenotazione`, `dataPrenotazione`, `prezzoAcquisto`, `prezzoRimborso`, `stato`, `dataAnnullamento`, `idUtente`, `idEsame`) VALUES
	(3, '2021-05-14 13:54:53', 150, 150, 's', NULL, 1, 12),
	(4, '2021-05-22 12:30:58', 150, 0, 'p', NULL, 3, 13),
	(5, '2021-05-22 12:30:59', 150, 0, 's', NULL, 2, 12),
	(7, '2021-05-16 12:54:25', 150, 0, 'a', NULL, 3, 12),
	(8, '2021-05-16 13:13:56', 150, 30, 'r', '2021-05-16 13:14:05', 3, 12),
	(9, '2021-05-17 12:27:26', 99, 0, 'a', '2021-05-17 11:40:01', 1, 18),
	(18, '2021-05-17 12:44:46', 99, 39.6, 'r', '2021-05-17 12:44:37', 1, 18),
	(19, '2021-05-17 13:55:48', 140, 0, 'p', '2021-05-17 12:43:56', 1, 15),
	(20, '2021-05-18 11:31:18', 135, 54, 'r', '2021-05-18 11:31:18', 1, 21),
	(21, '2021-05-19 14:59:33', 122, NULL, 'p', NULL, 1, 19),
	(24, '2021-05-19 15:02:41', 132, NULL, 'p', NULL, 1, 25),
	(26, '2022-05-22 12:42:18', 1000, 0, 'p', '2021-05-22 12:32:56', 1, 23),
	(27, '2021-05-26 14:02:21', 150, NULL, 'p', NULL, 7, 21);
/*!40000 ALTER TABLE `prenotazione_esame` ENABLE KEYS */;

-- Dump della struttura di vista academy.report_corso
-- Creazione di una tabella temporanea per risolvere gli errori di dipendenza della vista
CREATE TABLE `report_corso` (
	`annoPrenotazione` INT(4) NULL,
	`titoloCorso` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`idCorso` INT(11) NOT NULL,
	`fatturato` DOUBLE NULL,
	`esamiPrenotati` BIGINT(21) NOT NULL
) ENGINE=MyISAM;

-- Dump della struttura di tabella academy.utente
CREATE TABLE IF NOT EXISTS `utente` (
  `idUtente` int(11) NOT NULL AUTO_INCREMENT,
  `nominativo` varchar(50) NOT NULL DEFAULT '',
  `idUtenteAuth` int(11) NOT NULL,
  PRIMARY KEY (`idUtente`),
  UNIQUE KEY `idUtenteAuth` (`idUtenteAuth`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dump dei dati della tabella academy.utente: ~3 rows (circa)
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` (`idUtente`, `nominativo`, `idUtenteAuth`) VALUES
	(1, 'Andrea', 1),
	(2, 'Valerio', 2),
	(3, 'Vladimiro', 6),
	(7, 'Andrea', 46);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;

-- Dump della struttura di trigger academy.checkMaxEsamiAnnuali
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `checkMaxEsamiAnnuali` BEFORE INSERT ON `esame` FOR EACH ROW BEGIN
	DECLARE numEsami INT DEFAULT 0;
	DECLARE cursore CURSOR FOR SELECT COUNT(idEsame) FROM esame WHERE EXTRACT(YEAR from dataOra) = EXTRACT(YEAR from NEW.dataOra) AND idCorso = NEW.idCorso;
	
	OPEN cursore; 
	FETCH cursore INTO numEsami;
	CLOSE cursore;
 
	IF (numEsami >= 3) THEN
	SIGNAL SQLSTATE '75001' SET MESSAGE_TEXT = 'Impossibile aggiungere l\'esame, è stato raggiunto il limite massimo di 3 esami per l\'anno inserito ';
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger academy.checkNumEsamiSuperatiPerCorso
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `checkNumEsamiSuperatiPerCorso` BEFORE INSERT ON `prenotazione_esame` FOR EACH ROW BEGIN
   DECLARE newIdCorso INT DEFAULT 0;
	DECLARE numEsameSuperatoPerCorso INT DEFAULT 0;	
		
	DECLARE cursoreIdCorso CURSOR FOR SELECT idCorso FROM esame WHERE esame.idEsame = NEW.idEsame;			

	DECLARE cursoreCountEsamiSuperati CURSOR FOR SELECT COUNT(idPrenotazione) FROM 
	(SELECT prenotazione_esame.*, esame.idCorso from prenotazione_esame INNER JOIN esame ON prenotazione_esame.idEsame = esame.idEsame) prenotazioni
	WHERE idCorso = newIdCorso AND idUtente = NEW.idUtente AND stato = 's';
	
	OPEN cursoreIdCorso; 
	FETCH cursoreIdCorso INTO newIdCorso;
	CLOSE cursoreIdCorso;	
	
	OPEN cursoreCountEsamiSuperati; 
	FETCH cursoreCountEsamiSuperati INTO numEsameSuperatoPerCorso;
	CLOSE cursoreCountEsamiSuperati;
 
	IF (numEsameSuperatoPerCorso > 0) THEN
	SIGNAL SQLSTATE '75000' SET MESSAGE_TEXT = 'Impossibile prenotare l\'esame, è già stato superato un esame per lo stesso corso';
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di vista academy.report_corso
-- Rimozione temporanea di tabella e creazione della struttura finale della vista
DROP TABLE IF EXISTS `report_corso`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `report_corso` AS SELECT YEAR(pe.dataPrenotazione) AS annoPrenotazione
, cs.titolo AS titoloCorso, cs.idCorso
, sum(pe.prezzoAcquisto) AS fatturato
, count(pe.idPrenotazione) AS esamiPrenotati
FROM prenotazione_esame AS pe INNER JOIN esame AS es ON pe.idEsame = es.idEsame
INNER JOIN corso cs ON es.idCorso=cs.idCorso
WHERE (stato= 'p' OR stato ='s')
GROUP BY annoPrenotazione, titoloCorso ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
