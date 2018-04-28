-- Дамп данных таблицы carparking.cars: ~9 rows (приблизительно)
INSERT INTO `cars` (`id`, `brand`, `model`) VALUES
	(1, 'VOLVO', 'XC90'),
	(2, 'BMW', 'M5'),
	(3, 'BMW', 'X5'),
	(4, 'Ferrari', 'F1'),
	(5, 'Toyota', 'Supra'),
	(6, 'asdf', 'sdf'),
	(8, 'asdf', 'sdf'),
	(9, 'pukich', 'alfa'),
	(10, 'pukich', 'alfa');

-- Дамп данных таблицы carparking.orders: ~5 rows (приблизительно)
INSERT INTO `orders` (`order_id`, `user_id`, `car_id`, `dateStart`, `dateEnd`) VALUES
	(1, 1, 1, NULL, NULL),
	(2, 1, 1, NULL, NULL),
	(3, 1, 1, NULL, NULL),
	(4, 1, 1, NULL, NULL),
	(5, 1, 1, NULL, NULL),
	(6, 1, 2, '2018-04-20', '2018-04-21');
