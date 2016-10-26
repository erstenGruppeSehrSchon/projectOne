package util;

public class NewUserJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
    }
}
