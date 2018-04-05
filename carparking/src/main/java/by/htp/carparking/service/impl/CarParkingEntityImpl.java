package by.htp.carparking.service.impl;

import by.htp.carparking.dao.BaseDao;
import by.htp.carparking.dao.DaoException;
import by.htp.carparking.dao.impl.CarDBDaoImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.Entity;
import by.htp.carparking.service.CarParkingEntityService;

public class CarParkingEntityImpl implements CarParkingEntityService{

	private BaseDao<Car> dao;
	
	{
		dao = new CarDBDaoImpl();
	}
	
	@Override
	public Entity getEntity() {
		
		Entity entity = new Entity();
		entity.setId(1);
		entity.setCars(dao.readAll());
		
		return entity;
	}

	@Override
	public void addCar(Car car) {
		if(car != null) {
			try {
				dao.create(car);
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Car getCar(int id) {
		Car car = null;
		if (id > 0) {
			try {
				car = dao.read(id);
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		return car;
	}

	@Override
	public void deleteCar(int carId) {
		dao.delete(carId);
		
	}

	@Override
	public void updateCar(Car car) {
		try {
			dao.update(car);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

}
