package util;

import javax.jms.Message;
import javax.jms.TextMessage;

public class AdvJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
    }
	
}
