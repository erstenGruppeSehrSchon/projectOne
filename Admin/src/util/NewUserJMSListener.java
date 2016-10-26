package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import po.Merchant;
import service.MerchantManager;

public class NewUserJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Merchant m = mapper.readValue(message, Merchant.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantManager merchantManager = (MerchantManager)context.getBean(MerchantManager.class);
		merchantManager.addMerchant(m);
    }
}
