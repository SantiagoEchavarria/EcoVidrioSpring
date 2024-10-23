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
  PRIMARY KEY (`id`),
  KEY `fk_departamento_ciudad` (`departamento_id`),
  CONSTRAINT `fk_departamento_ciudad` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=547 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (6,'Leticia',6),(7,'Puerto Nariño',6),(8,'Medellín',7),(9,'Abejorral',7),(10,'Abriaquí',7),(11,'Alejandría',7),(12,'Amagá',7),(13,'Amalfi',7),(14,'Andes',7),(15,'Angelópolis',7),(16,'Angostura',7),(17,'Anorí',7),(18,'Anzá',7),(19,'Apartadó',7),(20,'Arboletes',7),(21,'Argelia',7),(22,'Armenia',7),(23,'Barbosa',7),(24,'Bello',7),(25,'Belmira',7),(26,'Betania',7),(27,'Betulia',7),(28,'Briceño',7),(29,'Buriticá',7),(30,'Cáceres',7),(31,'Caicedo',7),(32,'Caldas',7),(33,'Campamento',7),(34,'Cañasgordas',7),(35,'Caracolí',7),(36,'Caramanta',7),(37,'Carepa',7),(38,'Carolina del Príncipe',7),(39,'Caucasia',7),(40,'Chigorodó',7),(41,'Cisneros',7),(42,'Cocorná',7),(43,'Concepción',7),(44,'Concordia',7),(45,'Copacabana',7),(46,'Dabeiba',7),(47,'Donmatías',7),(48,'Ebéjico',7),(49,'El Bagre',7),(50,'Entrerríos',7),(51,'Envigado',7),(52,'Fredonia',7),(53,'Frontino',7),(54,'Giraldo',7),(55,'Girardota',7),(56,'Gómez Plata',7),(57,'Granada',7),(58,'Guadalupe',7),(59,'Guarne',7),(60,'Guatapé',7),(61,'Heliconia',7),(62,'Hispania',7),(63,'Itagüí',7),(64,'Ituango',7),(65,'Jardín',7),(66,'Jericó',7),(67,'La Ceja',7),(68,'La Estrella',7),(69,'La Pintada',7),(70,'La Unión',7),(71,'Liborina',7),(72,'Maceo',7),(73,'Marinilla',7),(74,'Montebello',7),(75,'Murindó',7),(76,'Mutatá',7),(77,'Nariño',7),(78,'Nechí',7),(79,'Necoclí',7),(80,'Olaya',7),(81,'Peñol',7),(82,'Peque',7),(83,'Pueblorrico',7),(84,'Puerto Berrío',7),(85,'Puerto Nare',7),(86,'Puerto Triunfo',7),(87,'Remedios',7),(88,'Retiro',7),(89,'Rionegro',7),(90,'Sabanalarga',7),(91,'Sabaneta',7),(92,'Salgar',7),(93,'San Andrés de Cuerquia',7),(94,'San Carlos',7),(95,'San Francisco',7),(96,'San Jerónimo',7),(97,'San José de la Montaña',7),(98,'San Juan de Urabá',7),(99,'San Luis',7),(100,'San Pedro de los Milagros',7),(101,'San Pedro de Urabá',7),(102,'San Rafael',7),(103,'San Roque',7),(104,'San Vicente',7),(105,'Santa Bárbara',7),(106,'Santa Fé de Antioquia',7),(107,'Santa Rosa de Osos',7),(108,'Santo Domingo',7),(109,'Segovia',7),(110,'Sonsón',7),(111,'Sopetrán',7),(112,'Támesis',7),(113,'Tarazá',7),(114,'Tarso',7),(115,'Titiribí',7),(116,'Toledo',7),(117,'Turbo',7),(118,'Uramita',7),(119,'Urrao',7),(120,'Valdivia',7),(121,'Valparaíso',7),(122,'Vegachí',7),(123,'Venecia',7),(124,'Vigía del Fuerte',7),(125,'Yalí',7),(126,'Yarumal',7),(127,'Yolombó',7),(128,'Yondó',7),(129,'Zaragoza',7),(130,'Arauca',8),(131,'Arauquita',8),(132,'Cravo Norte',8),(133,'Fortul',8),(134,'Puerto Rondón',8),(135,'Saravena',8),(136,'Tame',8),(137,'Barranquilla',9),(138,'Baranoa',9),(139,'Campo de la Cruz',9),(140,'Candelaria',9),(141,'Galapa',9),(142,'Juan de Acosta',9),(143,'Luruaco',9),(144,'Malambo',9),(145,'Manatí',9),(146,'Palmar de Varela',9),(147,'Piojó',9),(148,'Polonuevo',9),(149,'Ponedera',9),(150,'Puerto Colombia',9),(151,'Repelón',9),(152,'Sabanagrande',9),(153,'Sabanalarga',9),(154,'Santa Lucía',9),(155,'Santo Tomás',9),(156,'Soledad',9),(157,'Suan',9),(158,'Tubará',9),(159,'Usiacurí',9),(160,'Cartagena',10),(161,'Magangué',10),(162,'Sincelejo',10),(163,'Turbo',10),(164,'El Carmen de Bolívar',10),(165,'Córdoba',10),(166,'Arjona',10),(167,'Boluviá',10),(168,'Margarita',10),(169,'San Juan Nepomuceno',10),(170,'Turbaco',10),(171,'Tiquisio',10),(172,'Santa Rosa',10),(173,'Simití',10),(174,'Carmen de Bolívar',10),(175,'Mompox',10),(176,'Tunja',11),(177,'Duitama',11),(178,'Sogamoso',11),(179,'Chiquinquirá',11),(180,'Paipa',11),(181,'Samacá',11),(182,'Tibasosa',11),(183,'Monguí',11),(184,'Villa de Leyva',11),(185,'Puerto Boyacá',11),(186,'Tuta',11),(187,'Ráquira',11),(188,'Nobsa',11),(189,'Gámeza',11),(190,'Cómbita',11),(191,'Chiquinquirá',11),(192,'San Pablo de Borbur',11),(193,'Coper',11),(194,'Saboyá',11),(195,'Manizales',12),(196,'Villamaría',12),(197,'Chinchiná',12),(198,'Neira',12),(199,'Palestina',12),(200,'Los Anegados',12),(201,'Anserma',12),(202,'Riosucio',12),(203,'Salamina',12),(204,'San Felix',12),(205,'Samaná',12),(206,'La Dorada',12),(207,'Manzanares',12),(208,'Marquetalia',12),(209,'Marmato',12),(210,'Viterbo',12),(211,'Caldas',12),(212,'Florencia',13),(213,'El Paujil',13),(214,'La Montañita',13),(215,'Morelia',13),(216,'San Vicente del Caguán',13),(217,'Valparaíso',13),(218,'Puerto Rico',13),(219,'Belén de los Andaquies',13),(220,'Solita',13),(221,'Los Cauchos',13),(222,'San José del Fragua',13),(223,'La Uribe',13),(224,'Albania',13),(225,'Sanjosé del Fragua',13),(226,'San Antonio de Getuchá',13),(227,'La Perdiz',13),(228,'Yopal',14),(229,'Aguazul',14),(230,'Támara',14),(231,'Hato Corozal',14),(232,'Nunchía',14),(233,'Paz de Ariporo',14),(234,'La Salina',14),(235,'Maní',14),(236,'Recetor',14),(237,'San Luis de Palenque',14),(238,'Sabanalarga',14),(239,'Chámeza',14),(240,'Pueblo Nuevo',14),(241,'Agua Azul',14),(242,'Tauramena',14),(243,'Popayán',15),(244,'Caldas',15),(245,'Santander de Quilichao',15),(246,'Puerto Tejada',15),(247,'El Tambo',15),(248,'La Sierra',15),(249,'Piamonte',15),(250,'Guapi',15),(251,'Bolívar',15),(252,'Morales',15),(253,'Almaguer',15),(254,'Timbío',15),(255,'Patía',15),(256,'Inzá',15),(257,'Paez',15),(258,'Jambaló',15),(259,'Argelia',15),(260,'La Vega',15),(261,'Puracé',15),(262,'Valledupar',16),(263,'Aguachica',16),(264,'La Paz',16),(265,'Bosconia',16),(266,'San Alberto',16),(267,'Gamarra',16),(268,'El Copey',16),(269,'Pueblo Bello',16),(270,'Curumaní',16),(271,'Chimichagua',16),(272,'Manaure Balcón del Cesar',16),(273,'San Diego',16),(274,'Codazzi',16),(275,'Agustín Codazzi',16),(276,'La Jagua de Ibirico',16),(277,'Tamalameque',16),(278,'Quibdó',17),(279,'Acandí',17),(280,'Bagadó',17),(281,'Bajo Baudó',17),(282,'Bojayá',17),(283,'Cértegui',17),(284,'Condoto',17),(285,'El Carmen de Atrato',17),(286,'El Litoral del San Juan',17),(287,'Istmina',17),(288,'Juradó',17),(289,'Lloró',17),(290,'Medio Atrato',17),(291,'Medio San Juan',17),(292,'Riosucio',17),(293,'San José del Palmar',17),(294,'Sipi',17),(295,'Tadó',17),(296,'Ungía',17),(297,'Montería',18),(298,'Cereté',18),(299,'Lorica',18),(300,'Planeta Rica',18),(301,'Sahagún',18),(302,'Ciénaga de Oro',18),(303,'Puerto Escondido',18),(304,'Tuchín',18),(305,'Tierralta',18),(306,'San Pelayo',18),(307,'Montelíbano',18),(308,'Cotorra',18),(309,'Valencia',18),(310,'Ayapel',18),(311,'Los Córdobas',18),(312,'La Apartada',18),(313,'Bogotá',19),(314,'Soacha',19),(315,'Chocontá',19),(316,'Cota',19),(317,'La Calera',19),(318,'Sibaté',19),(319,'Mosquera',19),(320,'Funza',19),(321,'Cajicá',19),(322,'Zipaquirá',19),(323,'Chocontá',19),(324,'Tenjo',19),(325,'Tabio',19),(326,'Girardot',19),(327,'El Rosal',19),(328,'Cucunubá',19),(329,'San Antonio del Tequendama',19),(330,'La Mesa',19),(331,'Villeta',19),(332,'Tocancipá',19),(333,'Cota',19),(334,'Sopó',19),(335,'Subachoque',19),(336,'Carmen de Carupa',19),(337,'Inírida',20),(338,'Barranco Minas',20),(339,'Cacahual',20),(340,'La Guadalupe',20),(341,'Pana Pana',20),(342,'San Felipe',20),(343,'La Unión',20),(344,'Puerto Inírida',20),(345,'San José del Guaviare',21),(346,'El Retorno',21),(347,'Miraflores',21),(348,'Calamar',21),(349,'La Primavera',21),(350,'Puerto Inírida',21),(351,'Neiva',22),(352,'Pitalito',22),(353,'La Plata',22),(354,'Garzón',22),(355,'Campoalegre',22),(356,'Altamira',22),(357,'Isnos',22),(358,'Rivera',22),(359,'Elías',22),(360,'Tello',22),(361,'Hobo',22),(362,'Teruel',22),(363,'Aipe',22),(364,'Saladoblanco',22),(365,'Suaza',22),(366,'Riohacha',23),(367,'Maicao',23),(368,'Fonseca',23),(369,'Distracción',23),(370,'Hatonuevo',23),(371,'San Juan del Cesar',23),(372,'Villanueva',23),(373,'Barrancas',23),(374,'La Jagua del Pilar',23),(375,'Uribia',23),(376,'Palomino',23),(377,'El Molino',23),(378,'Dibulla',23),(379,'Caminos del Indio',23),(380,'Los Horcones',23),(381,'Santa Marta',24),(382,'Ciénaga',24),(383,'Fundación',24),(384,'El Banco',24),(385,'Pivijay',24),(386,'Aracataca',24),(387,'Salamina',24),(388,'Guamal',24),(389,'Sitio Nuevo',24),(390,'San Zenón',24),(391,'Zona Bananera',24),(392,'Plato',24),(393,'Nueva Granada',24),(394,'Tenerife',24),(395,'Sitionuevo',24),(396,'Villavicencio',25),(397,'Acacías',25),(398,'Cumaral',25),(399,'Restrepo',25),(400,'San Martín',25),(401,'Puerto López',25),(402,'Granada',25),(403,'La Macarena',25),(404,'Mesetas',25),(405,'Uribe',25),(406,'Vistahermosa',25),(407,'Mapiripán',25),(408,'El Castillo',25),(409,'Barranca de Upía',25),(410,'Fuente de Oro',25),(411,'La Uribe',25),(412,'Cumaral',25),(413,'Pasto',26),(414,'Ipiales',26),(415,'Tumaco',26),(416,'Pueblo Nuevo',26),(417,'Cumbal',26),(418,'Puerres',26),(419,'El Tambo',26),(420,'La Unión',26),(421,'Buesaco',26),(422,'Samaniego',26),(423,'Consacá',26),(424,'Yacuanquer',26),(425,'Nariño',26),(426,'Los Andes',26),(427,'Francisco Pizarro',26),(428,'Policarpa',26),(429,'San Pablo',26),(430,'La Florida',26),(431,'Roberto Payán',26),(432,'Cúcuta',27),(433,'Pamplona',27),(434,'Ocaña',27),(435,'Los Patios',27),(436,'Villa de Rosario',27),(437,'Salazar de Las Palmas',27),(438,'El Tarra',27),(439,'Tibú',27),(440,'La Esperanza',27),(441,'Chinácota',27),(442,'Ragonvalia',27),(443,'San Cayetano',27),(444,'Durania',27),(445,'Hacarí',27),(446,'La Playa de Belén',27),(447,'Santiago',27),(448,'San José de Cúcuta',27),(449,'Mocoa',28),(450,'Puerto Asís',28),(451,'La Hormiga',28),(452,'Orito',28),(453,'Villagarzón',28),(454,'San Francisco',28),(455,'Santiago',28),(456,'Puerto Caicedo',28),(457,'El Tigre',28),(458,'Yupiltepeque',28),(459,'La Dorada',28),(460,'Belen de los Andaquies',28),(461,'Santiago',28),(462,'Valle del Guamuez',28),(463,'La Playa',28),(464,'Armenia',29),(465,'Calarcá',29),(466,'La Tebaida',29),(467,'Montenegro',29),(468,'Quimbaya',29),(469,'Salento',29),(470,'Pijao',29),(471,'Circasia',29),(472,'Buenavista',29),(473,'Córdoba',29),(474,'Pereira',30),(475,'Dosquebradas',30),(476,'La Virginia',30),(477,'Santa Rosa de Cabal',30),(478,'Marsella',30),(479,'Apía',30),(480,'Belén de Umbría',30),(481,'Balboa',30),(482,'Guática',30),(483,'Santuario',30),(484,'San Andrés',31),(485,'Providencia',31),(486,'Bucaramanga',32),(487,'Floridablanca',32),(488,'Barrancabermeja',32),(489,'Girón',32),(490,'Piedecuesta',32),(491,'San Gil',32),(492,'Lebrija',32),(493,'Barichara',32),(494,'Málaga',32),(495,'Duitama',32),(496,'Sincelejo',33),(497,'Corozal',33),(498,'Sampués',33),(499,'San Onofre',33),(500,'Morroa',33),(501,'Tolú',33),(502,'Sucre',33),(503,'Sincé',33),(504,'Ovejas',33),(505,'Caimito',33),(506,'Ibagué',34),(507,'Espinal',34),(508,'Melgar',34),(509,'El Espinal',34),(510,'Honda',34),(511,'Fresno',34),(512,'Líbano',34),(513,'Mariquita',34),(514,'Cajamarca',34),(515,'Piedras',34),(516,'Saldaña',34),(517,'San Antonio',34),(518,'Chaparral',34),(519,'Villarrica',34),(520,'Tolima',34),(521,'Cali',35),(522,'Palmira',35),(523,'Buenaventura',35),(524,'Tuluá',35),(525,'Buga',35),(526,'Candelaria',35),(527,'Cartago',35),(528,'Dagua',35),(529,'Yumbo',35),(530,'Roldanillo',35),(531,'Guacarí',35),(532,'Zarzal',35),(533,'El Cerrito',35),(534,'La Unión',35),(535,'Versalles',35),(536,'Mitú',36),(537,'Carurú',36),(538,'Papunaua',36),(539,'Taraira',36),(540,'Pacoa',36),(541,'Pizarro',36),(542,'Puerto Carreño',37),(543,'La Primavera',37),(544,'Cumaribo',37),(545,'Santa Rosalía',37),(546,'El Troncal',37);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (6,'Amazonas'),(7,'Antioquia'),(8,'Arauca'),(9,'Atlántico'),(10,'Bolívar'),(11,'Boyacá'),(12,'Caldas'),(13,'Caquetá'),(14,'Casanare'),(15,'Cauca'),(16,'Cesar'),(17,'Chocó'),(18,'Córdoba'),(19,'Cundinamarca'),(20,'Guainía'),(21,'Guaviare'),(22,'Huila'),(23,'La Guajira'),(24,'Magdalena'),(25,'Meta'),(26,'Nariño'),(27,'Norte de Santander'),(28,'Putumayo'),(29,'Quindío'),(30,'Risaralda'),(31,'San Andrés, Providencia y Santa Catalina'),(32,'Santander'),(33,'Sucre'),(34,'Tolima'),(35,'Valle del Cauca'),(36,'Vaupés'),(37,'Vichada');
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
  PRIMARY KEY (`id`),
  KEY `fk_ciudad_direccion` (`ciudad_id`),
  CONSTRAINT `fk_ciudad_direccion` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (3,'Cra 32',47),(4,'Cra 32 numero 25-16',8);
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
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operador`
--

LOCK TABLES `operador` WRITE;
/*!40000 ALTER TABLE `operador` DISABLE KEYS */;
INSERT INTO `operador` VALUES (NULL,12054,'Santiago','','Yepes','','3053382426','nbhbh','santiago@gmail.com');
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'operador'),(2,'administrador');
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
INSERT INTO `trituradora` VALUES (1,NULL,'Prototipo','TR1',NULL),(7,NULL,'Prototipo','TR5',4);
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
  PRIMARY KEY (`idturno`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'Dia','14:32:00','14:30:00'),(2,'Noche','15:38:00','15:45:00');
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
  PRIMARY KEY (`id_operario`),
  KEY `fk_turno_nombre` (`turno_nombre`),
  KEY `fk_operador_cedula` (`operador_cedula`),
  KEY `fk_trituradora_turno_operario` (`id_trituradora`),
  CONSTRAINT `fk_operador_cedula` FOREIGN KEY (`operador_cedula`) REFERENCES `operador` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trituradora_turno_operario` FOREIGN KEY (`id_trituradora`) REFERENCES `trituradora` (`id_trituradora`),
  CONSTRAINT `fk_turno_nombre` FOREIGN KEY (`turno_nombre`) REFERENCES `turno` (`idturno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno_operario`
--

LOCK TABLES `turno_operario` WRITE;
/*!40000 ALTER TABLE `turno_operario` DISABLE KEYS */;
INSERT INTO `turno_operario` VALUES (12054,1,NULL,8,1);
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `idtipo_usuario` (`tipo_usuario_id`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`tipo_usuario_id`) REFERENCES `tipo_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'santiagogil7112@gmail.com','123'),(14,1,'josegil7112@gmail.com','123'),(15,2,'jose@gmail.com','123');
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

-- Dump completed on 2024-10-23 10:34:59
