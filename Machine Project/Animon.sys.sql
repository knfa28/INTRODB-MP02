CREATE DATABASE  IF NOT EXISTS `animon.sys` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `animon.sys`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: animon.sys
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_code` varchar(45) NOT NULL,
  `course_name` varchar(45) NOT NULL,
  `units` int(11) NOT NULL,
  `dept_num` varchar(45) NOT NULL,
  PRIMARY KEY (`course_code`),
  UNIQUE KEY `course_code_UNIQUE` (`course_code`),
  KEY `dept_u_idx` (`dept_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('CCSCAL2','Calculus 2',3,'D003'),('DIGIDES','Digital Design',3,'D002'),('FTTEAMS','Team Sports',2,'D004'),('INTESYS','Intelligent Systems',3,'D001'),('INTRODB','Introduction to Databases',3,'D001');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_num` varchar(45) NOT NULL,
  `dept_name` varchar(45) NOT NULL,
  `dept_head` varchar(45) NOT NULL,
  PRIMARY KEY (`dept_num`),
  KEY `fk_department_faculty1_idx` (`dept_head`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('D001','Software Technology','10001'),('D002','Network Engineering','20001'),('D003','Mathematics','30001'),('D004','Physical Education','40001');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `faculty_id` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `email_add` varchar(45) NOT NULL,
  `hire_date` date NOT NULL,
  `to_date` date NOT NULL,
  `dept_num` varchar(45) NOT NULL,
  PRIMARY KEY (`faculty_id`),
  UNIQUE KEY `faculty_id_UNIQUE` (`faculty_id`),
  KEY `dept_num_idx` (`dept_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES ('1001','Ong','Ehtel','ethel.ong@dlsu.edu.ph','2010-03-25','9999-01-01','D001'),('1002','Caronongan','Arturo','arturo.caronongan@dlsu.edu.ph','2012-10-03','9999-01-01','D001'),('2001','Ilao','Joel','joel.ilao@dlsu.edu.ph','2012-10-14','9999-01-01','D002'),('3001','Reyes','Tristan','tristan.reyes@dlsu.edu.ph','2007-04-05','9999-01-01','D003'),('4001','Mendizabal','Bengie','bengie.mendizabal@dlsu.edu.ph','2009-04-26','9999-01-01','D004');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offering`
--

DROP TABLE IF EXISTS `offering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offering` (
  `course_num` int(11) NOT NULL,
  `term` int(11) NOT NULL,
  `acad_year` varchar(45) NOT NULL,
  `section` varchar(45) NOT NULL,
  `sched_days` varchar(45) NOT NULL,
  `start_time` varchar(45) NOT NULL,
  `end_time` varchar(45) NOT NULL,
  `room_num` varchar(45) NOT NULL,
  `capacity` int(11) NOT NULL,
  `enrolled` int(11) NOT NULL,
  `course_code` varchar(45) NOT NULL,
  `faculty_id` varchar(45) NOT NULL,
  PRIMARY KEY (`course_num`),
  UNIQUE KEY `course_num_UNIQUE` (`course_num`),
  KEY `faculty_id_idx` (`faculty_id`),
  KEY `course_code_idx` (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offering`
--

LOCK TABLES `offering` WRITE;
/*!40000 ALTER TABLE `offering` DISABLE KEYS */;
INSERT INTO `offering` VALUES (10001,2,'2014-2015','S17','MW','09:15','10:45','G306',45,45,'INTRODB','1001'),(10002,2,'2014-2015','S17','MW','11:00','12:30','G207',45,43,'INTESYS','1002'),(20001,2,'2014-2015','S18','TH','14:30','16:00','G208',45,41,'DIGIDES','2001'),(30001,2,'2014-2015','S11','TH','12:45','14:15','G210',45,38,'CCSCAL2','3001'),(40001,2,'2014-2015','S15','M','13:00','15:00','ER101',45,42,'FTTEAMS','4001');
/*!40000 ALTER TABLE `offering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `email_add` varchar(45) NOT NULL,
  `degree` varchar(45) NOT NULL,
  `enroll_date` date NOT NULL,
  `to_date` date NOT NULL,
  `status` varchar(45) NOT NULL,
  `cgpa` int(11) NOT NULL,
  `term_units` int(11) NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (10725635,'Obama','Barrack','obamallama@gmail.com','CS-CSE','2007-01-12','9999-01-01','UNDERGRADUATE',4,22),(11124345,'Connor','Jon','ill_be_back@hotmail.com','CS-IST','2011-10-20','9999-01-01','UNDERGRADUATE',3,5),(11313803,'Choy','Seaver','homenycablue@yahoo.com','CS-ST','2013-04-10','9999-01-01','UNDERGRADUATE',3,18),(11327278,'Hade','Alden','aldstm@gmail.com','CS-ST','2013-04-25','9999-01-01','UNDERGRADUATE',3,17),(11337974,'Aquino','Kurt','kurtaquino28@yahoo.com','CS-ST','2013-04-07','9999-01-01','UNDERGRADUATE',3,15);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_record`
--

DROP TABLE IF EXISTS `transaction_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_record` (
  `transction_id` int(11) NOT NULL,
  `date_stamp` varchar(45) NOT NULL,
  `time_stamp` varchar(45) NOT NULL,
  `transaction_type` varchar(45) NOT NULL,
  `student_id` int(11) NOT NULL,
  `course_num` int(11) NOT NULL,
  PRIMARY KEY (`transction_id`),
  UNIQUE KEY `transction_id_UNIQUE` (`transction_id`),
  KEY `course_num_idx` (`course_num`),
  KEY `student_id_idx` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_record`
--

LOCK TABLES `transaction_record` WRITE;
/*!40000 ALTER TABLE `transaction_record` DISABLE KEYS */;
INSERT INTO `transaction_record` VALUES (1,'2014-07-24','09:00','ADD',11337974,10001),(2,'2014-07-25','10:00','ADD',11313803,10002),(3,'2014-07-30','12:00','DROP',11327278,20001),(4,'2014-08-04','14:30','DROP',11124345,30001),(5,'2014-08-05','17:00','ADD',10725635,40001);
/*!40000 ALTER TABLE `transaction_record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-06  1:23:27
