-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: hoteldb
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `t_ask`
--

DROP TABLE IF EXISTS `t_ask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_ask` (
  `ask_idx` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(300) COLLATE utf8_bin NOT NULL,
  `contents` text COLLATE utf8_bin NOT NULL,
  `hit_cnt` smallint(10) DEFAULT '0',
  `regist_dt` datetime NOT NULL,
  `regist_id` varchar(50) COLLATE utf8_bin NOT NULL,
  `updated_dt` datetime DEFAULT NULL,
  `updated_id` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` char(1) COLLATE utf8_bin NOT NULL DEFAULT 'N',
  PRIMARY KEY (`ask_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ask`
--

LOCK TABLES `t_ask` WRITE;
/*!40000 ALTER TABLE `t_ask` DISABLE KEYS */;
INSERT INTO `t_ask` VALUES (4,'수영장 사용 시간 문의합니다.','혼자 통으로 빌릴 수 있나요?',0,'2023-01-26 10:26:23','러브다이브',NULL,NULL,'N'),(5,'픽업 가능한가요?','픽업 서비스 이용 하고 싶습니다.',0,'2023-01-26 10:31:13','이종석',NULL,NULL,'N'),(6,'주차 관련 문의 있습니다','주차 비용 알고 싶어요',0,'2023-01-26 10:37:08','김혜수',NULL,NULL,'N'),(7,'수영장 사용 문의','튜브도 빌려주나요? 맥주병입니다',0,'2023-01-26 10:42:04','소윤',NULL,NULL,'N'),(8,'아이 두 명 침구 추가 문의합니다','아이랑 함께 갑니다',0,'2023-01-26 10:44:24','메뚜기',NULL,NULL,'N'),(9,'컨시어지 서비스 문의합니다','부모님이랑 갈거에요',0,'2023-01-26 10:52:36','이지은',NULL,NULL,'N'),(10,'안녕하세요 ^^ 문의 드릴게 있습니다','그런게 있음',0,'2023-01-26 10:54:48','박보검',NULL,NULL,'N'),(11,'세미나실 예약 문의','회의실 사용할거임',0,'2023-01-26 11:00:21','김태우',NULL,NULL,'N'),(12,'디너 예약 문의드립니다.','디너 이용할거임\r\n',0,'2023-01-26 11:03:34','송지효',NULL,NULL,'N'),(13,'식사는 몇 인까지 이용 가능해요?','제곧내',0,'2023-01-26 11:06:42','하동훈',NULL,NULL,'N'),(14,'예약자 말고 다른 사람이 이용해도 될까요?','ㅇㅇ',0,'2023-01-26 11:10:19','한소희',NULL,NULL,'N'),(15,'야경이 잘 보이는 방으로 예약하고 싶습니다.','ㅈㄱㄴ',0,'2023-01-26 11:11:37','도민준',NULL,NULL,'N'),(16,'예약 취소 문의합니다','ㅇㅇㅇㅇ',0,'2023-01-26 11:13:57','서강준',NULL,NULL,'N');
/*!40000 ALTER TABLE `t_ask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_create`
--

DROP TABLE IF EXISTS `t_create`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_create` (
  `user_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `user_password` varchar(200) COLLATE utf8_bin NOT NULL,
  `user_password_check` varchar(200) COLLATE utf8_bin NOT NULL,
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `user_nickname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `user_email` varchar(100) COLLATE utf8_bin NOT NULL,
  `user_contact` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_create`
--

LOCK TABLES `t_create` WRITE;
/*!40000 ALTER TABLE `t_create` DISABLE KEYS */;
INSERT INTO `t_create` VALUES ('ccc','ccc','ccc','한소희','한소희','ccc@ccc','010-3333-3333'),('fff','fff','fff','김혜수','김혜수','fff@fff','010-6666-6666'),('ggg','ggg','ggg','박보검','박보검','ggg@ggg','010-7777-7777'),('haha','eee','eee','하동훈','하하','eee@eee','010-5555-5555'),('hhh','hhh','hhh','송지효','송지효','hhh@hhh','010-8888-8888'),('iii','iii','iii','도민준','도민준','iii@iii','010-9999-9999'),('jeasuck','ddd','ddd','유재석','메뚜기','ddd@ddd','010-1234-1234'),('jjj','jjj','jjj','주소윤','소윤','jjj@jjj','010-1010-1111'),('kangjun','aaa','aaa','서강준','서강준','aaa@aaa','010-1111-1111'),('kimtaewo','bbb','bbb','김태우','김태우','bbb@bbb','010-2222-2222'),('kkk','kkk','kkk','이동욱','이동욱','kkk@kkk','010-1212-1212'),('lll','lll','lll','이지은','아이유','lll@lll','010-1313-1313'),('mmm','mmm','mmm','이종석','이종석','mmm@mmm','010-1414-1414'),('ooo','ooo','ooo','장원영','장원영','ooo@ooo','010-1515-1515'),('ppp','ppp','ppp','이효리','이효리','ppp@ppp','010-1515-1515');
/*!40000 ALTER TABLE `t_create` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_reservation`
--

DROP TABLE IF EXISTS `t_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_reservation` (
  `reservation_idx` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `reservation_contact` varchar(200) COLLATE utf8_bin NOT NULL,
  `check_in` date NOT NULL,
  `room_type` varchar(200) COLLATE utf8_bin NOT NULL,
  `pool_reservation` char(1) COLLATE utf8_bin NOT NULL,
  `check_out` date NOT NULL,
  PRIMARY KEY (`reservation_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_reservation`
--

LOCK TABLES `t_reservation` WRITE;
/*!40000 ALTER TABLE `t_reservation` DISABLE KEYS */;
INSERT INTO `t_reservation` VALUES (1,'장원영','010-1515-1515','2023-01-27','Seoul_Suite','Y','2023-01-28');
/*!40000 ALTER TABLE `t_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_review`
--

DROP TABLE IF EXISTS `t_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_review` (
  `review_idx` int(11) NOT NULL AUTO_INCREMENT,
  `user_nickname` varchar(20) COLLATE utf8_bin NOT NULL,
  `title` varchar(300) COLLATE utf8_bin NOT NULL,
  `contents` text COLLATE utf8_bin NOT NULL,
  `hit_cnt` smallint(10) DEFAULT '0',
  `regist_dt` date NOT NULL,
  `updated_dt` date DEFAULT NULL,
  `deleted_yn` char(1) COLLATE utf8_bin DEFAULT 'N',
  `review_image` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `review_star` smallint(5) DEFAULT '0',
  PRIMARY KEY (`review_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_review`
--

LOCK TABLES `t_review` WRITE;
/*!40000 ALTER TABLE `t_review` DISABLE KEYS */;
INSERT INTO `t_review` VALUES (2,'소희','깨끗해서 기분 좋게 쉬고 왔어요','제주 호텔 중에 최고 입니다!  소파가 푹신해서 바깥 풍경 보면서 수다 떨기 좋았어요.',6,'2023-01-26','2023-01-26','N','c:/java/upload/호텔 룸 사진.jpg',5),(3,'장원영','수영장이 너무 좋았어요','간만에 재밌게 놀다 왔습니다',2,'2023-01-26',NULL,'N','c:/java/upload/수영장.jpg',4),(4,'이종석','만족스러워요','룸서비스도 맛있네요',2,'2023-01-26',NULL,'N','c:/java/upload/음식.jpg',5),(5,'김혜수','스위트 시설이 좋네요','침구가 푹신해서 구매 하고 싶어요 어디거예요?',0,'2023-01-26',NULL,'N','c:/java/upload/혜수님.jpg',5),(6,'소윤','제주 느낌 물씬','식사도 제주 느낌 물씬 났으면 좋겠어요',0,'2023-01-26',NULL,'N','c:/java/upload/로비.jpg',2),(7,'메뚜기','아이가 너무 좋아했습니다','안녕하세요 유재석입니다^^ 지호, 나은이가 즐거워했어요 ~ 감사합니다~^^',6,'2023-01-26','2023-01-26','N','c:/java/upload/아이방.jpg',5),(8,'이동욱','최고의 호텔!','최고의 호텔에서 제공하는 최고의 패키지였음',2,'2023-01-26',NULL,'N','c:/java/upload/고급진사진.jpg',5),(9,'아이유','엄마랑 호캉스 만족스럽습니다','특히 수영장을 맘에 들어하셨어요',4,'2023-01-26',NULL,'N','c:/java/upload/수영장2.jpg',5),(10,'박보검','뷰가 좋아요 *^^*~ 감사합니다~','친구들이랑 재밌게 놀다 왔습니다~ ㅎㅎ 감사합니다.^^.',4,'2023-01-26',NULL,'N','c:/java/upload/오션뷰.jpg',5),(11,'김태우','직원이 불친절함','세미나실 이용했는데 직원이 융통성 없었음',1,'2023-01-26',NULL,'N',NULL,1),(12,'송지효','디너가 맛있어요','셰프님이 직접 하시던데 맛있어요^^ 잘 먹었습니다',0,'2023-01-26',NULL,'N','c:/java/upload/디너.jpg',4),(13,'하하','추천 받고 다녀옴','양가 식구들 전부 만족했어요. 감사합니다!',6,'2023-01-26',NULL,'N','c:/java/upload/가족룸.jpg',5),(14,'한소희','좋아요~','할머니 여행 보내드렸는데, 너무 편하게 잘 쉬고 오셨다고 해서 안심되었어요~~\r\n다음엔 온 가족 출동 예정',0,'2023-01-26',NULL,'N','c:/java/upload/앤틱방.jpg',5),(15,'도민준','야경 보기 좋습니다.','다만 서울에 있어서 별이 잘 보이지는 않네요.',0,'2023-01-26',NULL,'N','c:/java/upload/야경.jpg',3),(16,'이효리','제주 최고의 호텔!','시댁 어르신들과 함께 갔다 왔습니다.\r\n친절한 서비스 완전 만족!',102,'2023-01-26',NULL,'N','c:/java/upload/시댁.jpg',4);
/*!40000 ALTER TABLE `t_review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-26 14:46:18
