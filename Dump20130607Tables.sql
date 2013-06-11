CREATE DATABASE  IF NOT EXISTS `clean` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `clean`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: clean
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL,
  `authors` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `title` varchar(300) CHARACTER SET latin1 DEFAULT NULL,
  `journal` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `type` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `numrefs` int(11) DEFAULT NULL,
  `times_cited` int(11) DEFAULT NULL,
  `doi` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `volume` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `issue` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `BP` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `EP` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `abbr` varchar(32) CHARACTER SET latin1 DEFAULT NULL,
  `ut` varchar(32) CHARACTER SET latin1 DEFAULT NULL,
  `nsr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Index_1` (`journal`,`volume`,`issue`,`BP`,`id`),
  KEY `ut` (`ut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articles_adresses`
--

DROP TABLE IF EXISTS `articles_adresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles_adresses` (
  `id` int(11) NOT NULL,
  `d1` int(11) NOT NULL,
  `d2` int(11) NOT NULL,
  `adresse` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  KEY `Index_1` (`id`),
  KEY `id` (`id`,`d1`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articles_authors`
--

DROP TABLE IF EXISTS `articles_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles_authors` (
  `id` int(11) DEFAULT NULL,
  `d` int(11) NOT NULL,
  `author` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `newid` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`newid`),
  KEY `author_article_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2328540 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articles_countries`
--

DROP TABLE IF EXISTS `articles_countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles_countries` (
  `id` int(11) NOT NULL,
  `d1` int(11) NOT NULL,
  `country` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articles_institutions`
--

DROP TABLE IF EXISTS `articles_institutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles_institutions` (
  `id` int(11) NOT NULL,
  `d1` int(11) NOT NULL,
  `d2` int(11) NOT NULL,
  `institution` varchar(100) DEFAULT NULL,
  `newid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`newid`),
  KEY `id` (`id`,`institution`)
) ENGINE=MyISAM AUTO_INCREMENT=2894570 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articles_keywords`
--

DROP TABLE IF EXISTS `articles_keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles_keywords` (
  `id` int(11) NOT NULL,
  `type_keyw` varchar(2) CHARACTER SET latin1 DEFAULT NULL,
  `keyword` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  KEY `Index_1` (`id`),
  KEY `id` (`id`,`keyword`),
  KEY `id_2` (`id`,`keyword`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articles_refs`
--

DROP TABLE IF EXISTS `articles_refs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles_refs` (
  `id` int(11) NOT NULL,
  `first_author` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `year` int(11) DEFAULT '0',
  `journal` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `volume` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `page` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  KEY `Index_1` (`id`),
  KEY `first_author` (`first_author`,`year`,`journal`),
  KEY `first_author_2` (`first_author`,`year`,`journal`),
  KEY `first_author_3` (`first_author`,`year`,`journal`,`volume`,`page`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articles_subjects`
--

DROP TABLE IF EXISTS `articles_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles_subjects` (
  `id` int(11) NOT NULL,
  `subject` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `newid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`newid`),
  KEY `Index_1` (`id`,`subject`),
  KEY `id` (`id`,`subject`)
) ENGINE=MyISAM AUTO_INCREMENT=515515 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cleaninst`
--

DROP TABLE IF EXISTS `cleaninst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cleaninst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Paper` int(11) DEFAULT NULL,
  `NameOfInst` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cosinesim`
--

DROP TABLE IF EXISTS `cosinesim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cosinesim` (
  `name` varchar(255) DEFAULT NULL,
  `A1` double(10,3) DEFAULT NULL,
  `A2` double(10,3) DEFAULT NULL,
  `A3` double(10,3) DEFAULT NULL,
  `A4` double(10,3) DEFAULT NULL,
  `A5` double(10,3) DEFAULT NULL,
  `A6` double(10,3) DEFAULT NULL,
  `A7` double(10,3) DEFAULT NULL,
  `A8` double(10,3) DEFAULT NULL,
  `A9` double(10,3) DEFAULT NULL,
  `A10` double(10,3) DEFAULT NULL,
  `A11` double(10,3) DEFAULT NULL,
  `A12` double(10,3) DEFAULT NULL,
  `A13` double(10,3) DEFAULT NULL,
  `A14` double(10,3) DEFAULT NULL,
  `A15` double(10,3) DEFAULT NULL,
  `A16` double(10,3) DEFAULT NULL,
  `A17` double(10,3) DEFAULT NULL,
  `A18` double(10,3) DEFAULT NULL,
  `A19` double(10,3) DEFAULT NULL,
  `A20` double(10,3) DEFAULT NULL,
  `A21` double(10,3) DEFAULT NULL,
  `A22` double(10,3) DEFAULT NULL,
  `A23` double(10,3) DEFAULT NULL,
  `A24` double(10,3) DEFAULT NULL,
  `A25` double(10,3) DEFAULT NULL,
  `A26` double(10,3) DEFAULT NULL,
  `A27` double(10,3) DEFAULT NULL,
  `A28` double(10,3) DEFAULT NULL,
  `A29` double(10,3) DEFAULT NULL,
  `A30` double(10,3) DEFAULT NULL,
  `A31` double(10,3) DEFAULT NULL,
  `A32` double(10,3) DEFAULT NULL,
  `A33` double(10,3) DEFAULT NULL,
  `A34` double(10,3) DEFAULT NULL,
  `A35` double(10,3) DEFAULT NULL,
  `A36` double(10,3) DEFAULT NULL,
  `A37` double(10,3) DEFAULT NULL,
  `A38` double(10,3) DEFAULT NULL,
  `A39` double(10,3) DEFAULT NULL,
  `A40` double(10,3) DEFAULT NULL,
  `A41` double(10,3) DEFAULT NULL,
  `A42` double(10,3) DEFAULT NULL,
  `A43` double(10,3) DEFAULT NULL,
  `A44` double(10,3) DEFAULT NULL,
  `A45` double(10,3) DEFAULT NULL,
  `A46` double(10,3) DEFAULT NULL,
  `A47` double(10,3) DEFAULT NULL,
  `A48` double(10,3) DEFAULT NULL,
  `A49` double(10,3) DEFAULT NULL,
  `A50` double(10,3) DEFAULT NULL,
  `A51` double(10,3) DEFAULT NULL,
  `A52` double(10,3) DEFAULT NULL,
  `A53` double(10,3) DEFAULT NULL,
  `A54` double(10,3) DEFAULT NULL,
  `A55` double(10,3) DEFAULT NULL,
  `A56` double(10,3) DEFAULT NULL,
  `A57` double(10,3) DEFAULT NULL,
  `A58` double(10,3) DEFAULT NULL,
  `A59` double(10,3) DEFAULT NULL,
  `A60` double(10,3) DEFAULT NULL,
  `A61` double(10,3) DEFAULT NULL,
  `A62` double(10,3) DEFAULT NULL,
  `A63` double(10,3) DEFAULT NULL,
  `A64` double(10,3) DEFAULT NULL,
  `A65` double(10,3) DEFAULT NULL,
  `A66` double(10,3) DEFAULT NULL,
  `A67` double(10,3) DEFAULT NULL,
  `A68` double(10,3) DEFAULT NULL,
  `A69` double(10,3) DEFAULT NULL,
  `A70` double(10,3) DEFAULT NULL,
  `A71` double(10,3) DEFAULT NULL,
  `A72` double(10,3) DEFAULT NULL,
  `A73` double(10,3) DEFAULT NULL,
  `A74` double(10,3) DEFAULT NULL,
  `A75` double(10,3) DEFAULT NULL,
  `A76` double(10,3) DEFAULT NULL,
  `A77` double(10,3) DEFAULT NULL,
  `A78` double(10,3) DEFAULT NULL,
  `A79` double(10,3) DEFAULT NULL,
  `A80` double(10,3) DEFAULT NULL,
  `A81` double(10,3) DEFAULT NULL,
  `A82` double(10,3) DEFAULT NULL,
  `A83` double(10,3) DEFAULT NULL,
  `A84` double(10,3) DEFAULT NULL,
  `A85` double(10,3) DEFAULT NULL,
  `A86` double(10,3) DEFAULT NULL,
  `A87` double(10,3) DEFAULT NULL,
  `A88` double(10,3) DEFAULT NULL,
  `A89` double(10,3) DEFAULT NULL,
  `A90` double(10,3) DEFAULT NULL,
  `A91` double(10,3) DEFAULT NULL,
  `A92` double(10,3) DEFAULT NULL,
  `A93` double(10,3) DEFAULT NULL,
  `A94` double(10,3) DEFAULT NULL,
  `A95` double(10,3) DEFAULT NULL,
  `A96` double(10,3) DEFAULT NULL,
  `A97` double(10,3) DEFAULT NULL,
  `A98` double(10,3) DEFAULT NULL,
  `A99` double(10,3) DEFAULT NULL,
  `A100` double(10,3) DEFAULT NULL,
  `A101` double(10,3) DEFAULT NULL,
  `A102` double(10,3) DEFAULT NULL,
  `A103` double(10,3) DEFAULT NULL,
  `A104` double(10,3) DEFAULT NULL,
  `A105` double(10,3) DEFAULT NULL,
  `A106` double(10,3) DEFAULT NULL,
  `A107` double(10,3) DEFAULT NULL,
  `A108` double(10,3) DEFAULT NULL,
  `A109` double(10,3) DEFAULT NULL,
  `A110` double(10,3) DEFAULT NULL,
  `A111` double(10,3) DEFAULT NULL,
  `A112` double(10,3) DEFAULT NULL,
  `A113` double(10,3) DEFAULT NULL,
  `A114` double(10,3) DEFAULT NULL,
  `A115` double(10,3) DEFAULT NULL,
  `A116` double(10,3) DEFAULT NULL,
  `A117` double(10,3) DEFAULT NULL,
  `A118` double(10,3) DEFAULT NULL,
  `A119` double(10,3) DEFAULT NULL,
  `A120` double(10,3) DEFAULT NULL,
  `A121` double(10,3) DEFAULT NULL,
  `A122` double(10,3) DEFAULT NULL,
  `A123` double(10,3) DEFAULT NULL,
  `A124` double(10,3) DEFAULT NULL,
  `A125` double(10,3) DEFAULT NULL,
  `A126` double(10,3) DEFAULT NULL,
  `A127` double(10,3) DEFAULT NULL,
  `A128` double(10,3) DEFAULT NULL,
  `A129` double(10,3) DEFAULT NULL,
  `A130` double(10,3) DEFAULT NULL,
  `A131` double(10,3) DEFAULT NULL,
  `A132` double(10,3) DEFAULT NULL,
  `A133` double(10,3) DEFAULT NULL,
  `A134` double(10,3) DEFAULT NULL,
  `A135` double(10,3) DEFAULT NULL,
  `A136` double(10,3) DEFAULT NULL,
  `A137` double(10,3) DEFAULT NULL,
  `A138` double(10,3) DEFAULT NULL,
  `A139` double(10,3) DEFAULT NULL,
  `A140` double(10,3) DEFAULT NULL,
  `A141` double(10,3) DEFAULT NULL,
  `A142` double(10,3) DEFAULT NULL,
  `A143` double(10,3) DEFAULT NULL,
  `A144` double(10,3) DEFAULT NULL,
  `A145` double(10,3) DEFAULT NULL,
  `A146` double(10,3) DEFAULT NULL,
  `A147` double(10,3) DEFAULT NULL,
  `A148` double(10,3) DEFAULT NULL,
  `A149` double(10,3) DEFAULT NULL,
  `A150` double(10,3) DEFAULT NULL,
  `A151` double(10,3) DEFAULT NULL,
  `A152` double(10,3) DEFAULT NULL,
  `A153` double(10,3) DEFAULT NULL,
  `A154` double(10,3) DEFAULT NULL,
  `A155` double(10,3) DEFAULT NULL,
  `A156` double(10,3) DEFAULT NULL,
  `A157` double(10,3) DEFAULT NULL,
  `A158` double(10,3) DEFAULT NULL,
  `A159` double(10,3) DEFAULT NULL,
  `A160` double(10,3) DEFAULT NULL,
  `A161` double(10,3) DEFAULT NULL,
  `A162` double(10,3) DEFAULT NULL,
  `A163` double(10,3) DEFAULT NULL,
  `A164` double(10,3) DEFAULT NULL,
  `A165` double(10,3) DEFAULT NULL,
  `A166` double(10,3) DEFAULT NULL,
  `A167` double(10,3) DEFAULT NULL,
  `A168` double(10,3) DEFAULT NULL,
  `A169` double(10,3) DEFAULT NULL,
  `A170` double(10,3) DEFAULT NULL,
  `A171` double(10,3) DEFAULT NULL,
  `A172` double(10,3) DEFAULT NULL,
  `A173` double(10,3) DEFAULT NULL,
  `A174` double(10,3) DEFAULT NULL,
  `A175` double(10,3) DEFAULT NULL,
  `A176` double(10,3) DEFAULT NULL,
  `A177` double(10,3) DEFAULT NULL,
  `A178` double(10,3) DEFAULT NULL,
  `A179` double(10,3) DEFAULT NULL,
  `A180` double(10,3) DEFAULT NULL,
  `A181` double(10,3) DEFAULT NULL,
  `A182` double(10,3) DEFAULT NULL,
  `A183` double(10,3) DEFAULT NULL,
  `A184` double(10,3) DEFAULT NULL,
  `A185` double(10,3) DEFAULT NULL,
  `A186` double(10,3) DEFAULT NULL,
  `A187` double(10,3) DEFAULT NULL,
  `A188` double(10,3) DEFAULT NULL,
  `A189` double(10,3) DEFAULT NULL,
  `A190` double(10,3) DEFAULT NULL,
  `A191` double(10,3) DEFAULT NULL,
  `A192` double(10,3) DEFAULT NULL,
  `A193` double(10,3) DEFAULT NULL,
  `A194` double(10,3) DEFAULT NULL,
  `A195` double(10,3) DEFAULT NULL,
  `A196` double(10,3) DEFAULT NULL,
  `A197` double(10,3) DEFAULT NULL,
  `A198` double(10,3) DEFAULT NULL,
  `A199` double(10,3) DEFAULT NULL,
  `A200` double(10,3) DEFAULT NULL,
  `A201` double(10,3) DEFAULT NULL,
  `A202` double(10,3) DEFAULT NULL,
  `A203` double(10,3) DEFAULT NULL,
  `A204` double(10,3) DEFAULT NULL,
  `A205` double(10,3) DEFAULT NULL,
  `A206` double(10,3) DEFAULT NULL,
  `A207` double(10,3) DEFAULT NULL,
  `A208` double(10,3) DEFAULT NULL,
  `A209` double(10,3) DEFAULT NULL,
  `A210` double(10,3) DEFAULT NULL,
  `A211` double(10,3) DEFAULT NULL,
  `A212` double(10,3) DEFAULT NULL,
  `A213` double(10,3) DEFAULT NULL,
  `A214` double(10,3) DEFAULT NULL,
  `A215` double(10,3) DEFAULT NULL,
  `A216` double(10,3) DEFAULT NULL,
  `A217` double(10,3) DEFAULT NULL,
  `A218` double(10,3) DEFAULT NULL,
  `A219` double(10,3) DEFAULT NULL,
  `A220` double(10,3) DEFAULT NULL,
  `A221` double(10,3) DEFAULT NULL,
  `A222` double(10,3) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `matrix`
--

DROP TABLE IF EXISTS `matrix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matrix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper1` int(11) DEFAULT NULL,
  `paper2` int(11) DEFAULT NULL,
  `discplinedistance` float DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2565574 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-07 21:13:52
