package exception;

public class LoginEmptyException extends Exception{
	
	private String msg = "";
	
	// default exception
	public LoginEmptyException(){
		
	}
	
	// construct with error
	public LoginEmptyException(String message){
		super(message);
		this.msg = message;
	}
	
	// return message
	@Override
	public String getMessage(){
		return msg;
	}
}
