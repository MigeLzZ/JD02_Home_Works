package by.htp.carparking.service;

import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.Entity;

public interface CarParkingEntityService {

	Entity getEntity();
	
	void addCar(Car car);
	
	Car getCar(int id);
	
	void deleteCar(int id);
	
	void updateCar(Car car);
}
