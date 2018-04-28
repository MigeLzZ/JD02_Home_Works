package by.htp.carparking.service;

import java.sql.Date;

public interface OrderService {
	
	void orderCar(int userId, int carId, Date dateStart, Date dateEnd);

}
