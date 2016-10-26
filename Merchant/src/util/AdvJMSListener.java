package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.Advertisement;
import po.Merchant;
import service.AdvertisementManager;
import service.MerchantManager;

public class AdvJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		ObjectMapper mapper = new ObjectMapper();
		Advertisement a = mapper.readValue(message, Advertisement.class);
		System.out.println(a.getADV_IMG_ID());
		System.out.println(a.getStatus());
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdvertisementManager manager = (AdvertisementManager)context.getBean(AdvertisementManager.class);
		manager.updateAdvertisementStatus(a.getADV_IMG_ID(), a.getStatus());
    }
	
}
