-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: japanese
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

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
-- Table structure for table `kotoba`
--

DROP TABLE IF EXISTS `kotoba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kotoba` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `jp` varchar(45) DEFAULT NULL,
  `vn` varchar(45) DEFAULT NULL,
  `en` varchar(45) DEFAULT NULL,
  `typeword` int(11) DEFAULT NULL,
  `lesson` int(11) DEFAULT NULL,
  `ignoreword` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `toType_idx` (`typeword`),
  CONSTRAINT `toType` FOREIGN KEY (`typeword`) REFERENCES `typeword` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kotoba`
--

LOCK TABLES `kotoba` WRITE;
/*!40000 ALTER TABLE `kotoba` DISABLE KEYS */;
INSERT INTO `kotoba` VALUES (2,'にほん','Nhật Bản','Japan',1,0,0),(3,'にほんじん','Người Nhật','Japanese',1,0,0),(34,'おうだんほどう','Vạch trắng băng qua đường',NULL,1,8,0),(35,'かど','Góc đường',NULL,1,8,0),(36,'さき','Lúc nảy',NULL,5,8,0),(37,'しんごう','Đèn giao thông',NULL,1,8,0),(38,'てまえ','Phía trước mặt',NULL,1,8,0),(39,'バスてい','Trạm xe buýt',NULL,1,8,0),(40,'ポスト','Thùng thư',NULL,1,8,0),(41,'ほどうきょう','Cầu vượt',NULL,1,8,0),(42,'マンション','Chung cư',NULL,1,8,0),(43,'ゆうびんきょく','Bưu điện',NULL,1,8,0),(44,'あそこ','Ở đằng kia',NULL,5,8,0),(45,'いそぎます','Khẩn cấp / Vội vàng',NULL,2,8,0),(46,'とめます','Dừng',NULL,2,8,0),(47,'まがります','Rẽ / Quẹo',NULL,2,8,0),(48,'まっすぐ','Thẳng',NULL,1,8,0),(49,'おかし','Bánh kẹo',NULL,1,8,0),(50,'おちゃ','trà',NULL,1,8,0),(51,'こうちゃ','Trà / hồng trà',NULL,1,8,0),(52,'オレンジジュース','nước cam',NULL,1,8,0),(53,'ざっし','tạp chí',NULL,1,8,0),(54,'カタログ','catalogue ',NULL,1,8,0),(55,'パンフレット','file quảng cáo',NULL,1,8,0),(56,'だいどころ','bếp',NULL,1,8,0),(57,'ソファー','ghế sofa',NULL,1,8,0),(58,'たばこ','thuốc lá',NULL,1,8,0),(59,'テレビゲーム','trò chơi điện tử',NULL,1,8,0),(60,'にもつ','hành lý',NULL,1,8,0),(61,'やります','chơi (game)',NULL,2,8,0),(62,'やさしい','Dễ / hiền lành',NULL,3,8,0),(63,'いただきます','xin phép được dùng bữa',NULL,5,8,0),(64,'いらっしゃい','chào đón',NULL,5,8,0),(65,'おじゃまします','xin lỗi đã làm phiền',NULL,5,8,0),(66,'ええ、まあ','vâng',NULL,5,8,0),(67,'もう１ぼいいかがですか','bạn dùng 1 ly nữa nhé',NULL,5,8,0),(68,'けっこうです','đủ rồi',NULL,5,8,0),(69,'こちらにどうぞ','xin mời đi lối này',NULL,5,8,0),(70,'～はい・ばい・ぱい','~ly',NULL,6,8,0),(71,'つがいます','Đặt / để','',2,8,0),(72,'キャベツ','bắp cải',NULL,1,8,0),(73,'じゃがいも','khoai tây',NULL,1,8,0),(74,'たまねぎ','củ hành',NULL,1,8,0),(75,'トマト','cà chua',NULL,1,8,0),(76,'にら','cây hẹ',NULL,1,8,0),(77,'やさい','rau',NULL,1,8,0),(78,'サラダ','rau trộn',NULL,1,8,0),(79,'りんご','quả táo',NULL,1,8,0),(80,'くだもの','trái cây',NULL,1,8,0),(81,'ジュース','nước ép trái cây',NULL,1,8,0),(82,'のみもの','thức uống',NULL,1,8,0),(83,'ぎょうざ','há cảo',NULL,1,8,0),(84,'かわ','vỏ',NULL,1,8,0),(85,'ぎょうざのかわ','vỏ bánh há cảo',NULL,5,8,0),(86,'スプーン','cái muỗng / cái thìa',NULL,1,8,0),(87,'フォーク','cái nĩa',NULL,1,8,0),(88,'ナイフ','con dao',NULL,1,8,0),(89,'テーブル','cái bàn',NULL,1,8,0),(90,'はんぼん','phân nửa',NULL,1,8,0),(91,'しゅんび','chuẩn bị',NULL,1,8,0),(92,'あらいます','Rửa / giặt giũ / tẩy',NULL,2,8,0),(93,'きります','cắt',NULL,2,8,0),(94,'てつだいます','giúp đỡ',NULL,2,8,0),(95,'ならべます','sắp xếp',NULL,2,8,0),(96,'はこびます','vận chuyển',NULL,2,8,0),(97,'むきます','Bóc / gọt / lột',NULL,2,8,0),(98,'かってきます','mua về',NULL,2,8,0),(99,'～つ','~ cái',NULL,6,8,0),(100,'～こ','~ cái / chiếc',NULL,6,8,0),(101,'～ほん・','~ chai',NULL,6,8,0),(102,'おにいさん','anh trai (người khác)',NULL,1,8,0),(103,'おとうとさん','em trai (người khác)',NULL,1,8,0),(104,'かれ','anh ấy',NULL,1,8,0),(105,'ギター','đàn ghita',NULL,1,8,0),(106,'けいだい','điện thoại di động',NULL,1,8,0),(107,'Ｔ－シャツ','áo thun',NULL,1,8,0),(108,'ポロシャツ','áo thun có cổ',NULL,1,8,0),(109,'フイシャツ','áo sơ mi dài tay',NULL,1,8,0),(110,'しま','hòn đảo',NULL,1,8,0),(111,'チェック','kiểm tra',NULL,1,8,0),(112,'ふく','quần áo',NULL,1,8,0),(113,'スカーフ','khăn choàng cổ',NULL,1,8,0),(114,'ネックレス','dây chuyền',NULL,1,8,0),(115,'イヤリング','bông tay',NULL,1,8,0),(116,'めがね','mắt kiếng',NULL,1,8,0),(117,'だいがく','đại học',NULL,1,8,0),(118,'だいがくせい','sinh viên đại học',NULL,1,8,0),(119,'かけます','Treo / đựng',NULL,2,8,0),(120,'かぶります','đội',NULL,2,8,0),(121,'きます','mặc',NULL,2,8,0),(122,'します','thắt cà vạt',NULL,2,8,0),(123,'はきます','mang',NULL,2,8,0),(124,'しょうかいします','giới thiệu',NULL,2,8,0),(125,'はなします','nói ',NULL,2,8,0),(126,'ひきます','chơi (đàn ghita)',NULL,2,8,0),(127,'あおい','sắc xanh',NULL,3,8,0),(128,'あかい','sắc đỏ',NULL,3,8,0),(129,'きいろい','sắc vàng',NULL,3,8,0),(130,'くろい','sắc đen',NULL,3,8,0),(131,'かわいい','Dễ thương','',3,8,0),(132,'おとうさん','cha (người khác)',NULL,1,9,0),(133,'おかあさん','mẹ người khác',NULL,1,9,0),(134,'おねえさん','chị người khác ',NULL,1,9,0),(135,'いもうとさん','em gái người khác',NULL,1,9,0),(136,'ごりょうしん','cha mẹ',NULL,1,9,0),(137,'ごきょうだい','anh em',NULL,1,9,0),(138,'うえのあに','anh cả',NULL,1,9,0),(139,'したのあに','anh thứ',NULL,1,9,0),(140,'ごしゅじん','chồng người khác',NULL,1,9,0),(141,'おくさん','vợ người khác',NULL,1,9,0),(142,'せんぎょうしゅふ','nội trợ',NULL,1,9,0),(143,'しごと','công việc',NULL,1,9,0),(144,'きょうし','giáo viên',NULL,1,9,0),(145,'けいさつかん','cảnh sát',NULL,1,9,0),(146,'しょうがっこう','trường tiểu học',NULL,1,9,0),(147,'しょうがくせい','học sinh tiểu học',NULL,1,9,0),(148,'ちゅうがくさんねんせい','Lớp 8',NULL,1,9,0),(149,'いしゃ','bác sĩ',NULL,1,9,0),(150,'ないか','nội khoa',NULL,1,9,0),(151,'ぼえきがいしゃ','công ty thương mại',NULL,1,9,0),(152,'こうじょう','nhà máy / xưởng',NULL,1,9,0),(153,'たいしょくします','nghỉ việc',NULL,2,9,0),(154,'すんでいます','đang cư trú / sinh sống ở',NULL,2,9,0),(155,'つとめています','đang làm việc',NULL,2,9,0),(156,'はたらいています','đang làm việc',NULL,2,9,0),(157,'やっています','đang làm ',NULL,2,9,0),(158,'まだ','vẫn còn ',NULL,5,9,0),(159,'いとりずつ','từng người',NULL,1,9,0),(160,'ふたりとも','Cả 2 người',NULL,1,9,0),(161,'ふたりで','2 người',NULL,1,9,0),(162,'のんびりしています','thảnh thơi / thoải mái / thư giản',NULL,5,9,0),(163,'ばんとう','cơm hộp',NULL,1,9,0),(164,'べんとうや','tiệm bán cơm hộp',NULL,1,9,0),(165,'じぎょう','tiền lương trả theo giờ',NULL,1,9,0),(166,'しゅうにむっか','một tuần 3 ngày',NULL,1,9,0),(167,'しんぶん','báo',NULL,1,9,0),(168,'しょるい','chủng loại',NULL,3,9,0),(169,'けいり','kế toán',NULL,1,9,0),(170,'せいり','chỉnh đốn',NULL,1,9,0),(171,'ソフト','phần mềm',NULL,1,9,0),(172,'タイりょうり','món ăn Thái',NULL,1,9,0),(173,'ダンス','khiêu vũ',NULL,1,9,0),(174,'ステージ','sân khấu',NULL,1,9,0),(175,'ゆうがた','buổi chiều',NULL,1,9,0),(176,'よなか','buổi tối',NULL,1,9,0),(177,'うちます','đánh',NULL,2,9,0),(178,'おしえます','chỉ dạy / chỉ dẫn',NULL,2,9,0),(179,'くぼります','phân phát',NULL,2,9,0),(180,'さがします','tìm kiếm',NULL,2,9,0),(181,'おかね','tiền',NULL,1,9,0),(182,'だいこくじん','người nước ngoài',NULL,1,9,0),(183,'ぎゅうにく','thịt bò',NULL,1,9,0),(184,'すきやき','lẩu sukiyaki',NULL,1,9,0),(185,'しゃぶしゃぶ','lẩu shabishabu',NULL,1,9,0),(186,'けんどう','kiếm đạo',NULL,1,9,0),(187,'じゅうどう','võ Judo',NULL,1,9,0),(188,'たなばた','ngày Ngưu Lang, Chức Nữ',NULL,1,9,0),(189,'ノートパソコン','máy tính xách tay',NULL,1,9,0),(190,'でんしじしょ','kim từ điển',NULL,1,9,0),(191,'ディーブィディーレーダー','máy ghi DVD',NULL,1,9,0),(192,'ひとりくらし','sống một mình',NULL,1,9,0),(193,'ペット','con vật nuôi',NULL,1,9,0),(194,'こうよう','cây lá đỏ',NULL,1,9,0),(195,'きのう','kỹ năng',NULL,1,9,0),(196,'さいきん','gần đây',NULL,4,9,0),(197,'ほか','ngoài ra',NULL,4,9,0),(198,'もの','đồ vật',NULL,1,9,0),(199,'さびしい','buồn',NULL,3,9,0),(200,'はしい','muốn ',NULL,3,9,0),(201,'すき','thích',NULL,3,9,0),(202,'たとえば','ví dụ',NULL,4,9,0),(203,'ファッション','thời trang',NULL,1,9,0),(204,'アバレル','trang phục',NULL,1,9,0),(205,'じぶん','tự mình',NULL,1,9,0),(206,'こめ','gạo',NULL,1,9,0),(207,'のうぎょう','nông nghiệp',NULL,1,9,0),(208,'ぶんか','văn hóa',NULL,1,9,0),(209,'こども','trẻ em',NULL,1,9,0),(210,'ようちえん','trường mẫu giáo',NULL,1,9,0),(211,'りょこうガイド','hướng dẫn viên du lịch',NULL,1,9,0),(212,'つうやく','thông dịch',NULL,1,9,0),(213,'りゆう','lý do',NULL,1,9,0),(214,'しょうらい','tương lai',NULL,1,9,0),(215,'がんばります','cố gắng ',NULL,2,9,0),(216,'はたらきます','làm việc',NULL,2,9,0),(217,'いっしょうけんめい','hết sức cố gắng',NULL,1,9,0),(218,'おもっています','đang suy nghĩ',NULL,2,9,0),(219,'～かんけい','liên quan ',NULL,6,9,0),(220,'コンピューターかんけい','(liên quan đến máy vi tính)',NULL,5,9,0),(221,'きまっていません','vẫn chưa quyết định',NULL,2,9,0),(222,'きょみがあります','có hứng thú',NULL,2,9,0);
/*!40000 ALTER TABLE `kotoba` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-03 17:13:12
