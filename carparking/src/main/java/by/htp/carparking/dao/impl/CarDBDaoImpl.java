package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.carparking.dao.BaseDao;
import by.htp.carparking.dao.DaoException;
import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.Entity;

public class CarDBDaoImpl implements BaseDao<Car> {

	private static final String SQL_SELECT_CARS = "SELECT * FROM cars";
	private static final String SQL_INSERT_CAR = "INSERT INTO cars (brand, model) VALUES (?, ?)";
	private static final String SQL_SELECT_CAR = "SELECT * FROM cars WHERE id = ?";
	private static final String SQL_DELETE_CAR = "DELETE FROM cars WHERE  id = ?";
	private static final String SQL_UPDATE_CAR = "UPDATE cars SET brand = ?, model = ? WHERE id = ?";
	
	@Override
	public void create(Car entity) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnectionHelper.connect();
			ps = con.prepareStatement(SQL_INSERT_CAR);

			ps.setString(1, entity.getBrand());
			ps.setString(2, entity.getModel());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConnectionHelper.disconnect(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Car read(int id) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Car car = null;

		try {
			con = DBConnectionHelper.connect();
			ps = con.prepareStatement(SQL_SELECT_CAR);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnectionHelper.disconnect(con);
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return car;
	}

	@Override
	public List<Car> readAll() {
		List<Car> cars = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DBConnectionHelper.connect();
			st = con.createStatement();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnectionHelper.disconnect(con);
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cars;
	}

	@Override
	public void update(Car entity) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Car car = null;

		try {
			con = DBConnectionHelper.connect();
			ps = con.prepareStatement(SQL_SELECT_CAR);
			ps.setInt(1, entity.getId());

			rs = ps.executeQuery();

			if (rs.next()) {
				car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
			}
			
			ps = con.prepareStatement(SQL_UPDATE_CAR);
			
			ps.setString(1, entity.getModel());
			ps.setString(2, entity.getBrand());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnectionHelper.disconnect(con);
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int carId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnectionHelper.connect();
			ps = con.prepareStatement(SQL_DELETE_CAR);
			ps.setInt(1, carId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnectionHelper.disconnect(con);
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
