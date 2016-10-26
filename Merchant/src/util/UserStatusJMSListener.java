package util;

public class UserStatusJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
    }
}
