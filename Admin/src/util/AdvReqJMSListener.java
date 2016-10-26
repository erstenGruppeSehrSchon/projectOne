package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import po.Advertisement;
import po.Merchant;
import service.MerchantManager;

public class AdvReqJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Advertisement p = mapper.readValue(message, Advertisement.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

}
