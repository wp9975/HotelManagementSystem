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
-- Table structure for table `r_massages`
--

DROP TABLE IF EXISTS `r_massages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `r_massages` (
  `id_masage` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(700) DEFAULT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id_masage`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_massages`
--

LOCK TABLES `r_massages` WRITE;
/*!40000 ALTER TABLE `r_massages` DISABLE KEYS */;
INSERT INTO `r_massages` VALUES (11,'Masaż relaksacyjny','Jego zadaniem jest wyciszenie umysłu i ukojenie zmysłów. Pod jego wpływem uspokaja się rytm serca, spada ciśnienie krwi.',129),(12,'Masaż klasyczny','Relaksuje i niweluje negatywne skutki stresu. Może także działać jak lekarstwo: zmniejsza napięcie mięśni, ma działanie przeciwbólowe. Dodatkowo poprawia ukrwienie i przyspiesza regenerację.',129),(13,'Masaż leczniczy','Wykonywane w przypadku schorzeń lub kontuzji aparatu ruchu.',135),(14,'Masaż sportowy','Skierowany do osób aktywnych. Może przyspieszyć regenerację organizmu po ciężkim wysiłku i przygotować ciało do kolejnego intensywnego okresu treningowego. Dodatkowo, rozluźnia mięśnie umożliwiając wykonywanie ćwiczeń w pełnym zakresie ruchu. Ma też działanie przeciwbólowe oraz jest jednym z elementów zapobiegania kontuzjom. Może także zmniejszać efekty przetrenowania, jak np. bezsenność, pobudzenie i wysoki poziom hormonów stresu we krwi.',140),(15,'Masaż lomi lomi','Poprawia krążenie oraz przebieg limfy, uelastycznia ciało, a w szczególności zastałe stawy, przyspiesza przemianę materii, a także proces spalania tkanki tłuszczowej. ',149),(16,'Masaż ajuwerdyjski','poprawia on koloryt i odżywienie skóry, przywraca nawilżenie i blask włosom, wzmacnia ich cebulki. W olejku ajurwedyjskim znajdują się przeciwutleniacze, zapobiegające powstawaniu wolnych rodników. Skóra jest zdrowsza i wzmocniona.',139),(17,'Masaż tajski','Rodzaj głębokiego masażu, który łączy w sobie elementy uciskania i klasycznej sztuki. Masażystka wygina ciało osoby masowanej, do uciskania używa nie tylko dłoni, ale i łokci. Masaż ma działanie odprężające i ma za zadanie odblokować napięte mięśnie.',139),(18,'Masaż shiatsu','Masaż shiatsu poprawia samopoczucie, zmniejsza napięcie związane z nagromadzeniem negatywnych emocji, poprawia sprawność intelektualną oraz koncentrację. Masaż wzmacnia również odporność, a także usprawnia przepływ limfy i reguluje krążenie krwi. Co więcej, masaż tego typu może nawet minimalizować objawy związane z astmą.',139),(19,'Masaż twarzi i dłoni','Delikatny masaż twarzy i dłoni.',129),(20,'Masaż bańką chińską','Masaż bańką chińską jest masażem relaksacyjno-leczniczym. Wykorzystuje się go w celu zmniejszenia napięcia mięśniowego, które niesie za sobą wiele dolegliwości bólowych.',159);
/*!40000 ALTER TABLE `r_massages` ENABLE KEYS */;
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
