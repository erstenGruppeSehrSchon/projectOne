package test;

import org.junit.Test;

import common.po.Shop;
import service.MerchantShopService;
import service.impl.MerchantShopServiceImpl;

public class MerchantShopTest {
	public MerchantShopService service = new MerchantShopServiceImpl();	
	
	@Test
	public void testAddMerchantShop(){
		Shop shop = new Shop();
		
		shop.setMid(16);
		shop.setName("aefwefgwebvg");
		shop.setDescr("ebrerg qwregqer qergerq qergqer qbwger greqg re");
		
		
		System.out.println(service.addMerchantShop(shop));
	}
}
