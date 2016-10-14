package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import org.junit.Assert;
import org.junit.Test;

import consts.Consts;
import dao.impl.MerchantLoginDaoImpl;
import dao.impl.MerchantRegisterDaoImpl;
import object.Shop;
import object.merchant.MeMerchant;
import util.DBUtil;

public class testCommon {

	@Test
	public void test() {
		Connection con = null;
//		String sql = "insert into user1(id,uname,age) values (user_seq01.nextVal,?,?)";
		PreparedStatement pst = null;
		
		con=DBUtil.createConnection();
		Assert.assertTrue((con !=null));
	}
	
	@Test
	public void testAddMerchant(){ // m_register_dao
		MeMerchant m = new MeMerchant();
		m.setUserName("test");
		m.setPassword("test");
		m.setName("test");
		m.setBirth(new Date(1990,11,11));
		m.setGender("test");
		m.setStatus(Consts.PENDING);
		m.setRegDate(new Date(1990,11,11));
		
		Shop s = new Shop();
		s.setName("test");
		s.setDescr("test");
		s.setImagePath("/test/");
		m.getShopList().add(s);
		
		System.out.println(new MerchantRegisterDaoImpl().addMerchant(m));
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
