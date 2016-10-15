package UnitTest;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import dao.DishDao;
import dao.MerchantDao;
import dao.ShopDao;
import dao.impl.DishDaoImpl;
import dao.impl.MerchantDaoImpl;
import dao.impl.ShopDaoImpl;
import util.PasswordEncrypter;




public class JunitTest {
	
	
	private ShopDao sd = new ShopDaoImpl();
	private MerchantDao ad = new MerchantDaoImpl();
	private DishDao dd = new DishDaoImpl();
	private Properties prop = new Properties();
	private InputStream in;

	@Test
	public void adtest() throws Exception {
		
		System.out.println(ad.findMeMerchantById(1).getName());

	}
	
	@Test
	public void sdtest() {
		System.out.println(sd.findAllShop());
		System.out.println(sd.findShopById(1).getName());
		
		
	}
	@Test
	public void ddtest() {
		
		System.out.println(dd.findAllDish());
		System.out.println(dd.findAllDishImage());
		System.out.println(dd.loadDish(1).getName());
		System.out.println(dd.loadDishImage(1).getPath());
		
      
		
		
	}

}
