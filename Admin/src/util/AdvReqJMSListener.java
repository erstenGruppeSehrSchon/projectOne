package util;

public class AdvReqJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
    }

}
