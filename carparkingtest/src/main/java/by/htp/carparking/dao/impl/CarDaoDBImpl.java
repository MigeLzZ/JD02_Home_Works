package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.domain.Car;

public class CarDaoDBImpl implements CarDao {
	
	private static final Logger logger = LogManager.getLogger();
	private static final String SQL_SELECT_CARS = "SELECT * FROM cars";
	private static final String SQL_INSERT_CAR = "INSERT INTO cars (brand, model) VALUES (?, ?)";
	private static final String SQL_SELECT_CAR = "SELECT * FROM cars WHERE id = ?";
	private static final String SQL_DELETE_CAR = "DELETE FROM cars WHERE  id = ?";
	private static final String SQL_UPDATE_CAR = "UPDATE cars SET brand = ?, model = ? WHERE id = ?";
	
	
	public CarDaoDBImpl() {
	
	}

	@Override
	public void create(Car entity) {

		Connection conn = DBConnectionHelper.connect();
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT_CAR);

			ps.setString(1, "brand1");
			ps.setString(2, "model1");

			ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("Cannot insert into cars!", e);
		} finally {
			if (ps != null) {
				try {
					conn.close();
					ps.close();
				} catch (SQLException e) {
					logger.error("Cannot close the streams!", e);
				}
			}
		}

	}

	@Override
	public Car read(int id) {
		Connection conn = DBConnectionHelper.connect();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_CAR);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"));
			else
				throw new IllegalArgumentException();					
		} catch (SQLException e) {
			logger.error("Cannot select from cars with ID!", e);
		} finally {
			if (ps != null) {
				try {
					conn.close();
					ps.close();
				} catch (SQLException e) {
					logger.error("Cannot close the streams!", e);
				}
			}
		}
		return null;
	}

	@Override
	public List<Car> readAll() {
		List<Car> cars = new ArrayList<>();
		Connection conn = DBConnectionHelper.connect();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_CARS);

			cars = new ArrayList<Car>();
			Car car = null;

			while (rs.next()) {
				car = new Car();

				car.setId(rs.getInt(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));

				cars.add(car);
			}
			
//			while (rs.next()) {
//				Car car = new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model")));
//				cars.add(car);
//			}
			
		} catch (SQLException e) {
			logger.error("Cannot read all cars!", e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("Cannot close the streams!", e);
			}
		}
		return cars;
	}

	@Override
	public void update(Car entity) {
		Connection conn = DBConnectionHelper.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Car car = null;

		try {
			ps = conn.prepareStatement(SQL_SELECT_CAR);
			ps.setInt(1, entity.getId());

			rs = ps.executeQuery();

			if (rs.next()) {
				car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
			}
			
			ps = conn.prepareStatement(SQL_UPDATE_CAR);
			
			ps.setString(1, entity.getModel());
			ps.setString(2, entity.getBrand());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("Cannot update the car!", e);
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("Cannot close the streams!", e);
			}
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = DBConnectionHelper.connect();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_CAR);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Cannot delete the car!", e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("Cannot close the streams!", e);
			}
		}

	}

}
