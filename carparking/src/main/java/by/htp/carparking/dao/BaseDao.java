package by.htp.carparking.dao;

import java.util.List;

import by.htp.carparking.domain.Entity;

public interface BaseDao<T extends Entity> {

	void create(T entity) throws DaoException;

	T read(int id) throws DaoException;

	List<T> readAll();

	void update(T entity) throws DaoException;

	void delete(int id);
	
}
