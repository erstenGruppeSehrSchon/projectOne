package util;

import java.io.IOException;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import object.merchant.MeMerchant;
import object.merchant.Merchant;
import service.MerchantManager;
import service.impl.MerchantManagerImpl;

public class ListenJMSUtil {
	private final static String prefix = "failover://tcp://";
	private final static String hostname = "cheunan-w7";
	private final static String port = "16161";
	private final static String connectionStr = prefix+hostname+":"+port;
	
	private static MerchantManager mm = new MerchantManagerImpl();
	
	public static void startListenRequest() throws Exception{
		//create consumer always listens->When receives msg, go to findMeMerchantById to get M_Merchant table info
		//->Create AdminMerchant by MeMerchant->save to table
		ConnectionFactory factory = new ActiveMQConnectionFactory(connectionStr);
		Destination queue = new ActiveMQQueue("REG_REQUEST_Q001");
		Connection con = factory.createConnection();
		con.start();
		
		Session sen=con.createSession(false, Session.AUTO_ACKNOWLEDGE);//true is transaction
		MessageConsumer consumer = sen.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			//callback
			public void onMessage (Message message){
				TextMessage msg = (TextMessage)message;
				try {
					System.out.println(msg.getText());
					ObjectMapper mapper = new ObjectMapper();
					
					MeMerchant m = mapper.readValue(msg.getText(), MeMerchant.class);
					MeMerchant merchant = mm.findMeMerchantById(m.getMid());
					Merchant adMerchant = new Merchant();
					adMerchant.setMid(merchant.getMid());
					adMerchant.setName(merchant.getName());
					adMerchant.setBirth(merchant.getBirth());
					adMerchant.setGender(merchant.getGender());
					adMerchant.setStatus(merchant.getStatus());
					adMerchant.setRegDate(merchant.getRegDate());
					mm.setMerchant(adMerchant);						
				} catch (JMSException e) {
					e.printStackTrace();
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
