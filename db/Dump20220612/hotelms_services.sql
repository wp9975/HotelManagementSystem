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
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `id_service` int NOT NULL,
  `name` varchar(70) NOT NULL,
  `seatsTable` int DEFAULT NULL,
  `description` text,
  `price_hourly` float NOT NULL,
  `id_department` int NOT NULL,
  PRIMARY KEY (`id_service`),
  KEY `id_department_idx` (`id_department`),
  CONSTRAINT `id_department` FOREIGN KEY (`id_department`) REFERENCES `departments` (`id_department`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Stolik 1/4',4,'Od okna',10,5),(2,'Stolik 2/4',4,'-',10,5),(3,'Stolik 3/4',4,'Od okna',10,5),(4,'Stolik 4/4',4,'-',10,5),(5,'Stolik 5/2',2,'-',10,5),(6,'Stolik 6/2',2,'-',10,5),(7,'Stolik 7/2',2,'-',10,5),(8,'Stolik 8/2',2,'-',10,5),(9,'Stolik 9/4',4,'W kształcie rombu',10,5),(10,'Stolik 10/4',4,'W kształcie rombu',10,5),(11,'Stolik 11/4',4,'W kształcie rombu',10,5),(12,'Stolik 12/4',4,'W kształcie rombu',10,5),(13,'Stolik 13/5',5,'Od okna',10,5),(14,'Stolik 14/5',5,'-',10,5),(15,'Stolik 15/8',8,'-',10,5),(16,'Masaż relaksacyjny',NULL,'Jego zadaniem jest wyciszenie umysłu i ukojenie zmysłów. Pod jego wpływem uspokaja się rytm serca, spada ciśnienie krwi.',129,6),(17,'Masaż klasyczny',NULL,'Relaksuje i niweluje negatywne skutki stresu. Może także działać jak lekarstwo: zmniejsza napięcie mięśni, ma działanie przeciwbólowe. Dodatkowo poprawia ukrwienie i przyspiesza regenerację.',129,6),(18,'Masaż leczniczy',NULL,'Wykonywane w przypadku schorzeń lub kontuzji aparatu ruchu.',135,6),(19,'Masaż sportowy',NULL,'Skierowany do osób aktywnych. Może przyspieszyć regenerację organizmu po ciężkim wysiłku i przygotować ciało do kolejnego intensywnego okresu treningowego. Dodatkowo, rozluźnia mięśnie umożliwiając wykonywanie ćwiczeń w pełnym zakresie ruchu. Ma też działanie przeciwbólowe oraz jest jednym z elementów zapobiegania kontuzjom. Może także zmniejszać efekty przetrenowania, jak np. bezsenność, pobudzenie i wysoki poziom hormonów stresu we krwi.',140,6),(20,'Masaż lomi lomi',NULL,'Poprawia krążenie oraz przebieg limfy, uelastycznia ciało, a w szczególności zastałe stawy, przyspiesza przemianę materii, a także proces spalania tkanki tłuszczowej. ',149,6),(21,'Masaż ajuwerdyjski',NULL,'poprawia on koloryt i odżywienie skóry, przywraca nawilżenie i blask włosom, wzmacnia ich cebulki. W olejku ajurwedyjskim znajdują się przeciwutleniacze, zapobiegające powstawaniu wolnych rodników. Skóra jest zdrowsza i wzmocniona.',139,6),(22,'Masaż tajski',NULL,'Rodzaj głębokiego masażu, który łączy w sobie elementy uciskania i klasycznej sztuki. Masażystka wygina ciało osoby masowanej, do uciskania używa nie tylko dłoni, ale i łokci. Masaż ma działanie odprężające i ma za zadanie odblokować napięte mięśnie.',139,6),(23,'Masaż shiatsu',NULL,'Masaż shiatsu poprawia samopoczucie, zmniejsza napięcie związane z nagromadzeniem negatywnych emocji, poprawia sprawność intelektualną oraz koncentrację. Masaż wzmacnia również odporność, a także usprawnia przepływ limfy i reguluje krążenie krwi. Co więcej, masaż tego typu może nawet minimalizować objawy związane z astmą.',139,6),(24,'Masaż twarzi i dłoni',NULL,'Delikatny masaż twarzy i dłoni.',129,6),(25,'Masaż bańką chińską',NULL,'Masaż bańką chińską jest masażem relaksacyjno-leczniczym. Wykorzystuje się go w celu zmniejszenia napięcia mięśniowego, które niesie za sobą wiele dolegliwości bólowych.',159,6);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12 20:22:08
