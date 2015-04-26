DROP TABLE IF EXISTS `PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT` (
  `productCode` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` longtext,
  `imageUrl` varchar(255) DEFAULT NULL,
  `productCost` double NOT NULL,
  `productName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT`
--

LOCK TABLES `PRODUCT` WRITE;
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT INTO `PRODUCT` VALUES ('PR1','bakery','The light biscuit texture provides the ideal backdrop for a bounty of dried blueberries and lemon zest. Sweet yet tart, our classic Blueberry Scone calls for a balanced coffee, such as House Blend.','http://globalassets.starbucks.com/assets/ea8adb19d1894a7e930b218c0112c357.jpg',15,'Blueberry Scone Updated'),('PR2','bakery','Our traditionally inspired recipe begins with butter, wheat flour and vanilla. For the grand finale, we top each one with a sweet almond filling and toasted sliced almonds. Perfect with a cup of your favorite brewed coffee.','http://globalassets.starbucks.com/assets/40f7717f835d4e3199bb4406e205b40e.jpg',16,'Almond Croissant Blossom'),('PR3','breakfast','The light biscuit texture provides the ideal backdrop for a bounty of dried blueberries and lemon zest. Sweet yet tart, our classic Blueberry Scone calls for a balanced coffee, such as House Blend.','http://globalassets.starbucks.com/assets/ea8adb19d1894a7e930b218c0112c357.jpg',7,'Bacon & Gouda Breakfast Sandwich'),('PR4','breakfast','This is kind of like your typical ham, egg and cheese breakfast sandwich. Only with better cheese. And instead of scrambled eggs, you get frittata. With Parmesan. On a hand-scored artisan roll. See? Just like the sandwich you are used to except delightfully different. ','http://globalassets.starbucks.com/assets/0f250d904ffd418cb2edc0e3596fe5ed.jpg',5,'Ham & Cheddar Breakfast Sandwich'),('PR5','bistro box','A trio of cheeses: creamy Brie, bold Gouda, two year aged Cheddar, grain crackers, green apple wedges and a mix of roasted almonds and tart dried cranberries.','http://globalassets.starbucks.com/assets/8bdae8a56b014a8ba1ca624ce19ed856.jpg',6,'Cheese & Fruit Bistro Box'),('PR6','bakery','Traditional chick pea hummus and grilled chicken served with grape tomatoes, cucumber sticks and whole wheat pita halves.','http://globalassets.starbucks.com/assets/8d64ec2ecc6b4afdbb6aec25d132a1ce.jpg',4,'Chicken & Hummus Bistro Box'),('PR7','bakery','Our muffin unites rich, dense chocolate with a gooey caramel center for bliss in every bite. As far as we\'re concerned, there\'s no such thing as too much caramel. Which is why we concocted this delightfully indulgent treat.','http://globalassets.starbucks.com/assets/a877f84f1f4c414d89d2059447855d66.jpg',12,'Chocolate Caramel Muffin');
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `username` varchar(255) NOT NULL,
  `emailID` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES ('admin','admin@gmail.com','admin','admin','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','admin','admin'),('c2tarun','c2tarun@gmail.com','Tarun','Mall','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',NULL,NULL),('test','test@gmail.com','test_fname','test_lname','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',NULL,NULL),('testUser','test@gmail.com','test','test','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',NULL,NULL),('testUser1','test@gmail.com','test','test','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','testNick','admin');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_order` (
  `orderId` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `delivery_date` varchar(255) DEFAULT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `products` varchar(255) DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order`
--

LOCK TABLES `user_order` WRITE;
/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
INSERT INTO `user_order` VALUES (1,'Apt H,Ut drive,Charlotte,NC-28262','2015-04-27T15:24','2015/04/26','Ham & Cheddar Breakfast Sandwich  -  1,Bacon & Gouda Breakfast Sandwich  -  1',12,'c2tarun');
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;
UNLOCK TABLES;