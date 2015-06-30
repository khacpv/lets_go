-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: oicbook
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(512) NOT NULL,
  `author` varchar(512) DEFAULT NULL,
  `isbn13` varchar(45) DEFAULT NULL,
  `isbn10` varchar(45) DEFAULT NULL,
  `thumbnail` varchar(1024) DEFAULT NULL,
  `description` longtext,
  `createDate` datetime DEFAULT NULL,
  `cost` varchar(128) DEFAULT NULL,
  `totalPages` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `tag` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (3,'Traction','Justin Mares',NULL,NULL,'http://storage.oicmap.com/blob/traction.png','Traction: A Startup Guide to Getting Customers',NULL,NULL,NULL,8,NULL),(4,'The Dip','Seth Godin','9781101216347',NULL,NULL,'A Little Book That Teaches You When to Quit (and When to Stick)',NULL,NULL,NULL,8,'Entrepreneurship'),(5,'Running Lean','Ash Maurya','9781449331900',NULL,'http://storage.oicmap.com/blob/running_lean.png','Iterate from Plan A to a Plan That Works',NULL,NULL,NULL,8,'Business & Economics, Business Development, Development, Entrepreneurship, New Business Enterprises, Small Business'),(6,'Lean Analytics','Alistair Croll, Benjamin Yoskovitz ','9781449335717',NULL,NULL,'Use Data to Build a Better Startup Faster',NULL,NULL,NULL,8,'Business & Economics, Business Development, Development, Entrepreneurship, New Business Enterprises, Small Business, Statistics'),(7,'Think and Grow Rich','Napoleon Hill ','9781627938204',NULL,NULL,'A motivational personal development and self-help book ',NULL,NULL,NULL,8,'Business Development, Development, Entrepreneurship, Motivational, New Business Enterprises, Small Business'),(8,'The Art of the Start 2.0','Guy Kawasaki ','9780698193635',NULL,NULL,'The Time-Tested, Battle-Hardened Guide for Anyone Starting Anything',NULL,NULL,NULL,8,'Business Development, Development, Entrepreneurship, Motivational, New Business Enterprises, Small Business'),(9,'Rework','Jason Fried, David Heinemeier Hansson ','9780307463760',NULL,NULL,'A better, faster, easier way to succeed in business',NULL,NULL,NULL,8,'Business & Investing'),(10,'How To Win Friends and Influence People','Dale Carnegie ','9781451621716',NULL,NULL,'a timeless bestseller, packed with rock-solid advice that has carried thousands of now famous people up the ladder of success in their business and personal lives',NULL,NULL,NULL,8,'Business & Investing, Philosophy, Communication & Social Skills'),(11,'All Marketers Are Liars','Seth Godin','9781101184547',NULL,NULL,'The Underground Classic That Explains How Marketing Really Works--and Why Authen ticity Is the Best Marketing of All',NULL,NULL,NULL,8,'Business & Investing, Marketing'),(12,'Delivering Happiness','BusinessNews Publishing','9782511017586',NULL,NULL,'A Path to Profits, Passion and Purpose',NULL,NULL,NULL,8,'Business Development, Development, Entrepreneurship, Strategic planning'),(13,'Lean Startup','Eric Ries ','9780307887917',NULL,NULL,'How Today\'s Entrepreneurs Use Continuous Innovation to Create Radically Successful Businesses',NULL,NULL,NULL,8,'Business Development, Development, Entrepreneurship, Motivational, New Business Enterprises, Small Business'),(14,'50 ways to find funding for your business','Emma Jones','9780857192905',NULL,NULL,'Case studies of companies who have successfully raised funds',NULL,NULL,NULL,8,'Business & Investing, Entrepreneurship'),(15,'The Startup Kit','Emma Jones','9781908003744',NULL,NULL,'Everything you need to start a small business',NULL,NULL,NULL,8,'Business & Investing, Entrepreneurship'),(16,'Getting Things Done','David Allen','9780698161863',NULL,NULL,'The Art of Stress-Free Productivity',NULL,NULL,NULL,8,'Business & Investing, Motivational');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Giáo dục'),(2,'Y học'),(3,'Đời sống'),(4,'Lập trình'),(5,'Khởi nghiệp'),(6,'Luật'),(7,'Kinh tế'),(8,'Entrepreneurship');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `userName` varchar(512) DEFAULT NULL,
  `bookTitle` varchar(512) DEFAULT NULL,
  `content` longtext,
  `image` varchar(512) DEFAULT NULL,
  `link` varchar(512) DEFAULT NULL,
  `createdDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,1,'Khac','The Dig','khong hay lam','http://google.com','http://google.com','2015-06-16 00:00:00',0),(2,1,2,'Khac','Traction','Khong hay lam',NULL,NULL,'2015-06-23 00:14:14',0),(3,2,1,'han thuy','The Dig','Binh thuong',NULL,NULL,'2015-06-23 00:19:19',0),(4,0,1,'Reader User','Running Lean','hello qua hay',NULL,NULL,'2015-06-24 02:17:29',0),(5,0,1,'Reader User','Running Lean','hello qua hay','0','0','2015-06-24 02:18:33',0),(6,0,1,'Reader User','Running Lean','tôi thích cuốn này','0','0','2015-06-24 02:26:25',0),(7,0,2,'Reader User','Lean Analytics','hơi ít comment','0','0','2015-06-24 02:28:59',0),(8,0,1,'Reader User','Running Lean','không thích lắm','0','0','2015-06-24 23:07:54',0),(9,0,1,'Reader User','Running Lean','nen doc cac ban tre a','0','0','2015-06-24 23:24:02',0);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `slug` varchar(128) NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `slug` (`slug`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'Tin hot','home','Tin cuc ky hot'),(2,'Tin Nong hoi','tag','nomyunmousfacebook'),(3,'Sach cua toi','sach-cua-toi','Sach nay rat hay'),(4,'obama','obama','test'),(5,'obama','obama','test'),(6,'barack','barack','barack'),(7,'barack','barack','barack'),(8,'hello','hello','chao');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `comment` varchar(1024) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `expireDate` datetime DEFAULT NULL,
  `type` varchar(45) DEFAULT 'exchange',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport`
