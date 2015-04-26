CREATE TABLE IF NOT EXISTS `user_order` (
  `user_id` varchar(255),
  `orderId` int(11),
  `order_date` date,
  `address` varchar(255),
  `delivery_date` datetime,
  `products` varchar(1000),  
  `totalCost` double,
  PRIMARY KEY(orderId)  
) ;
