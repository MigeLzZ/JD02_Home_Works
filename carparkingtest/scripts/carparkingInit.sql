-- Дамп структуры базы данных carparking
DROP DATABASE IF EXISTS `carparking`;
CREATE DATABASE IF NOT EXISTS `carparking` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `carparking`;

-- Дамп структуры для таблица carparking.cars
DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица carparking.orders
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
