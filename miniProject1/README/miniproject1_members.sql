-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: miniproject1
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `userNum` int NOT NULL AUTO_INCREMENT,
  `userExp` int DEFAULT '0',
  `userId` varchar(20) DEFAULT NULL,
  `userPwd` varchar(20) DEFAULT NULL,
  `checkPwd` varchar(20) DEFAULT NULL,
  `nickName` varchar(20) DEFAULT NULL,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `phoneNo` varchar(20) DEFAULT NULL,
  `pwdHintQ` varchar(50) DEFAULT NULL,
  `pwdHint` varchar(50) DEFAULT NULL,
  `userJob` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `attDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `regDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userNum`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,200,'apple0927','apple0927','apple0927','apple0927','사','과','01011111111','내가 태어난 곳은?','나무','soldier','male','2022-09-27 08:52:27','2022-09-26 19:04:50'),(2,600,'banana0927','banana0927','banana0927','banana0927','바','나나','01022222222','내가 태어난 곳은?','나무','family','male','2022-09-27 10:19:30','2022-09-26 19:09:34'),(3,100,'camera0927','camera0927','camera0927','camera0927','카','메라','01033333333','내가 태어난 곳은?','사진관','soldier','female','2022-09-26 19:13:06','2022-09-26 19:13:06'),(4,1400,'dbsn1234','dbsn1234','dbsn1234','유누','이','유누','01029304864','내가 태어난 곳은?','유누','soldier','male','2022-09-27 17:34:57','2022-09-26 19:28:30'),(5,100,'conana123','conana123','conana123','conana123','코','나나','01010101010','내가 태어난 곳은?','conana123','girlfriend','female','2022-09-26 19:29:48','2022-09-26 19:29:48'),(6,0,'death0927','death0927','death0927','death0927','죽','음','01044444444','내가 태어난 곳은?','사신','girlfriend','female','2022-09-26 19:36:45','2022-09-26 19:36:45'),(7,300,'wannabe','wannabe123','wannabe123','wannabe','워','너비','021111111','내가 졸업한 초등학교는?','wannabe','soldier','male','2022-09-26 19:38:53','2022-09-26 19:38:53'),(8,400,'elephant0927','elephant0927','elephant0927','elephant0927','코','끼리','01055555555','내가 태어난 곳은?','동물원','family','female','2022-09-26 19:39:01','2022-09-26 19:39:01'),(9,1000,'2020ljh','2020ljh123','2020ljh123','2020ljh','이','재현','020000000','내가 태어난 곳은?','2020ljh','girlfriend','female','2022-09-26 19:41:05','2022-09-26 19:41:05'),(10,600,'jeahyunC','jeahyunC','jeahyunC','jeahyunC','재','현씨','01066666666','내가 태어난 곳은?','서울','girlfriend','female','2022-09-26 19:41:05','2022-09-26 19:41:05'),(11,700,'parkbom','parkbom123','parkbom123','parkbom','박','봄','012345678','내가 태어난 곳은?','parkbom','normal','female','2022-09-26 19:43:57','2022-09-26 19:43:57'),(12,400,'writer123','writer123','writer123','라이터','라','이터','021234567','내가 태어난 곳은?','라이터','soldier','male','2022-09-26 19:49:38','2022-09-26 19:49:38'),(13,200,'yasuo123','yasuo123','yasuo123','야스오장인','야','스오','0111234392','나의 보물 1호는?','yasuo123','normal','male','2022-09-26 20:04:25','2022-09-26 20:04:25'),(14,0,'jquery123','jquery123','jquery123','제이쿼리','제이','쿼리','01012341234','내가 태어난 곳은?','jquery123','normal','female','2022-09-26 20:06:15','2022-09-26 20:06:15'),(15,0,'muyaho123','muyaho123','muyaho123','MuYaHo','무','야호','0123429302','내가 태어난 곳은?','muyaho123','soldier','male','2022-09-26 20:11:42','2022-09-26 20:11:42'),(16,400,'hwasuck1','hwasuck1','hwasuck1','hwasuck1','화','석','01023213221','내가 태어난 곳은?','hwasuck1','normal','female','2022-09-26 20:19:09','2022-09-26 20:19:09'),(17,1000,'hyuck123','hyuck123','hyuck123','hhk','홍','돈','023028502','내가 태어난 곳은?','hyuck123','soldier','female','2022-09-26 20:21:59','2022-09-26 20:21:59'),(18,500,'kkdonoin','kkdonoin123','kkdonoin123','경기도노인','경','기도','0320892392','내가 태어난 곳은?','kkdonoin','soldier','male','2022-09-26 20:23:05','2022-09-26 20:23:05'),(19,0,'free00123','free00123','free00123','free00123','자','유','01045698788','내가 태어난 곳은?','프리덤','soldier','male','2022-09-26 20:24:32','2022-09-26 20:24:32'),(20,200,'kingJava','kingJava','kingJava','JavaKing','자','바','023982302','내가 태어난 곳은?','kingJava','soldier','male','2022-09-26 20:24:57','2022-09-26 20:24:57'),(21,0,'pythonKing','pythonKing','pythonKing','파이썬왕','파','이썬','029329323','내가 태어난 곳은?','pythonKing','girlfriend','female','2022-09-26 20:27:40','2022-09-26 20:27:40'),(22,700,'goonmusae','goonmusae','goonmusae','goonmusae','군','무새','023023203','내가 태어난 곳은?','goonmusae','soldier','male','2022-09-26 20:28:31','2022-09-26 20:28:31'),(23,600,'terryJJang','terryJJang','terryJJang','테리짱짱짱','테','리','01023928323','내가 태어난 곳은?','terryJJang','normal','male','2022-09-26 20:30:31','2022-09-26 20:30:31'),(24,300,'shootdol2','shootdol2','shootdol2','슛돌이','shootdol2','shootdol2','023920239','내가 태어난 곳은?','shootdol2','normal','female','2022-09-26 20:38:57','2022-09-26 20:38:57'),(25,300,'mamuri232','mamuri232','mamuri232','mamuri232','마','무리','01021223822','내가 태어난 곳은?','mamuri232','girlfriend','female','2022-09-26 20:39:24','2022-09-26 20:39:24'),(26,100,'matahari223','matahari223','matahari223','matahari223','matahari223','matahari223','0213212321','내가 태어난 곳은?','matahari223','soldier','male','2022-09-26 20:39:56','2022-09-26 20:39:56'),(27,100,'lolking232','lolking232','lolking232','롤킹','lolking232','lolking232','023929423','내가 태어난 곳은?','lolking232','girlfriend','female','2022-09-26 20:40:17','2022-09-26 20:40:17'),(28,100,'battery22','battery22','battery22','battery22','battery22','battery22','029392402','내가 태어난 곳은?','battery22','normal','female','2022-09-26 20:40:37','2022-09-26 20:40:37'),(29,0,'believeMe','believeMe','believeMe','빌리브미','believeMe','believeMe','029392023','내가 태어난 곳은?','believeMe','soldier','male','2022-09-26 20:42:58','2022-09-26 20:42:58'),(30,800,'KingSQL123','KingSQL123','KingSQL123','KingSQLitSMe','KingSQL123','KingSQL123','029328429','내가 태어난 곳은?','KingSQL123','soldier','female','2022-09-26 20:43:53','2022-09-26 20:43:53'),(31,900,'ppapppap','ppapppap','ppapppap','PPAP','ppapppap','ppapppap','020392012','내가 태어난 곳은?','ppapppap','normal','female','2022-09-26 20:45:03','2022-09-26 20:45:03'),(32,0,'okeydokeyYo','okeydokeyYo','okeydokeyYo','오키도키요','okeydokeyYo','okeydokeyYo','023920382','내가 태어난 곳은?','okeydokeyYo','normal','male','2022-09-26 20:46:39','2022-09-26 20:46:39'),(33,200,'helloWorld','helloWorld','helloWorld','hw','helloWorld','helloWorld','0102932823','내가 태어난 곳은?','helloWorld','girlfriend','female','2022-09-26 20:47:35','2022-09-26 20:47:35'),(34,0,'goodNight123','goodNight123','goodNight123','잘자요','goodNight123','goodNight123','020329123','내가 태어난 곳은?','goodNight123','normal','male','2022-09-26 20:50:09','2022-09-26 20:50:09'),(35,600,'rapperDong','rapperDong','rapperDong','래퍼Dong','rapperDong','rapperDong','0293220923','내가 태어난 곳은?','rapperDong','normal','male','2022-09-26 20:51:38','2022-09-26 20:51:38'),(36,500,'narangDo','narangDo','narangDo','나랑두사이다','narangDo','narangDo','0239290323','내가 태어난 곳은?','narangDo','girlfriend','female','2022-09-26 20:53:50','2022-09-26 20:53:50'),(37,800,'DBDBDip','DBDBDip1','DBDBDip1','디비디비딥','DBDBDip','DBDBDip','023920321','내가 태어난 곳은?','DBDBDip','soldier','male','2022-09-26 20:55:24','2022-09-26 20:55:24'),(38,0,'dbsn12345','dbsn2930','dbsn2930','유누임임','이','유누','01029322022','내가 태어난 곳은?','유누네집','soldier','male','2022-09-27 15:34:39','2022-09-27 15:34:39');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28  6:15:43
