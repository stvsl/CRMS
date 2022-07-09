-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 120.48.17.34    Database: CRMS
-- ------------------------------------------------------
-- Server version	5.5.5-10.8.3-MariaDB-1:10.8.3+maria~jammy

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
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Admin` (
  `ano` char(6) NOT NULL,
  `aname` char(10) DEFAULT NULL,
  `password` int(11) NOT NULL DEFAULT 12345678,
  PRIMARY KEY (`ano`),
  UNIQUE KEY `Administrator_UN` (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES ('123456','Admin',12345678);
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Arrange`
--

DROP TABLE IF EXISTS `Arrange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Arrange` (
  `classno` char(10) NOT NULL,
  `cno` char(10) NOT NULL,
  `rno` char(6) NOT NULL,
  `tno` char(6) NOT NULL,
  `times` int(2) NOT NULL,
  PRIMARY KEY (`classno`,`cno`,`rno`,`tno`,`times`),
  KEY `Arrange_FK_1` (`cno`),
  KEY `Arrange_FK_2` (`rno`),
  KEY `Arrange_FK_3` (`tno`),
  CONSTRAINT `Arrange_FK` FOREIGN KEY (`classno`) REFERENCES `Class` (`classno`) ON UPDATE CASCADE,
  CONSTRAINT `Arrange_FK_1` FOREIGN KEY (`cno`) REFERENCES `Course` (`cno`) ON UPDATE CASCADE,
  CONSTRAINT `Arrange_FK_2` FOREIGN KEY (`rno`) REFERENCES `Room` (`rno`) ON UPDATE CASCADE,
  CONSTRAINT `Arrange_FK_3` FOREIGN KEY (`tno`) REFERENCES `Teacher` (`tno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Arrange`
--

LOCK TABLES `Arrange` WRITE;
/*!40000 ALTER TABLE `Arrange` DISABLE KEYS */;
/*!40000 ALTER TABLE `Arrange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Class`
--

DROP TABLE IF EXISTS `Class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Class` (
  `classno` char(10) NOT NULL COMMENT '班级编号',
  `classname` char(20) DEFAULT NULL COMMENT '班级名称',
  `classgrade` smallint(6) DEFAULT 1 COMMENT '年级',
  `classdept` varchar(15) DEFAULT NULL COMMENT '系别',
  `classprofession` char(15) DEFAULT NULL COMMENT '专业',
  `password` varchar(18) NOT NULL COMMENT '密码',
  `classton` smallint(6) DEFAULT 1 COMMENT '班级人数',
  PRIMARY KEY (`classno`),
  UNIQUE KEY `Class_UN` (`classno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Class`
--

LOCK TABLES `Class` WRITE;
/*!40000 ALTER TABLE `Class` DISABLE KEYS */;
INSERT INTO `Class` VALUES ('0000000001','软件201',4,'电信学院','软件工程','12345678',10),('0000000005',NULL,1,NULL,NULL,'12345678',1),('123456',NULL,1,NULL,NULL,'12345678',1),('ok',NULL,1,NULL,NULL,'123456',1),('张三','计算机201班',1,'计算机','计算机科学与技术','123456',31);
/*!40000 ALTER TABLE `Class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `cno` char(10) NOT NULL,
  `cname` char(15) CHARACTER SET utf8mb3 NOT NULL,
  `length` int(1) NOT NULL DEFAULT 2,
  PRIMARY KEY (`cno`),
  UNIQUE KEY `Course_UN` (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('1000001','数据库',2),('1000011','测试课程',2),('1000012','数据结构',2);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--

DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Room` (
  `rno` char(6) NOT NULL,
  `rdescription` char(10) DEFAULT NULL,
  PRIMARY KEY (`rno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `Room` VALUES ('5A001','五号楼001'),('5A002','五号楼002'),('9A000','九号楼000');
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `tname` char(10) DEFAULT NULL,
  `tno` char(6) NOT NULL,
  `password` varchar(18) NOT NULL DEFAULT '12345678',
  PRIMARY KEY (`tno`),
  UNIQUE KEY `Teacher_UN` (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES ('测试','000001','12345678'),('ok','ok','123456');
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'CRMS'
--
/*!50003 DROP FUNCTION IF EXISTS `verifypassword` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `verifypassword`(id varchar(10),passwd varchar(18)) RETURNS int(1)
BEGIN
    DECLARE isAdmin INT;
    DECLARE isClass INT;
    DECLARE isTeacher INT;
    
    SELECT COUNT(*) INTO isAdmin FROM Admin WHERE ano = id AND password = passwd;
    SELECT COUNT(*) INTO isClass FROM Class WHERE classno = id AND password = passwd;
    SELECT COUNT(*) INTO isTeacher FROM Teacher WHERE tno = id AND password = passwd;
    RETURN isAdmin+isClass*2+isTeacher*3;
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

-- Dump completed on 2022-07-04 12:48:14
