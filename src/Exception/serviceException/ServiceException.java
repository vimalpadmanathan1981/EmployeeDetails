package Exception.serviceException;

import Exception.EmployeeException;

public class ServiceException extends EmployeeException{
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}

}
