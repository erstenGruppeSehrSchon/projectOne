package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.util.PasswordEncrypter;
import po.Merchant;
import service.MerchantManager;

public class MerchantControllerTest {
	
	@Test
	public void testRegister(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantManager m = (MerchantManager) context.getBean(MerchantManager.class);
		
		String username = "test1";
		String password = "test1";
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
}
