-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: ecovidrio_export
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ecovidrio_export`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ecovidrio_export` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ecovidrio_export`;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_ciudad` varchar(100) DEFAULT NULL,
  `departamento_id` int(11) DEFAULT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`id`),
  KEY `fk_departamento_ciudad` (`departamento_id`),
  CONSTRAINT `fk_departamento_ciudad` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=548 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (6,'Leticia',6,'HABILITADO'),(7,'Puerto Nariño',6,'HABILITADO'),(8,'Medellín',7,'HABILITADO'),(9,'Abejorral',7,'HABILITADO'),(10,'Abriaquí',7,'HABILITADO'),(11,'Alejandría',7,'HABILITADO'),(12,'Amagá',7,'HABILITADO'),(13,'Amalfi',7,'HABILITADO'),(14,'Andes',7,'HABILITADO'),(15,'Angelópolis',7,'HABILITADO'),(16,'Angostura',7,'HABILITADO'),(17,'Anorí',7,'HABILITADO'),(18,'Anzá',7,'HABILITADO'),(19,'Apartadó',7,'HABILITADO'),(20,'Arboletes',7,'HABILITADO'),(21,'Argelia',7,'HABILITADO'),(22,'Armenia',7,'HABILITADO'),(23,'Barbosa',7,'HABILITADO'),(24,'Bello',7,'HABILITADO'),(25,'Belmira',7,'HABILITADO'),(26,'Betania',7,'HABILITADO'),(27,'Betulia',7,'HABILITADO'),(28,'Briceño',7,'HABILITADO'),(29,'Buriticá',7,'HABILITADO'),(30,'Cáceres',7,'HABILITADO'),(31,'Caicedo',7,'HABILITADO'),(32,'Caldas',7,'HABILITADO'),(33,'Campamento',7,'HABILITADO'),(34,'Cañasgordas',7,'HABILITADO'),(35,'Caracolí',7,'HABILITADO'),(36,'Caramanta',7,'HABILITADO'),(37,'Carepa',7,'HABILITADO'),(38,'Carolina del Príncipe',7,'HABILITADO'),(39,'Caucasia',7,'HABILITADO'),(40,'Chigorodó',7,'HABILITADO'),(41,'Cisneros',7,'HABILITADO'),(42,'Cocorná',7,'HABILITADO'),(43,'Concepción',7,'HABILITADO'),(44,'Concordia',7,'HABILITADO'),(45,'Copacabana',7,'HABILITADO'),(46,'Dabeiba',7,'HABILITADO'),(47,'Donmatías',7,'HABILITADO'),(48,'Ebéjico',7,'HABILITADO'),(49,'El Bagre',7,'HABILITADO'),(50,'Entrerríos',7,'HABILITADO'),(51,'Envigado',7,'HABILITADO'),(52,'Fredonia',7,'HABILITADO'),(53,'Frontino',7,'HABILITADO'),(54,'Giraldo',7,'HABILITADO'),(55,'Girardota',7,'HABILITADO'),(56,'Gómez Plata',7,'HABILITADO'),(57,'Granada',7,'HABILITADO'),(58,'Guadalupe',7,'HABILITADO'),(59,'Guarne',7,'HABILITADO'),(60,'Guatapé',7,'HABILITADO'),(61,'Heliconia',7,'HABILITADO'),(62,'Hispania',7,'HABILITADO'),(63,'Itagüí',7,'HABILITADO'),(64,'Ituango',7,'HABILITADO'),(65,'Jardín',7,'HABILITADO'),(66,'Jericó',7,'HABILITADO'),(67,'La Ceja',7,'HABILITADO'),(68,'La Estrella',7,'HABILITADO'),(69,'La Pintada',7,'HABILITADO'),(70,'La Unión',7,'HABILITADO'),(71,'Liborina',7,'HABILITADO'),(72,'Maceo',7,'HABILITADO'),(73,'Marinilla',7,'HABILITADO'),(74,'Montebello',7,'HABILITADO'),(75,'Murindó',7,'HABILITADO'),(76,'Mutatá',7,'HABILITADO'),(77,'Nariño',7,'HABILITADO'),(78,'Nechí',7,'HABILITADO'),(79,'Necoclí',7,'HABILITADO'),(80,'Olaya',7,'HABILITADO'),(81,'Peñol',7,'HABILITADO'),(82,'Peque',7,'HABILITADO'),(83,'Pueblorrico',7,'HABILITADO'),(84,'Puerto Berrío',7,'HABILITADO'),(85,'Puerto Nare',7,'HABILITADO'),(86,'Puerto Triunfo',7,'HABILITADO'),(87,'Remedios',7,'HABILITADO'),(88,'Retiro',7,'HABILITADO'),(89,'Rionegro',7,'HABILITADO'),(90,'Sabanalarga',7,'HABILITADO'),(91,'Sabaneta',7,'HABILITADO'),(92,'Salgar',7,'HABILITADO'),(93,'San Andrés de Cuerquia',7,'HABILITADO'),(94,'San Carlos',7,'HABILITADO'),(95,'San Francisco',7,'HABILITADO'),(96,'San Jerónimo',7,'HABILITADO'),(97,'San José de la Montaña',7,'HABILITADO'),(98,'San Juan de Urabá',7,'HABILITADO'),(99,'San Luis',7,'HABILITADO'),(100,'San Pedro de los Milagros',7,'HABILITADO'),(101,'San Pedro de Urabá',7,'HABILITADO'),(102,'San Rafael',7,'HABILITADO'),(103,'San Roque',7,'HABILITADO'),(104,'San Vicente',7,'HABILITADO'),(105,'Santa Bárbara',7,'HABILITADO'),(106,'Santa Fé de Antioquia',7,'HABILITADO'),(107,'Santa Rosa de Osos',7,'HABILITADO'),(108,'Santo Domingo',7,'HABILITADO'),(109,'Segovia',7,'HABILITADO'),(110,'Sonsón',7,'HABILITADO'),(111,'Sopetrán',7,'HABILITADO'),(112,'Támesis',7,'HABILITADO'),(113,'Tarazá',7,'HABILITADO'),(114,'Tarso',7,'HABILITADO'),(115,'Titiribí',7,'HABILITADO'),(116,'Toledo',7,'HABILITADO'),(117,'Turbo',7,'HABILITADO'),(118,'Uramita',7,'HABILITADO'),(119,'Urrao',7,'HABILITADO'),(120,'Valdivia',7,'HABILITADO'),(121,'Valparaíso',7,'HABILITADO'),(122,'Vegachí',7,'HABILITADO'),(123,'Venecia',7,'HABILITADO'),(124,'Vigía del Fuerte',7,'HABILITADO'),(125,'Yalí',7,'HABILITADO'),(126,'Yarumal',7,'HABILITADO'),(127,'Yolombó',7,'HABILITADO'),(128,'Yondó',7,'HABILITADO'),(129,'Zaragoza',7,'HABILITADO'),(130,'Arauca',8,'HABILITADO'),(131,'Arauquita',8,'HABILITADO'),(132,'Cravo Norte',8,'HABILITADO'),(133,'Fortul',8,'HABILITADO'),(134,'Puerto Rondón',8,'HABILITADO'),(135,'Saravena',8,'HABILITADO'),(136,'Tame',8,'HABILITADO'),(137,'Barranquilla',9,'HABILITADO'),(138,'Baranoa',9,'HABILITADO'),(139,'Campo de la Cruz',9,'HABILITADO'),(140,'Candelaria',9,'HABILITADO'),(141,'Galapa',9,'HABILITADO'),(142,'Juan de Acosta',9,'HABILITADO'),(143,'Luruaco',9,'HABILITADO'),(144,'Malambo',9,'HABILITADO'),(145,'Manatí',9,'HABILITADO'),(146,'Palmar de Varela',9,'HABILITADO'),(147,'Piojó',9,'HABILITADO'),(148,'Polonuevo',9,'HABILITADO'),(149,'Ponedera',9,'HABILITADO'),(150,'Puerto Colombia',9,'HABILITADO'),(151,'Repelón',9,'HABILITADO'),(152,'Sabanagrande',9,'HABILITADO'),(153,'Sabanalarga',9,'HABILITADO'),(154,'Santa Lucía',9,'HABILITADO'),(155,'Santo Tomás',9,'HABILITADO'),(156,'Soledad',9,'HABILITADO'),(157,'Suan',9,'HABILITADO'),(158,'Tubará',9,'HABILITADO'),(159,'Usiacurí',9,'HABILITADO'),(160,'Cartagena',10,'HABILITADO'),(161,'Magangué',10,'HABILITADO'),(162,'Sincelejo',10,'HABILITADO'),(163,'Turbo',10,'HABILITADO'),(164,'El Carmen de Bolívar',10,'HABILITADO'),(165,'Córdoba',10,'HABILITADO'),(166,'Arjona',10,'HABILITADO'),(167,'Boluviá',10,'HABILITADO'),(168,'Margarita',10,'HABILITADO'),(169,'San Juan Nepomuceno',10,'HABILITADO'),(170,'Turbaco',10,'HABILITADO'),(171,'Tiquisio',10,'HABILITADO'),(172,'Santa Rosa',10,'HABILITADO'),(173,'Simití',10,'HABILITADO'),(174,'Carmen de Bolívar',10,'HABILITADO'),(175,'Mompox',10,'HABILITADO'),(176,'Tunja',11,'HABILITADO'),(177,'Duitama',11,'HABILITADO'),(178,'Sogamoso',11,'HABILITADO'),(179,'Chiquinquirá',11,'HABILITADO'),(180,'Paipa',11,'HABILITADO'),(181,'Samacá',11,'HABILITADO'),(182,'Tibasosa',11,'HABILITADO'),(183,'Monguí',11,'HABILITADO'),(184,'Villa de Leyva',11,'HABILITADO'),(185,'Puerto Boyacá',11,'HABILITADO'),(186,'Tuta',11,'HABILITADO'),(187,'Ráquira',11,'HABILITADO'),(188,'Nobsa',11,'HABILITADO'),(189,'Gámeza',11,'HABILITADO'),(190,'Cómbita',11,'HABILITADO'),(191,'Chiquinquirá',11,'HABILITADO'),(192,'San Pablo de Borbur',11,'HABILITADO'),(193,'Coper',11,'HABILITADO'),(194,'Saboyá',11,'HABILITADO'),(195,'Manizales',12,'HABILITADO'),(196,'Villamaría',12,'HABILITADO'),(197,'Chinchiná',12,'HABILITADO'),(198,'Neira',12,'HABILITADO'),(199,'Palestina',12,'HABILITADO'),(200,'Los Anegados',12,'HABILITADO'),(201,'Anserma',12,'HABILITADO'),(202,'Riosucio',12,'HABILITADO'),(203,'Salamina',12,'HABILITADO'),(204,'San Felix',12,'HABILITADO'),(205,'Samaná',12,'HABILITADO'),(206,'La Dorada',12,'HABILITADO'),(207,'Manzanares',12,'HABILITADO'),(208,'Marquetalia',12,'HABILITADO'),(209,'Marmato',12,'HABILITADO'),(210,'Viterbo',12,'HABILITADO'),(211,'Caldas',12,'HABILITADO'),(212,'Florencia',13,'HABILITADO'),(213,'El Paujil',13,'HABILITADO'),(214,'La Montañita',13,'HABILITADO'),(215,'Morelia',13,'HABILITADO'),(216,'San Vicente del Caguán',13,'HABILITADO'),(217,'Valparaíso',13,'HABILITADO'),(218,'Puerto Rico',13,'HABILITADO'),(219,'Belén de los Andaquies',13,'HABILITADO'),(220,'Solita',13,'HABILITADO'),(221,'Los Cauchos',13,'HABILITADO'),(222,'San José del Fragua',13,'HABILITADO'),(223,'La Uribe',13,'HABILITADO'),(224,'Albania',13,'HABILITADO'),(225,'Sanjosé del Fragua',13,'HABILITADO'),(226,'San Antonio de Getuchá',13,'HABILITADO'),(227,'La Perdiz',13,'HABILITADO'),(228,'Yopal',14,'HABILITADO'),(229,'Aguazul',14,'HABILITADO'),(230,'Támara',14,'HABILITADO'),(231,'Hato Corozal',14,'HABILITADO'),(232,'Nunchía',14,'HABILITADO'),(233,'Paz de Ariporo',14,'HABILITADO'),(234,'La Salina',14,'HABILITADO'),(235,'Maní',14,'HABILITADO'),(236,'Recetor',14,'HABILITADO'),(237,'San Luis de Palenque',14,'HABILITADO'),(238,'Sabanalarga',14,'HABILITADO'),(239,'Chámeza',14,'HABILITADO'),(240,'Pueblo Nuevo',14,'HABILITADO'),(241,'Agua Azul',14,'HABILITADO'),(242,'Tauramena',14,'HABILITADO'),(243,'Popayán',15,'HABILITADO'),(244,'Caldas',15,'HABILITADO'),(245,'Santander de Quilichao',15,'HABILITADO'),(246,'Puerto Tejada',15,'HABILITADO'),(247,'El Tambo',15,'HABILITADO'),(248,'La Sierra',15,'HABILITADO'),(249,'Piamonte',15,'HABILITADO'),(250,'Guapi',15,'HABILITADO'),(251,'Bolívar',15,'HABILITADO'),(252,'Morales',15,'HABILITADO'),(253,'Almaguer',15,'HABILITADO'),(254,'Timbío',15,'HABILITADO'),(255,'Patía',15,'HABILITADO'),(256,'Inzá',15,'HABILITADO'),(257,'Paez',15,'HABILITADO'),(258,'Jambaló',15,'HABILITADO'),(259,'Argelia',15,'HABILITADO'),(260,'La Vega',15,'HABILITADO'),(261,'Puracé',15,'HABILITADO'),(262,'Valledupar',16,'HABILITADO'),(263,'Aguachica',16,'HABILITADO'),(264,'La Paz',16,'HABILITADO'),(265,'Bosconia',16,'HABILITADO'),(266,'San Alberto',16,'HABILITADO'),(267,'Gamarra',16,'HABILITADO'),(268,'El Copey',16,'HABILITADO'),(269,'Pueblo Bello',16,'HABILITADO'),(270,'Curumaní',16,'HABILITADO'),(271,'Chimichagua',16,'HABILITADO'),(272,'Manaure Balcón del Cesar',16,'HABILITADO'),(273,'San Diego',16,'HABILITADO'),(274,'Codazzi',16,'HABILITADO'),(275,'Agustín Codazzi',16,'HABILITADO'),(276,'La Jagua de Ibirico',16,'HABILITADO'),(277,'Tamalameque',16,'HABILITADO'),(278,'Quibdó',17,'HABILITADO'),(279,'Acandí',17,'HABILITADO'),(280,'Bagadó',17,'HABILITADO'),(281,'Bajo Baudó',17,'HABILITADO'),(282,'Bojayá',17,'HABILITADO'),(283,'Cértegui',17,'HABILITADO'),(284,'Condoto',17,'HABILITADO'),(285,'El Carmen de Atrato',17,'HABILITADO'),(286,'El Litoral del San Juan',17,'HABILITADO'),(287,'Istmina',17,'HABILITADO'),(288,'Juradó',17,'HABILITADO'),(289,'Lloró',17,'HABILITADO'),(290,'Medio Atrato',17,'HABILITADO'),(291,'Medio San Juan',17,'HABILITADO'),(292,'Riosucio',17,'HABILITADO'),(293,'San José del Palmar',17,'HABILITADO'),(294,'Sipi',17,'HABILITADO'),(295,'Tadó',17,'HABILITADO'),(296,'Ungía',17,'HABILITADO'),(297,'Montería',18,'HABILITADO'),(298,'Cereté',18,'HABILITADO'),(299,'Lorica',18,'HABILITADO'),(300,'Planeta Rica',18,'HABILITADO'),(301,'Sahagún',18,'HABILITADO'),(302,'Ciénaga de Oro',18,'HABILITADO'),(303,'Puerto Escondido',18,'HABILITADO'),(304,'Tuchín',18,'HABILITADO'),(305,'Tierralta',18,'HABILITADO'),(306,'San Pelayo',18,'HABILITADO'),(307,'Montelíbano',18,'HABILITADO'),(308,'Cotorra',18,'HABILITADO'),(309,'Valencia',18,'HABILITADO'),(310,'Ayapel',18,'HABILITADO'),(311,'Los Córdobas',18,'HABILITADO'),(312,'La Apartada',18,'HABILITADO'),(313,'Bogotá',19,'HABILITADO'),(314,'Soacha',19,'HABILITADO'),(315,'Chocontá',19,'HABILITADO'),(316,'Cota',19,'HABILITADO'),(317,'La Calera',19,'HABILITADO'),(318,'Sibaté',19,'HABILITADO'),(319,'Mosquera',19,'HABILITADO'),(320,'Funza',19,'HABILITADO'),(321,'Cajicá',19,'HABILITADO'),(322,'Zipaquirá',19,'HABILITADO'),(323,'Chocontá',19,'HABILITADO'),(324,'Tenjo',19,'HABILITADO'),(325,'Tabio',19,'HABILITADO'),(326,'Girardot',19,'HABILITADO'),(327,'El Rosal',19,'HABILITADO'),(328,'Cucunubá',19,'HABILITADO'),(329,'San Antonio del Tequendama',19,'HABILITADO'),(330,'La Mesa',19,'HABILITADO'),(331,'Villeta',19,'HABILITADO'),(332,'Tocancipá',19,'HABILITADO'),(333,'Cota',19,'HABILITADO'),(334,'Sopó',19,'HABILITADO'),(335,'Subachoque',19,'HABILITADO'),(336,'Carmen de Carupa',19,'HABILITADO'),(337,'Inírida',20,'HABILITADO'),(338,'Barranco Minas',20,'HABILITADO'),(339,'Cacahual',20,'HABILITADO'),(340,'La Guadalupe',20,'HABILITADO'),(341,'Pana Pana',20,'HABILITADO'),(342,'San Felipe',20,'HABILITADO'),(343,'La Unión',20,'HABILITADO'),(344,'Puerto Inírida',20,'HABILITADO'),(345,'San José del Guaviare',21,'HABILITADO'),(346,'El Retorno',21,'HABILITADO'),(347,'Miraflores',21,'HABILITADO'),(348,'Calamar',21,'HABILITADO'),(349,'La Primavera',21,'HABILITADO'),(350,'Puerto Inírida',21,'HABILITADO'),(351,'Neiva',22,'HABILITADO'),(352,'Pitalito',22,'HABILITADO'),(353,'La Plata',22,'HABILITADO'),(354,'Garzón',22,'HABILITADO'),(355,'Campoalegre',22,'HABILITADO'),(356,'Altamira',22,'HABILITADO'),(357,'Isnos',22,'HABILITADO'),(358,'Rivera',22,'HABILITADO'),(359,'Elías',22,'HABILITADO'),(360,'Tello',22,'HABILITADO'),(361,'Hobo',22,'HABILITADO'),(362,'Teruel',22,'HABILITADO'),(363,'Aipe',22,'HABILITADO'),(364,'Saladoblanco',22,'HABILITADO'),(365,'Suaza',22,'HABILITADO'),(366,'Riohacha',23,'HABILITADO'),(367,'Maicao',23,'HABILITADO'),(368,'Fonseca',23,'HABILITADO'),(369,'Distracción',23,'HABILITADO'),(370,'Hatonuevo',23,'HABILITADO'),(371,'San Juan del Cesar',23,'HABILITADO'),(372,'Villanueva',23,'HABILITADO'),(373,'Barrancas',23,'HABILITADO'),(374,'La Jagua del Pilar',23,'HABILITADO'),(375,'Uribia',23,'HABILITADO'),(376,'Palomino',23,'HABILITADO'),(377,'El Molino',23,'HABILITADO'),(378,'Dibulla',23,'HABILITADO'),(379,'Caminos del Indio',23,'HABILITADO'),(380,'Los Horcones',23,'HABILITADO'),(381,'Santa Marta',24,'HABILITADO'),(382,'Ciénaga',24,'HABILITADO'),(383,'Fundación',24,'HABILITADO'),(384,'El Banco',24,'HABILITADO'),(385,'Pivijay',24,'HABILITADO'),(386,'Aracataca',24,'HABILITADO'),(387,'Salamina',24,'HABILITADO'),(388,'Guamal',24,'HABILITADO'),(389,'Sitio Nuevo',24,'HABILITADO'),(390,'San Zenón',24,'HABILITADO'),(391,'Zona Bananera',24,'HABILITADO'),(392,'Plato',24,'HABILITADO'),(393,'Nueva Granada',24,'HABILITADO'),(394,'Tenerife',24,'HABILITADO'),(395,'Sitionuevo',24,'HABILITADO'),(396,'Villavicencio',25,'HABILITADO'),(397,'Acacías',25,'HABILITADO'),(398,'Cumaral',25,'HABILITADO'),(399,'Restrepo',25,'HABILITADO'),(400,'San Martín',25,'HABILITADO'),(401,'Puerto López',25,'HABILITADO'),(402,'Granada',25,'HABILITADO'),(403,'La Macarena',25,'HABILITADO'),(404,'Mesetas',25,'HABILITADO'),(405,'Uribe',25,'HABILITADO'),(406,'Vistahermosa',25,'HABILITADO'),(407,'Mapiripán',25,'HABILITADO'),(408,'El Castillo',25,'HABILITADO'),(409,'Barranca de Upía',25,'HABILITADO'),(410,'Fuente de Oro',25,'HABILITADO'),(411,'La Uribe',25,'HABILITADO'),(412,'Cumaral',25,'HABILITADO'),(413,'Pasto',26,'HABILITADO'),(414,'Ipiales',26,'HABILITADO'),(415,'Tumaco',26,'HABILITADO'),(416,'Pueblo Nuevo',26,'HABILITADO'),(417,'Cumbal',26,'HABILITADO'),(418,'Puerres',26,'HABILITADO'),(419,'El Tambo',26,'HABILITADO'),(420,'La Unión',26,'HABILITADO'),(421,'Buesaco',26,'HABILITADO'),(422,'Samaniego',26,'HABILITADO'),(423,'Consacá',26,'HABILITADO'),(424,'Yacuanquer',26,'HABILITADO'),(425,'Nariño',26,'HABILITADO'),(426,'Los Andes',26,'HABILITADO'),(427,'Francisco Pizarro',26,'HABILITADO'),(428,'Policarpa',26,'HABILITADO'),(429,'San Pablo',26,'HABILITADO'),(430,'La Florida',26,'HABILITADO'),(431,'Roberto Payán',26,'HABILITADO'),(433,'Pamplona',27,'HABILITADO'),(434,'Ocaña',27,'HABILITADO'),(435,'Los Patios',27,'HABILITADO'),(436,'Villa de Rosario',27,'HABILITADO'),(437,'Salazar de Las Palmas',27,'HABILITADO'),(438,'El Tarra',27,'HABILITADO'),(439,'Tibú',27,'HABILITADO'),(440,'La Esperanza',27,'HABILITADO'),(441,'Chinácota',27,'HABILITADO'),(442,'Ragonvalia',27,'HABILITADO'),(443,'San Cayetano',27,'HABILITADO'),(444,'Durania',27,'HABILITADO'),(445,'Hacarí',27,'HABILITADO'),(446,'La Playa de Belén',27,'HABILITADO'),(447,'Santiago',27,'HABILITADO'),(448,'San José de Cúcuta',27,'HABILITADO'),(449,'Mocoa',28,'HABILITADO'),(450,'Puerto Asís',28,'HABILITADO'),(451,'La Hormiga',28,'HABILITADO'),(452,'Orito',28,'HABILITADO'),(453,'Villagarzón',28,'HABILITADO'),(454,'San Francisco',28,'HABILITADO'),(455,'Santiago',28,'HABILITADO'),(456,'Puerto Caicedo',28,'HABILITADO'),(457,'El Tigre',28,'HABILITADO'),(458,'Yupiltepeque',28,'HABILITADO'),(459,'La Dorada',28,'HABILITADO'),(460,'Belen de los Andaquies',28,'HABILITADO'),(461,'Santiago',28,'HABILITADO'),(462,'Valle del Guamuez',28,'HABILITADO'),(463,'La Playa',28,'HABILITADO'),(464,'Armenia',29,'HABILITADO'),(465,'Calarcá',29,'HABILITADO'),(466,'La Tebaida',29,'HABILITADO'),(467,'Montenegro',29,'HABILITADO'),(468,'Quimbaya',29,'HABILITADO'),(469,'Salento',29,'HABILITADO'),(470,'Pijao',29,'HABILITADO'),(471,'Circasia',29,'HABILITADO'),(472,'Buenavista',29,'HABILITADO'),(473,'Córdoba',29,'HABILITADO'),(474,'Pereira',30,'HABILITADO'),(475,'Dosquebradas',30,'HABILITADO'),(476,'La Virginia',30,'HABILITADO'),(477,'Santa Rosa de Cabal',30,'HABILITADO'),(478,'Marsella',30,'HABILITADO'),(479,'Apía',30,'HABILITADO'),(480,'Belén de Umbría',30,'HABILITADO'),(481,'Balboa',30,'HABILITADO'),(482,'Guática',30,'HABILITADO'),(483,'Santuario',30,'HABILITADO'),(484,'San Andrés',31,'HABILITADO'),(485,'Providencia',31,'HABILITADO'),(486,'Bucaramanga',32,'HABILITADO'),(487,'Floridablanca',32,'HABILITADO'),(488,'Barrancabermeja',32,'HABILITADO'),(489,'Girón',32,'HABILITADO'),(490,'Piedecuesta',32,'HABILITADO'),(491,'San Gil',32,'HABILITADO'),(492,'Lebrija',32,'HABILITADO'),(493,'Barichara',32,'HABILITADO'),(494,'Málaga',32,'HABILITADO'),(495,'Duitama',32,'HABILITADO'),(496,'Sincelejo',33,'HABILITADO'),(497,'Corozal',33,'HABILITADO'),(498,'Sampués',33,'HABILITADO'),(499,'San Onofre',33,'HABILITADO'),(500,'Morroa',33,'HABILITADO'),(501,'Tolú',33,'HABILITADO'),(502,'Sucre',33,'HABILITADO'),(503,'Sincé',33,'HABILITADO'),(504,'Ovejas',33,'HABILITADO'),(505,'Caimito',33,'HABILITADO'),(506,'Ibagué',34,'HABILITADO'),(507,'Espinal',34,'HABILITADO'),(508,'Melgar',34,'HABILITADO'),(509,'El Espinal',34,'HABILITADO'),(510,'Honda',34,'HABILITADO'),(511,'Fresno',34,'HABILITADO'),(512,'Líbano',34,'HABILITADO'),(513,'Mariquita',34,'HABILITADO'),(514,'Cajamarca',34,'HABILITADO'),(515,'Piedras',34,'HABILITADO'),(516,'Saldaña',34,'HABILITADO'),(517,'San Antonio',34,'HABILITADO'),(518,'Chaparral',34,'HABILITADO'),(519,'Villarrica',34,'HABILITADO'),(520,'Tolima',34,'HABILITADO'),(521,'Cali',35,'HABILITADO'),(522,'Palmira',35,'HABILITADO'),(523,'Buenaventura',35,'HABILITADO'),(524,'Tuluá',35,'HABILITADO'),(525,'Buga',35,'HABILITADO'),(526,'Candelaria',35,'HABILITADO'),(527,'Cartago',35,'HABILITADO'),(528,'Dagua',35,'HABILITADO'),(529,'Yumbo',35,'HABILITADO'),(530,'Roldanillo',35,'HABILITADO'),(531,'Guacarí',35,'HABILITADO'),(532,'Zarzal',35,'HABILITADO'),(533,'El Cerrito',35,'HABILITADO'),(534,'La Unión',35,'HABILITADO'),(535,'Versalles',35,'HABILITADO'),(536,'Mitú',36,'HABILITADO'),(537,'Carurú',36,'HABILITADO'),(538,'Papunaua',36,'HABILITADO'),(539,'Taraira',36,'HABILITADO'),(540,'Pacoa',36,'HABILITADO'),(541,'Pizarro',36,'HABILITADO'),(542,'Puerto Carreño',37,'HABILITADO'),(543,'La Primavera',37,'HABILITADO'),(544,'Cumaribo',37,'HABILITADO'),(545,'Santa Rosalía',37,'HABILITADO'),(546,'El Troncal',37,'HABILITADO'),(547,'Cúcuta',27,'HABILITADO');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_departamento` varchar(100) NOT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (6,'Amazonas','HABILITADO'),(7,'Antioquia','HABILITADO'),(8,'Arauca','HABILITADO'),(9,'Atlántico','HABILITADO'),(10,'Bolívar','HABILITADO'),(11,'Boyacá','HABILITADO'),(12,'Caldas','HABILITADO'),(13,'Caquetá','HABILITADO'),(14,'Casanare','HABILITADO'),(15,'Cauca','HABILITADO'),(16,'Cesar','HABILITADO'),(17,'Chocó','HABILITADO'),(18,'Córdoba','HABILITADO'),(19,'Cundinamarca','HABILITADO'),(20,'Guainía','HABILITADO'),(21,'Guaviare','HABILITADO'),(22,'Huila','HABILITADO'),(23,'La Guajira','HABILITADO'),(24,'Magdalena','HABILITADO'),(25,'Meta','HABILITADO'),(26,'Nariño','HABILITADO'),(27,'Norte de Santander','HABILITADO'),(28,'Putumayo','HABILITADO'),(29,'Quindío','HABILITADO'),(30,'Risaralda','HABILITADO'),(31,'San Andrés, Providencia y Santa Catalina','HABILITADO'),(32,'Santander','HABILITADO'),(33,'Sucre','HABILITADO'),(34,'Tolima','HABILITADO'),(35,'Valle del Cauca','HABILITADO'),(36,'Vaupés','HABILITADO'),(37,'Vichada','HABILITADO');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_Direccion` varchar(100) NOT NULL,
  `ciudad_id` int(11) DEFAULT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`id`),
  KEY `fk_ciudad_direccion` (`ciudad_id`),
  CONSTRAINT `fk_ciudad_direccion` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (3,'Cra 32',47,'HABILITADO'),(4,'Cra 32 numero 25-16',8,'HABILITADO');
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operador`
--

DROP TABLE IF EXISTS `operador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operador` (
  `idoperario` int(11) DEFAULT NULL,
  `cedula` int(11) NOT NULL,
  `nombre1` varchar(50) NOT NULL,
  `nombre2` varchar(50) DEFAULT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(75) DEFAULT NULL,
  `correo_electronico` varchar(50) DEFAULT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operador`