--

LOCK TABLES `transport` WRITE;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `displayName` varchar(512) DEFAULT NULL,
  `password` varchar(1024) DEFAULT NULL,
  `privateEmail` varchar(512) DEFAULT NULL,
  `accessToken` varchar(1024) DEFAULT NULL,
  `avatarUrl` varchar(1024) DEFAULT NULL,
  `gcmToken` varchar(1024) DEFAULT NULL,
  `fbId` varchar(512) DEFAULT NULL,
  `fbAccessToken` varchar(512) DEFAULT NULL,
  `fbExpiredDate` datetime DEFAULT NULL,
  `fbEmail` varchar(512) DEFAULT NULL,
  `fbUserName` varchar(512) DEFAULT NULL,
  `emailNotification` varchar(512) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `isActivated` int(11) DEFAULT '1',
  `address` varchar(1024) DEFAULT NULL,
  `latitude` varchar(128) DEFAULT NULL,
  `longitude` varchar(128) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'khacpv','Pham Khac',NULL,NULL,NULL,'oicmap.com/img/khac.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'admin',NULL,'21232f297a57a5a743894a0e4a801fc3','admin@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'admin1',NULL,'1f32aa4c9a1d2ea010adcf2348166a04','admin1@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'admin2',NULL,'827ccb0eea8a706c4c34a16891f84e7b','admin2@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'admin4',NULL,'fc1ebc848e31e0a68e868432225e3c82','admin4@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userBook`
--

DROP TABLE IF EXISTS `userBook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userBook` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `quantity` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Người dùng có bao nhiêu cuốn sách.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userBook`
--

LOCK TABLES `userBook` WRITE;
/*!40000 ALTER TABLE `userBook` DISABLE KEYS */;
/*!40000 ALTER TABLE `userBook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-30  1:23:14
