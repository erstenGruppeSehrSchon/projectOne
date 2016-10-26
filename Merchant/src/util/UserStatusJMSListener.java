package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.Merchant;
import service.MerchantManager;

public class UserStatusJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		System.out.println(message);
		ObjectMapper mapper = new ObjectMapper();
		Merchant m = mapper.readValue(message, Merchant.class);
		System.out.println(m.getMid());
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantManager merchantManager = (MerchantManager)context.getBean(MerchantManager.class);
		merchantManager.updateMerchantStatus(m.getMid(), m.getStatus());
    }
}
