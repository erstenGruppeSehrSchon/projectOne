package test;

import static org.junit.Assert.*;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class TestJMS {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConnectionFactory factory = (ActiveMQConnectionFactory)context.getBean("mq");
		
//		Destination queue = new ActiveMQQueue("Test01Q");
		Destination queue = (ActiveMQQueue)context.getBean("destination");
		Connection con = null;
		Session session = null;
		MessageProducer producer = null;
		
		try {
			con = factory.createConnection();
			con.start();
			session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			TextMessage msg = session.createTextMessage("Testing for JMShhh");
			producer.send(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
