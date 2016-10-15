package exception;

public class RegisterEmptyException extends Exception{
	
	// default exception
	public RegisterEmptyException(){
		
	}
	
	// construct with error
	public RegisterEmptyException(String message){
		super(message);
	}
	
	// return message
	@Override
	public String getMessage(){
		return getMessage();
	}
}
