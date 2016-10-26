package util;

public class ComplainJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
    }

}
