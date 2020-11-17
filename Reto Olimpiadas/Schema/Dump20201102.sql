-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: olimpiadas
-- ------------------------------------------------------
-- Server version	5.7.31-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Deporte`
--

DROP TABLE IF EXISTS `Deporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Deporte` (
  `id_deporte` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_deporte`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Deporte`
--

LOCK TABLES `Deporte` WRITE;
/*!40000 ALTER TABLE `Deporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `Deporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Deportista`
--

DROP TABLE IF EXISTS `Deportista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Deportista` (
  `id_deportista` int(11) NOT NULL,
  `nombre` varchar(150) COLLATE latin1_spanish_ci NOT NULL,
  `sexo` enum('M','F') COLLATE latin1_spanish_ci NOT NULL,
  `peso` int(11) DEFAULT NULL,
  `altura` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_deportista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Deportista`
--

LOCK TABLES `Deportista` WRITE;
/*!40000 ALTER TABLE `Deportista` DISABLE KEYS */;
/*!40000 ALTER TABLE `Deportista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo`
--

DROP TABLE IF EXISTS `Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipo` (
  `id_equipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `iniciales` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=1176 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo`
--

LOCK TABLES `Equipo` WRITE;
/*!40000 ALTER TABLE `Equipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Evento`
--

DROP TABLE IF EXISTS `Evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Evento` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) COLLATE latin1_spanish_ci NOT NULL,
  `id_olimpiada` int(11) NOT NULL,
  `id_deporte` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `FK_Evento_Olimpiada` (`id_olimpiada`),
  KEY `FK_Evento_Deporte` (`id_deporte`),
  CONSTRAINT `FK_Evento_Olimpiada` FOREIGN KEY (`id_olimpiada`) REFERENCES `Olimpiada` (`id_olimpiada`),
  CONSTRAINT `FK_Eventoolimpiadas_Deporte` FOREIGN KEY (`id_deporte`) REFERENCES `Deporte` (`id_deporte`)
) ENGINE=InnoDB AUTO_INCREMENT=6193 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Evento`
--

LOCK TABLES `Evento` WRITE;
/*!40000 ALTER TABLE `Evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Olimpiada`
--

DROP TABLE IF EXISTS `Olimpiada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Olimpiada` (
  `id_olimpiada` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(11) COLLATE latin1_spanish_ci NOT NULL,
  `anio` smallint(6) NOT NULL,
  `temporada` enum('Summer','Winter') COLLATE latin1_spanish_ci NOT NULL,
  `ciudad` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_olimpiada`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Olimpiada`
--

LOCK TABLES `Olimpiada` WRITE;
/*!40000 ALTER TABLE `Olimpiada` DISABLE KEYS */;
/*!40000 ALTER TABLE `Olimpiada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Participacion`
--

DROP TABLE IF EXISTS `Participacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Participacion` (
  `id_deportista` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `edad` tinyint(4) DEFAULT NULL,
  `medalla` varchar(6) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_deportista`,`id_evento`),
  KEY `FK_Participacion_Evento` (`id_evento`),
  KEY `FK_Participacion_Equipo` (`id_equipo`),
  CONSTRAINT `FK_Participacion_Deportista` FOREIGN KEY (`id_deportista`) REFERENCES `Deportista` (`id_deportista`),
  CONSTRAINT `FK_Participacion_Equipo` FOREIGN KEY (`id_equipo`) REFERENCES `Equipo` (`id_equipo`),
  CONSTRAINT `FK_Participacion_Evento` FOREIGN KEY (`id_evento`) REFERENCES `Evento` (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Participacion`
--

LOCK TABLES `Participacion` WRITE;
/*!40000 ALTER TABLE `Participacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Participacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-02 10:04:55
