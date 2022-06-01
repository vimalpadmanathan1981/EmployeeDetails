package Exception.daoexception;

import Exception.serviceException.ServiceException;

public class DaoException extends ServiceException {
	 
	public DaoException() {
		super();
	}
	
	public DaoException(String message) {
		super(message);
	}

}
