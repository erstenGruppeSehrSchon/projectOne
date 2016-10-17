package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import consts.Consts;
import dao.impl.MerchantLoginDaoImpl;
import dao.impl.MerchantRegisterDaoImpl;
import common.po.Shop;
import common.po.MeMerchant;
import util.PasswordEncrypter;

public class RegistLoginTest {
	@Test
	public void testAddMerchant() throws ParseException{ // m_register_dao
		MeMerchant m = new MeMerchant();
		m.setUserName("test");
		m.setPassword("test");
		m.setName("test");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date birthDate = sdf.parse("2016-12-12 13:13:13");
		m.setBirth(birthDate);
		m.setGender("test");
		m.setStatus(Consts.PENDING);
		m.setRegDate(birthDate);
		
		Shop s = new Shop();
		s.setName("test");
		s.setDescr("test");
		s.setImagePath("/test/");
		m.getShopList().add(s);
		
		System.out.println(new MerchantRegisterDaoImpl().addMerchant(m));
	}
	
	@Test
	public void testAddMerchantWithoutShop() throws ParseException{ // m_register_dao
		MeMerchant m = new MeMerchant();
		m.setUserName("test");
		m.setPassword(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword("test"));
		m.setName("test");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date birthDate = sdf.parse("2016-12-12 13:13:13");
		m.setBirth(birthDate);
		m.setGender("test");
		m.setStatus(Consts.PENDING);
		m.setRegDate(new Date(System.currentTimeMillis()));
		
		System.out.println(new MerchantRegisterDaoImpl().addMerchantWithoutShop(m));
	}

	@Test
	public void testSearchMerchant(){ // m_register_dao
		MeMerchant m = new MerchantRegisterDaoImpl().searchMerchant(4);
		System.out.println("Username: " +m.getUserName());
		System.out.println("Password: " +m.getPassword());
		System.out.println("Name: " +m.getName());
		System.out.println("Birth: " +m.getBirth().toString());
		System.out.println("Gender: " +m.getGender());
		System.out.println("Status: " +m.getStatus());
		System.out.println("RegDate: " +m.getRegDate().toString());
	}
	
	@Test
	public void testCheckMerchantExist(){ // m_login_dao
		System.out.println(new MerchantLoginDaoImpl().checkMerchantExist("test", "test"));
	}
	
	@Test
	public void testRetrieveMerchantStatus(){ // m_login_dao
		System.out.println(new MerchantLoginDaoImpl().retrieveMerchantStatus(4));
	}
}
