package by.htp.carparking.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.domain.Car;

public class CarDaoHibernateImpl implements CarDao {

	@Override
	public void create(Car entity) {
		Session session = SessionFactoryManager
				.getSessionFactory()
				.openSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
//		Criteria criteria = session.createCriteria(Car.class);
//		List<Car> cars = criteria.list();
//		criteria.add();
		
		
	}

	@Override
	public Car read(int id) {
		Session session = SessionFactoryManager
				.getSessionFactory()
				.openSession();
		session.getTransaction();
		return (Car) session.load(Car.class, id);
//		Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("id", id));
//		List<Car> cars = criteria.list();
//		
//		if (cars.get(0) != null) {
//			return cars.get(0);
//		} else {
//			return null;
//		}
		
	}

	@Override
	public List<Car> readAll() {
		Session session = SessionFactoryManager
				.getSessionFactory()
				.openSession();
		Criteria criteria = session.createCriteria(Car.class);
		
		return criteria.list();
	}

	@Override
	public void update(Car entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
