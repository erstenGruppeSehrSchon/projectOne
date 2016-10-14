package util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import com.fasterxml.jackson.databind.ObjectMapper;

import object.merchant.MeMerchant;

public class sendJMSRequestUtil {
	private final static String prefix = "failover://tcp://";
	private final static String hostname = "cheunan-w7";
	private final static String port = "16161";
	private final static String connectionStr = prefix+hostname+":"+port;
	
	
	public static void sendRegisterRequest(int id) throws Exception{
		ConnectionFactory factory = new ActiveMQConnectionFactory(connectionStr);
		Destination queue = new ActiveMQQueue("REG_REQUEST_Q001");
		Connection con = factory.createConnection();
		con.start();
		//Message ack mode
		Session sen=con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		MessageProducer producer = sen.createProducer(queue);
		ObjectMapper mapper = new ObjectMapper();
		MeMerchant m = new MeMerchant();
		m.setMid(id);
		String msgStr = mapper.writeValueAsString(m);
		TextMessage msg = sen.createTextMessage(msgStr);
		producer.send(msg);
		
		
		producer.close();
		sen.close();
		con.close();
	}
	

}
