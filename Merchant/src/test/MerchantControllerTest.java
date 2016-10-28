package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.util.PasswordEncrypter;
import po.Advertisement;
import po.Merchant;
import po.Shop;
import service.AdvertisementManager;
import service.MerchantManager;

public class MerchantControllerTest {
	
	@Test
	public void testRegister(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantManager m = (MerchantManager) context.getBean(MerchantManager.class);
		
		String username = "test";
		String password = "test";
		String name = "test";
		String gender = "M";
		String birthDate = "20161010";
		m.addMerchant(username, password, name, gender, birthDate);
	}
	
	@Test
	public void testLogin(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantManager m = (MerchantManager) context.getBean(MerchantManager.class);
		
		Merchant merchant = m.login("test", PasswordEncrypter.getPasswordEncrypter().encrypt("test"));
		
		System.out.println(merchant.getMid()+"..."+merchant.getUsername());
	}
	
	@Test
	public void testGetAllAdvertisementByMid(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantManager m = (MerchantManager) context.getBean(MerchantManager.class);
		
		AdvertisementManager adv = (AdvertisementManager) context.getBean(AdvertisementManager.class);
		
		Merchant merchant = m.getMerchantByMid("8a5eb9b75806a6c1015806a710b70000");
		List<Advertisement> result = new ArrayList<Advertisement>();
		
		for(Shop s: merchant.getShops()){
			System.out.println(adv.getAdvertisementBySid(s.getSid()).size());
			result.addAll(adv.getAdvertisementBySid(s.getSid()));
		}
		
		Assert.assertTrue(result.size() == 1);
	}
	
	@Test
	public void testGetAdvertisementBySid(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");		
		AdvertisementManager adv = (AdvertisementManager) context.getBean(AdvertisementManager.class);
		
		List<Advertisement> ads = adv.getAdvertisementBySid("8a5eb9b75805363d0158053709660000");
		
	}
}