--

LOCK TABLES `operador` WRITE;
/*!40000 ALTER TABLE `operador` DISABLE KEYS */;
INSERT INTO `operador` VALUES (NULL,12054,'Santiago','','Yepes','','3053382426','nbhbh','santiago@gmail.com','HABILITADO'),(NULL,1090466777,'Bryan','','Ayala','','3167861668','Cll xx','bryyandaniiel@gmail.com','HABILITADO');
/*!40000 ALTER TABLE `operador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado`
--

DROP TABLE IF EXISTS `resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resultado` (
  `idresultado` int(11) NOT NULL AUTO_INCREMENT,
  `idsensor` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `peso` decimal(10,2) NOT NULL,
  `alertas` varchar(255) DEFAULT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`idresultado`),
  KEY `idsensor` (`idsensor`),
  CONSTRAINT `resultado_ibfk_1` FOREIGN KEY (`idsensor`) REFERENCES `sensor` (`idsensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado`
--

LOCK TABLES `resultado` WRITE;
/*!40000 ALTER TABLE `resultado` DISABLE KEYS */;
/*!40000 ALTER TABLE `resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor` (
  `idsensor` int(11) NOT NULL AUTO_INCREMENT,
  `idtipo_sensor` int(11) NOT NULL,
  `fecha_inicial` date NOT NULL,
  `fecha_final` date NOT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`idsensor`),
  KEY `idtipo_sensor` (`idtipo_sensor`),
  CONSTRAINT `sensor_ibfk_1` FOREIGN KEY (`idtipo_sensor`) REFERENCES `tipo_sensor` (`idtipo_sensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_sensor`
--

DROP TABLE IF EXISTS `tipo_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_sensor` (
  `idtipo_sensor` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `capacidad` decimal(10,2) NOT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`idtipo_sensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_sensor`
--

LOCK TABLES `tipo_sensor` WRITE;
/*!40000 ALTER TABLE `tipo_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'operador','HABILITADO'),(2,'administrador','HABILITADO');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trituradora`
--

DROP TABLE IF EXISTS `trituradora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trituradora` (
  `id_trituradora` int(11) NOT NULL AUTO_INCREMENT,
  `idsensor` int(11) DEFAULT NULL,
  `descripcion` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion_id` int(11) DEFAULT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`id_trituradora`),
  KEY `idsensor` (`idsensor`),
  KEY `fk_trituradora_direccion` (`direccion_id`),
  CONSTRAINT `fk_trituradora_direccion` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`),
  CONSTRAINT `trituradora_ibfk_2` FOREIGN KEY (`idsensor`) REFERENCES `sensor` (`idsensor`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trituradora`
--

LOCK TABLES `trituradora` WRITE;
/*!40000 ALTER TABLE `trituradora` DISABLE KEYS */;
INSERT INTO `trituradora` VALUES (1,NULL,'Prototipo','TR1',NULL,'HABILITADO'),(7,NULL,'Prototipo','TR5',4,'HABILITADO');
/*!40000 ALTER TABLE `trituradora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `idturno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_salida` time NOT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`idturno`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'Dia','14:32:00','14:30:00','HABILITADO'),(2,'Noche','15:38:00','15:45:00','HABILITADO');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno_operario`
--

DROP TABLE IF EXISTS `turno_operario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno_operario` (
  `operador_cedula` int(11) DEFAULT NULL,
  `turno_nombre` int(11) DEFAULT NULL,
  `fecha` date DEFAULT curdate(),
  `id_operario` int(11) NOT NULL AUTO_INCREMENT,
  `id_trituradora` int(11) DEFAULT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`id_operario`),
  KEY `fk_turno_nombre` (`turno_nombre`),
  KEY `fk_operador_cedula` (`operador_cedula`),
  KEY `fk_trituradora_turno_operario` (`id_trituradora`),
  CONSTRAINT `fk_operador_cedula` FOREIGN KEY (`operador_cedula`) REFERENCES `operador` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trituradora_turno_operario` FOREIGN KEY (`id_trituradora`) REFERENCES `trituradora` (`id_trituradora`),
  CONSTRAINT `fk_turno_nombre` FOREIGN KEY (`turno_nombre`) REFERENCES `turno` (`idturno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno_operario`
--

LOCK TABLES `turno_operario` WRITE;
/*!40000 ALTER TABLE `turno_operario` DISABLE KEYS */;
INSERT INTO `turno_operario` VALUES (12054,1,NULL,8,1,'HABILITADO'),(1090466777,2,NULL,10,7,'HABILITADO');
/*!40000 ALTER TABLE `turno_operario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_usuario_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `estado` enum('HABILITADO','INHABILITADO') DEFAULT 'HABILITADO',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `idtipo_usuario` (`tipo_usuario_id`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`tipo_usuario_id`) REFERENCES `tipo_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'santiagogil7112@gmail.com','123','HABILITADO'),(14,1,'josegil7112@gmail.com','123','HABILITADO'),(15,2,'jose@gmail.com','123','HABILITADO'),(26,1,'bryyandaniiel@gmail.com','123','HABILITADO');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-27 23:28:57
