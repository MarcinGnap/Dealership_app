CREATE DATABASE  IF NOT EXISTS `klapexdealer1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `klapexdealer1`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 25.60.138.167    Database: klapexdealer1
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `available_cars`
--

DROP TABLE IF EXISTS `available_cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `available_cars` (
  `car_id` int NOT NULL,
  `price` int NOT NULL,
  `production_year` int NOT NULL,
  PRIMARY KEY (`car_id`),
  UNIQUE KEY `car_id_UNIQUE` (`car_id`),
  CONSTRAINT `car_id` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `available_cars`
--

LOCK TABLES `available_cars` WRITE;
/*!40000 ALTER TABLE `available_cars` DISABLE KEYS */;
INSERT INTO `available_cars` VALUES (1,10,1890),(3,25600,2000),(5,168900,2015),(6,1,1280);
/*!40000 ALTER TABLE `available_cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `car_id` int NOT NULL AUTO_INCREMENT,
  `drivetrain` varchar(20) NOT NULL,
  `engine_id` int NOT NULL,
  `gearbox_id` int NOT NULL,
  `additional_color_id` int NOT NULL,
  `interior_color_id` int NOT NULL,
  `main_color_id` int NOT NULL,
  `model_id` int NOT NULL,
  `wheel_id` int NOT NULL,
  PRIMARY KEY (`car_id`),
  UNIQUE KEY `car_id_UNIQUE` (`car_id`),
  KEY `engine_id_idx` (`engine_id`),
  KEY `gearbox_id_idx` (`gearbox_id`),
  KEY `additional_color_id_idx` (`additional_color_id`),
  KEY `iterior_color_id_idx` (`interior_color_id`),
  KEY `main_color_id_idx` (`main_color_id`),
  KEY `model_id_idx` (`model_id`),
  KEY `wheel_id_idx` (`wheel_id`),
  CONSTRAINT `additional_color_id` FOREIGN KEY (`additional_color_id`) REFERENCES `colors` (`color_id`),
  CONSTRAINT `engine_id` FOREIGN KEY (`engine_id`) REFERENCES `engines` (`engine_id`),
  CONSTRAINT `gearbox_id` FOREIGN KEY (`gearbox_id`) REFERENCES `gearboxes` (`gearbox_id`),
  CONSTRAINT `iterior_color_id` FOREIGN KEY (`interior_color_id`) REFERENCES `colors` (`color_id`),
  CONSTRAINT `main_color_id` FOREIGN KEY (`main_color_id`) REFERENCES `colors` (`color_id`),
  CONSTRAINT `model_id` FOREIGN KEY (`model_id`) REFERENCES `models` (`model_id`),
  CONSTRAINT `wheel_id` FOREIGN KEY (`wheel_id`) REFERENCES `wheels` (`wheel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (1,'AWD',1,1,1,1,1,1,1),(2,'1',1,1,1,1,1,1,1),(3,'1',1,1,1,1,1,1,1),(4,'1',1,1,1,1,1,1,1),(5,'4WD',2,2,13,13,3,2,1),(6,'4WD',2,1,7,7,4,2,1),(7,'AWD',2,2,8,8,2,2,1),(8,'4WD',1,1,8,8,3,2,1),(9,'AWD',1,1,8,8,2,1,1),(10,'4WD',2,1,7,7,3,2,1),(11,'4WD',2,2,8,8,3,3,1),(12,'4WD',3,1,8,8,3,4,1);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `orders_AFTER_DELETE` AFTER DELETE ON `cars` FOR EACH ROW BEGIN
DELETE FROM orders
WHERE orders.car_id = cars.car_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `available_cars_AFTER_DELETE` AFTER DELETE ON `cars` FOR EACH ROW BEGIN
DELETE FROM available_cars
WHERE available_cars.car_id = cars.car_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `client_id_UNIQUE` (`client_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`),
  KEY `person_id_idx` (`person_id`),
  CONSTRAINT `person_id` FOREIGN KEY (`person_id`) REFERENCES `persons` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,6),(2,8),(3,13),(4,14);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clients_AFTER_DELETE` AFTER DELETE ON `clients` FOR EACH ROW BEGIN
UPDATE orders 
SET orders.client_id = ''
WHERE orders.client_id = clients.client_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colors` (
  `color_id` int NOT NULL AUTO_INCREMENT,
  `color_name` varchar(30) NOT NULL,
  `color_type` varchar(30) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`color_id`),
  UNIQUE KEY `color_id_UNIQUE` (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES (1,'dupa','interior',0),(2,'Red','PRIMARY',0),(3,'Red','PRIMARY',2000),(4,'Green','PRIMARY',2000),(5,'Blue','PRIMARY',2000),(6,'Black','SECONDARY',2000),(7,'Black','INTERIOR',4000),(8,'Piano Black','INTERIOR',8000),(9,'Orange','PRIMARY',2000),(10,'Gray','PRIMARY',2000),(11,'Yellow','PRIMARY',2000),(12,'Blue','SECONDARY',2000),(13,'Blue','INTERIOR',2000),(14,'Blue','PRIMARY',24324),(15,'Blue','PRIMARY',24324),(16,'Blue','PRIMARY',24324),(17,'Blue','PRIMARY',24324),(18,'Blue','PRIMARY',24324),(19,'Green','INTERIOR',1000);
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `colors_AFTER_DELETE` AFTER DELETE ON `colors` FOR EACH ROW BEGIN
UPDATE cars 
SET cars.aditional_color_id = ''
WHERE cars.aditional_color_id = colors.color_id;
UPDATE cars
SET cars.interior_color_id = ''
WHERE cars.interior_colors_id = colors.color_id;
UPDATE cars
SET cars.main_color_id = ''
WHERE cars.main_color_id = colors.color_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `engines`
--

DROP TABLE IF EXISTS `engines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `engines` (
  `engine_id` int NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `engine_code` varchar(10) NOT NULL,
  `fuel` varchar(30) NOT NULL,
  `horse_power` int NOT NULL,
  `power` int NOT NULL,
  `torque` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`engine_id`),
  UNIQUE KEY `engine_id_UNIQUE` (`engine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `engines`
--

LOCK TABLES `engines` WRITE;
/*!40000 ALTER TABLE `engines` DISABLE KEYS */;
INSERT INTO `engines` VALUES (1,2137,'RB43','PETROL',220,110,300,0),(2,2137,'RB43','PETROL',220,110,300,40000),(3,1650,'FR16','DIESEL',109,81,200,4000);
/*!40000 ALTER TABLE `engines` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `engines_AFTER_DELETE` AFTER DELETE ON `engines` FOR EACH ROW BEGIN
UPDATE cars 
SET cars.engine_id = ''
WHERE cars.engine_id = engines.engine_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `gearboxes`
--

DROP TABLE IF EXISTS `gearboxes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gearboxes` (
  `gearbox_id` int NOT NULL AUTO_INCREMENT,
  `gearbox_code` varchar(5) NOT NULL,
  `gearbox_type` varchar(30) NOT NULL,
  `gears_number` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`gearbox_id`),
  UNIQUE KEY `gearbox_id_UNIQUE` (`gearbox_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gearboxes`
--

LOCK TABLES `gearboxes` WRITE;
/*!40000 ALTER TABLE `gearboxes` DISABLE KEYS */;
INSERT INTO `gearboxes` VALUES (1,'HU1','AUTOMATIC',8,0),(2,'HU1','AUTOMATIC',12,28000),(3,'DU8A','EMANUEL',10,2000);
/*!40000 ALTER TABLE `gearboxes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `gearboxes_AFTER_DELETE` AFTER DELETE ON `gearboxes` FOR EACH ROW BEGIN
UPDATE cars 
SET cars.gearbox_id = ''
WHERE cars.gearbox_id = gearboxes.gearbox_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models` (
  `model_id` int NOT NULL AUTO_INCREMENT,
  `body_type` varchar(30) NOT NULL,
  `brand_name` varchar(30) NOT NULL,
  `model_name` varchar(30) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`model_id`),
  UNIQUE KEY `car_id_UNIQUE` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` VALUES (1,'COMBI','CITROEN','C5',0),(2,'COMBI','CITROEN','C5',100000),(3,'SEDAN','VOLVO','S40',17000),(4,'SEDAN','HONDA','ACCORD',19000);
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `models_AFTER_DELETE` AFTER DELETE ON `models` FOR EACH ROW BEGIN
UPDATE cars 
SET cars.model_id = ''
WHERE cars.model_id = models.model_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `client_id` int NOT NULL,
  `estimated_delivery_date` date DEFAULT NULL,
  `order_car_id` int NOT NULL,
  `order_custodian_id` int DEFAULT NULL,
  `order_date` date NOT NULL,
  `order_status` varchar(30) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `car_id_UNIQUE` (`order_id`),
  KEY `order_car_id_idx` (`order_car_id`),
  KEY `client_id_idx` (`client_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `persons` (`person_id`),
  CONSTRAINT `order_car_id` FOREIGN KEY (`order_car_id`) REFERENCES `cars` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'2023-11-11',8,1,'2000-11-11','CAR_IN_PRODUCTION',10),(2,8,'2023-11-11',9,1,'2023-01-21','ORDER_CANCELED',10),(3,8,'2023-11-11',10,1,'2023-01-21','NEW',10),(4,13,NULL,11,NULL,'2023-01-22','WARRANTY_POSITIVE',10),(5,13,NULL,12,NULL,'2023-01-22','NEW',10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `person_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(30) NOT NULL,
  `birth_date` date NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `pesel` varchar(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  `person_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`),
  UNIQUE KEY `pesel_UNIQUE` (`pesel`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,'','1990-12-12','Marcin','gnap','21374206969','dupa123',NULL),(3,'Lipinki łużyckie łączna 43','1990-12-12','Marcin','gnap','21374206968','dupa123',NULL),(4,'Lipinki łużyckie łączna 43','2015-12-17','Marcin','gnap','21374206967','dupa123',NULL),(6,'wroc','2015-01-01','Janek','gnap','21374206966','dupa123','client'),(7,'Lipinki łużycke łączna 43','2000-11-03','Marcin','Ganp','21374202313','dupa','CLIENT'),(8,'Lipinki łużycke łączna 43','2000-11-03','Marcin','Ganp','21374202413','dupa','CLIENT'),(9,'Lipinki łużycke łączna 43','2000-11-03','Marcin','Ganp','21374202113','dupa','WORKER'),(11,'Lipinki łużycke łączna 43','2000-11-03','Marcin','Ganp','21374202112','dupa','WORKER'),(12,'Lipinki łużycke łączna 43','2000-11-03','Marcin','Ganp','21374202111','dupa','WORKER'),(13,'asdf asdfasdf 12 asdf','3333-11-11','asdf','asdf','23','dupa','CLIENT'),(14,'asdf asdf asdf sdaf','3333-11-11','asdf','asdf','11111111111','asdf','CLIENT'),(16,'asdfas asdf asdf 2134','2000-11-11','Dim','AG','22222222222','dupa','WORKER'),(17,'sa asd asdf 33','3333-11-11','sadf','asdf','33333333333','dupa','WORKER');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `persons_AFTER_INSERT` AFTER INSERT ON `persons` FOR EACH ROW BEGIN
  IF (NEW.person_type = 'CLIENT') THEN
        Insert into clients values(null,NEW.person_id);
  END IF;
  IF (NEW.person_type = 'WORKER') THEN
		Insert into workers values(null,NEW.person_id,"CUSTODIAN");
  END IF;  
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `personsw_AFTER_DELETE` AFTER DELETE ON `persons` FOR EACH ROW BEGIN
DELETE FROM workers 
WHERE workers.person_id = persons.person_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `personsc_AFTER_DELETE` AFTER DELETE ON `persons` FOR EACH ROW BEGIN
DELETE FROM clients 
WHERE clients.person_id = persons.person_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `wheels`
--

DROP TABLE IF EXISTS `wheels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wheels` (
  `wheel_id` int NOT NULL AUTO_INCREMENT,
  `color_id` int NOT NULL,
  `diameter` int NOT NULL,
  `ET` int NOT NULL,
  `producer` varchar(30) NOT NULL,
  `weight` float NOT NULL,
  `width` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`wheel_id`),
  UNIQUE KEY `wheel_id_UNIQUE` (`wheel_id`),
  KEY `color_id_idx` (`color_id`),
  CONSTRAINT `color_id` FOREIGN KEY (`color_id`) REFERENCES `colors` (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wheels`
--

LOCK TABLES `wheels` WRITE;
/*!40000 ALTER TABLE `wheels` DISABLE KEYS */;
INSERT INTO `wheels` VALUES (1,1,20,40,'BBS',20,4,4000),(3,10,17,42,'BBS',12,10,40000);
/*!40000 ALTER TABLE `wheels` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `wheels_AFTER_DELETE` AFTER DELETE ON `wheels` FOR EACH ROW BEGIN
UPDATE cars 
SET cars.wheel_id = ''
WHERE cars.wheel_id = wheels.wheel_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `workers`
--

DROP TABLE IF EXISTS `workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workers` (
  `worker_id` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  `job_position` varchar(30) NOT NULL,
  PRIMARY KEY (`worker_id`),
  UNIQUE KEY `worker_id_UNIQUE` (`worker_id`),
  KEY `person_id_idx` (`person_id`),
  CONSTRAINT `wperson_id` FOREIGN KEY (`person_id`) REFERENCES `persons` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workers`
--

LOCK TABLES `workers` WRITE;
/*!40000 ALTER TABLE `workers` DISABLE KEYS */;
INSERT INTO `workers` VALUES (1,12,'CUSTODIAN'),(2,16,'CUSTODIAN'),(3,17,'MENAGER');
/*!40000 ALTER TABLE `workers` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `workers_AFTER_DELETE` AFTER DELETE ON `workers` FOR EACH ROW BEGIN
UPDATE orders 
SET orders.order_custodian_id = ''
WHERE orders.order_custodian_id = clients.worker_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `colors_in_wheels_AFTER_DELETE` AFTER DELETE ON `colors` FOR EACH ROW BEGIN
UPDATE wheels 
SET wheels.color_id = ''
WHERE wheels.color_id = colors.color_id;
END */;;
DELIMITER ;

--
-- Dumping events for database 'klapexdealer1'
--

--
-- Dumping routines for database 'klapexdealer1'
--
/*!50003 DROP PROCEDURE IF EXISTS `SelectCLientOrder` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectCLientOrder`(
clientid INT(11)
)
BEGIN
	SELECT *  FROM klapexdealer1.orders
     WHERE klapexdealer1.order.client_id = clientid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SelectEasyPlants` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectEasyPlants`(
jobposition VARCHAR(30)
)
BEGIN
	SELECT * FROM klapexdealer1.workers
    WHERE klapexdealer1.workers.job_position = jobposition;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-23 15:25:52
