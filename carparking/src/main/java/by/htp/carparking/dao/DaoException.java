package by.htp.carparking.dao;

public class DaoException extends Exception{
	
	private static final long serialVersionUID = 6968718794685374652L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
}
