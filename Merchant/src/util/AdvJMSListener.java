package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import po.Advertisement;
import service.AdvertisementManager;

public class AdvJMSListener {
	public void messageReceived(String message) throws Exception
    {        
		ObjectMapper mapper = new ObjectMapper();
		Advertisement a = mapper.readValue(message, Advertisement.class);
		System.out.println(a.getAdvId());
		System.out.println(a.getStatus());
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdvertisementManager manager = (AdvertisementManager)context.getBean(AdvertisementManager.class);
		manager.updateAdvertisementStatus(a.getAdvId(), a.getStatus());
    }
	
}
