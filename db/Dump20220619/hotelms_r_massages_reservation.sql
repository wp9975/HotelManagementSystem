-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelms
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `r_massages_reservation`
--

DROP TABLE IF EXISTS `r_massages_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `r_massages_reservation` (
  `id_massages_reservation` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `start_hour` time NOT NULL,
  `end_hour` time DEFAULT NULL,
  `price` float DEFAULT NULL,
  `id_worker` int DEFAULT NULL,
  `id_massage` int NOT NULL,
  `id_guest` int NOT NULL,
  PRIMARY KEY (`id_massages_reservation`),
  KEY `id_worker` (`id_worker`),
  KEY `id_massage` (`id_massage`),
  KEY `id_guest` (`id_guest`),
  CONSTRAINT `r_massages_reservation_ibfk_1` FOREIGN KEY (`id_worker`) REFERENCES `workers` (`id_worker`),
  CONSTRAINT `r_massages_reservation_ibfk_2` FOREIGN KEY (`id_massage`) REFERENCES `r_massages` (`id_masage`),
  CONSTRAINT `r_massages_reservation_ibfk_3` FOREIGN KEY (`id_guest`) REFERENCES `guest` (`id_guest`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_massages_reservation`
--

LOCK TABLES `r_massages_reservation` WRITE;
/*!40000 ALTER TABLE `r_massages_reservation` DISABLE KEYS */;
INSERT INTO `r_massages_reservation` VALUES (1,'2013-06-20','12:00:00','13:00:00',NULL,NULL,11,1),(2,'2022-06-13','12:00:00','13:00:00',NULL,NULL,11,1);
/*!40000 ALTER TABLE `r_massages_reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-19 21:48:28
