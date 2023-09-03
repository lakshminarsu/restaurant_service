CREATE DATABASE `restaurant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `main_menu` (
  `id` int NOT NULL,
  `item_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `item_name_UNIQUE` (`item_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `menu_item` (
  `id` int NOT NULL,
  `main_menu_item_id` int NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `item_price` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `main_menu_item_id` (`main_menu_item_id`),
  CONSTRAINT `menu_item_ibfk_1` FOREIGN KEY (`main_menu_item_id`) REFERENCES `main_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


