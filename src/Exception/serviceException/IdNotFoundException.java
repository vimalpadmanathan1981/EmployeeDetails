package Exception.serviceException;

public class IdNotFoundException extends ServiceException{
	public IdNotFoundException() {
		super();
	}
	
	public IdNotFoundException(String message) {
		super(message);
	}

}
