package servlet;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServlet;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.po.MeMerchant;
import common.po.Merchant;
import common.service.MerchantManager;
import common.service.impl.MerchantManagerImpl;

public class JMSListenerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static String PREFIX = "failover://tcp://";
	private final static String HOSTNAME = "cheunan-w7";
	private final static String PORT = "16161";
	private final static String CONNECTION_STR = PREFIX +HOSTNAME + ":" + PORT;
	private final static String QUEUE = "REG_REQUEST_Q001";
	
	private MerchantManager mm = new MerchantManagerImpl();

    public JMSListenerServlet() {
    	
    	Connection con = null;
    	Session session = null;
    	MessageConsumer consumer = null;
    	
        try {
        	System.out.println("JMSListener Start");
			startListen(con, session, consumer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stopListen(con, session, consumer);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    private void startListen(Connection conn, Session session, MessageConsumer consumer) throws JMSException {
    	
		ConnectionFactory factory = new ActiveMQConnectionFactory(CONNECTION_STR);
		Destination queue = new ActiveMQQueue(QUEUE);
		conn = factory.createConnection();
		conn.start();
		
		session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		consumer = session.createConsumer(queue);
		
		consumer.setMessageListener(new MessageListener() {
			// Callback
			public void onMessage (Message message){
				TextMessage msg = (TextMessage)message;
				try {
					System.out.println(msg.getText());
					ObjectMapper mapper = new ObjectMapper();
					
					MeMerchant m = mapper.readValue(msg.getText(), MeMerchant.class);
					MeMerchant mMerchant = mm.findMeMerchantById(m.getMid());
					Merchant aMerchant = new Merchant();
					aMerchant.setMid(mMerchant.getMid());
					aMerchant.setName(mMerchant.getName());
					aMerchant.setBirth(mMerchant.getBirth());
					aMerchant.setGender(mMerchant.getGender());
					aMerchant.setStatus(mMerchant.getStatus());
					aMerchant.setRegDate(mMerchant.getRegDate());
					mm.setMerchant(aMerchant);				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    
    private void stopListen(Connection conn, Session session, MessageConsumer consumer) throws JMSException {
    	if (consumer != null) {
    		consumer.close();
    	}
    	if (session != null) {
    		session.close();
    	}
    	if (conn != null) {
    		conn.close();
    	}
    }
}
