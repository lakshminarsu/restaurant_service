CREATE DATABASE `restaurant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `main_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `item_name_UNIQUE` (`item_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `menu_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `main_menu_item_id` int NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `item_price` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `main_menu_item_id` (`main_menu_item_id`),
  CONSTRAINT `menu_item_ibfk_1` FOREIGN KEY (`main_menu_item_id`) REFERENCES `main_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `table_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sequence` int NOT NULL,
  `bill_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `table_detail_ibfk_1` (`bill_id`),
  CONSTRAINT `table_detail_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_take_away` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bill_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bill_id` int NOT NULL,
  `item_id` int NOT NULL,
  `qty` int NOT NULL,
  `item_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `item_id` (`item_id`),
  KEY `bill_item_ibfk_1` (`bill_id`),
  CONSTRAINT `bill_item_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `bill_item_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `menu_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



