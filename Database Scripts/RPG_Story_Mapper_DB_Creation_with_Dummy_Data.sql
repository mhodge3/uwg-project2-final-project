CREATE DATABASE  IF NOT EXISTS `rpg_story_mapper_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rpg_story_mapper_db`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: rpg_story_mapper_db
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `demo.admins`
--

DROP TABLE IF EXISTS `demo.admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo.admins` (
  `demo.admin_id` int unsigned NOT NULL AUTO_INCREMENT,
  `demo.player_id` int NOT NULL,
  PRIMARY KEY (`demo.admin_id`),
  UNIQUE KEY `admin_id_UNIQUE` (`demo.admin_id`),
  KEY `demo.fk_admin_player_id_idx` (`demo.player_id`),
  CONSTRAINT `demo.fk_admin_player_id` FOREIGN KEY (`demo.player_id`) REFERENCES `demo.players` (`demo.player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo.admins`
--

LOCK TABLES `demo.admins` WRITE;
/*!40000 ALTER TABLE `demo.admins` DISABLE KEYS */;
INSERT INTO `demo.admins` VALUES (1,1);
/*!40000 ALTER TABLE `demo.admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo.characters_npc`
--

DROP TABLE IF EXISTS `demo.characters_npc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo.characters_npc` (
  `demo.character_npc_id` int NOT NULL AUTO_INCREMENT,
  `demo.character_npc_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `demo.character_npc_description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `demo.character_npc_type` int NOT NULL,
  `demo.character_npc_faction` int NOT NULL,
  `demo.character_npc_pos_x` decimal(10,2) NOT NULL,
  `demo.character_npc_pos_y` decimal(10,2) NOT NULL,
  `demo.character_npc_pos_z` decimal(10,2) NOT NULL,
  PRIMARY KEY (`demo.character_npc_id`),
  UNIQUE KEY `demo.characters_npc_id_UNIQUE` (`demo.character_npc_id`),
  UNIQUE KEY `demo.characters_npc_name_UNIQUE` (`demo.character_npc_name`),
  UNIQUE KEY `demo.characters_npc_description_UNIQUE` (`demo.character_npc_description`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo.characters_npc`
--

LOCK TABLES `demo.characters_npc` WRITE;
/*!40000 ALTER TABLE `demo.characters_npc` DISABLE KEYS */;
INSERT INTO `demo.characters_npc` VALUES (1,'Sum Guy','Testing dummy.',0,0,0.00,0.00,0.00),(2,'Sum Gal','Testing dummy 2.',0,0,0.00,0.00,0.00);
/*!40000 ALTER TABLE `demo.characters_npc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo.items`
--

DROP TABLE IF EXISTS `demo.items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo.items` (
  `demo.item_id` int NOT NULL AUTO_INCREMENT,
  `demo.item_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Item Name',
  `demo.item_description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Item Description',
  `demo.item_type` int NOT NULL DEFAULT '0',
  `demo.is_quest_item` tinyint NOT NULL DEFAULT '0',
  `demo.is_implicit_item` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`demo.item_id`),
  UNIQUE KEY `item_id_UNIQUE` (`demo.item_id`),
  UNIQUE KEY `demo.item_name_UNIQUE` (`demo.item_name`),
  UNIQUE KEY `demo.item_description_UNIQUE` (`demo.item_description`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo.items`
--

LOCK TABLES `demo.items` WRITE;
/*!40000 ALTER TABLE `demo.items` DISABLE KEYS */;
INSERT INTO `demo.items` VALUES (1,'Dagger of Suck','You get what you get and you don\'t throw a fit.',0,0,0),(2,'Pointy Stick of Okayness','A slightly better dagger.',0,0,0);
/*!40000 ALTER TABLE `demo.items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo.players`
--

DROP TABLE IF EXISTS `demo.players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo.players` (
  `demo.player_id` int NOT NULL AUTO_INCREMENT,
  `demo.player_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `demo.player_password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `demo.player_email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `demo.player_country_code` char(4) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'USA',
  PRIMARY KEY (`demo.player_id`),
  UNIQUE KEY `demo.players_id_UNIQUE` (`demo.player_id`),
  UNIQUE KEY `demo.players_name_UNIQUE` (`demo.player_name`),
  UNIQUE KEY `demo.player_email_UNIQUE` (`demo.player_email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo.players`
--

LOCK TABLES `demo.players` WRITE;
/*!40000 ALTER TABLE `demo.players` DISABLE KEYS */;
INSERT INTO `demo.players` VALUES (1,'admin','test1234','admin@demo.com','USA'),(2,'player','test1234','player@demo.com','USA');
/*!40000 ALTER TABLE `demo.players` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-10 14:11:43
