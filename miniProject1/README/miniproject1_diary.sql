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
-- Table structure for table `diary`
--

DROP TABLE IF EXISTS `diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diary` (
  `diaryNumber` int NOT NULL AUTO_INCREMENT,
  `intro` varchar(1000) DEFAULT NULL,
  `writer` varchar(50) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `regDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`diaryNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diary`
--

LOCK TABLES `diary` WRITE;
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
INSERT INTO `diary` VALUES (1,NULL,'free00123','오늘 첫 사격을 했다.','오늘 사격을 했는데 20발 중 20발을 다 맞춰\n포상 휴가를 받았다.\n너무 기분이 좋았다.','2022-09-26 20:25:08'),(2,NULL,'free00123','px를 처음 갔다','먹을게 진짜 많았다.\n가격이 왜 이렇게 싸?','2022-09-26 20:25:27'),(3,NULL,'free00123','선임한테 혼났다.','전투화를 안닦아서 혼났다.. 슬펐다..ㅠㅠ','2022-09-26 20:25:44'),(4,NULL,'유누','오늘 첫 사격을 했다.','오늘 첫 사격을 했는데 20발중 20발을 맞춰 \n포상 휴가를 받았다.\n분대장님들이 예뻐했다. 좋았다 ㅎ','2022-09-26 20:27:13'),(5,NULL,'유누','오늘 첫 부대를 갔다.','선임들을 처음 만났는데 너무 무서웠다..\n분위기에 압도 당한다는게 이런기분일까','2022-09-26 20:27:37'),(6,NULL,'유누','오늘 px를 갔다.','동기와 함께 px를 갔는데 맛있는게 너무 많았다.\n그리고 가격은 왜이렇게 싸지?','2022-09-26 20:27:57'),(7,NULL,'유누','첫 월급을 받았다. 기분이 안좋다.','첫 월급을 받았는데 군대에 있어서 그런지 기분이 안좋았다. 이거로 맛있는거나 사먹어야지','2022-09-26 20:28:31'),(8,NULL,'유누','px에서 총을 살 뻔 했다.','선임들한테 낚여서 px가서 총을 주문했다.\n나를 미친놈 보듯이 쳐다보더라.. 민망했다','2022-09-26 20:28:53'),(9,NULL,'유누','유격을 했다. 내 몸이 내 몸이 아니다.','이것이 유격이구나.. \n내 몸이 의지로 움직이는 것이 아니었다.','2022-09-26 20:29:37'),(10,NULL,'유누','혹한기를 했다. 콧물이 얼었다.','짜더라...ㅠㅠㅠ','2022-09-26 20:29:52'),(11,NULL,'유누','발표를한다. 떨린다..','덜덜덜 윤후야 화이팅!','2022-09-27 10:43:20');
/*!40000 ALTER TABLE `diary` ENABLE KEYS */;
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
