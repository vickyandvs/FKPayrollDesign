-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: FKpayroll
-- ------------------------------------------------------
-- Server version	8.0.20-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Commission`
--

DROP TABLE IF EXISTS `Commission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Commission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` date DEFAULT NULL,
  `place` varchar(300) DEFAULT NULL,
  `amount` double(100,6) DEFAULT NULL,
  `empID` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `empID` (`empID`),
  CONSTRAINT `Commission_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `Employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Commission`
--

LOCK TABLES `Commission` WRITE;
/*!40000 ALTER TABLE `Commission` DISABLE KEYS */;
INSERT INTO `Commission` VALUES (2,'2020-05-10','Testing Softwares',200000.000000,7);
/*!40000 ALTER TABLE `Commission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DailyWork`
--

DROP TABLE IF EXISTS `DailyWork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DailyWork` (
  `time` date NOT NULL,
  `hours` int DEFAULT NULL,
  `empID` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `empID` (`empID`),
  CONSTRAINT `DailyWork_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `Employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DailyWork`
--

LOCK TABLES `DailyWork` WRITE;
/*!40000 ALTER TABLE `DailyWork` DISABLE KEYS */;
INSERT INTO `DailyWork` VALUES ('2020-05-10',10,2,1),('2020-05-10',8,2,2),('2020-05-11',5,2,3),('2020-05-11',10,5,5),('2020-05-12',4,5,6),('2020-05-13',9,5,7);
/*!40000 ALTER TABLE `DailyWork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `modeOfSalary` int NOT NULL DEFAULT '1',
  `rate` double(100,6) DEFAULT '0.000000',
  `lastPaidDate` date DEFAULT NULL,
  `isUnionMember` tinyint(1) DEFAULT '0',
  `weeklyDue` double(100,6) DEFAULT '0.000000',
  `type` int NOT NULL DEFAULT '1',
  `salary` double(100,6) DEFAULT '0.000000',
  `id` int NOT NULL AUTO_INCREMENT,
  `lastComm` date DEFAULT NULL,
  `postalAdd` varchar(500) DEFAULT NULL,
  `accountNo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES ('Nidhi',NULL,1,20.000000,'2020-05-15',0,0.000000,1,0.000000,2,NULL,NULL,NULL),('vicky','sharma',1,20.000000,'2020-05-15',1,0.000000,1,0.000000,5,'2020-05-10','null','null'),('suman','lata',1,50.000000,'2020-05-15',0,0.000000,1,0.000000,6,'2020-05-10','null','null'),('Harshit','Mahajan',3,2.000000,'2020-05-10',0,0.000000,2,70000.000000,7,'2020-05-15','null','754300001000045656');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-11  9:12:33
