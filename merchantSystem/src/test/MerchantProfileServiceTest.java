package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import po.Shop;
import po.ShopContact;
import po.MeMerchant;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

public class MerchantProfileServiceTest {
	private MerchantProfileService service = new MerchantProfileServiceImpl();
	
	@Test
	public void testRetrieveMerchantInfo(){
		MeMerchant merchant = service.retrieveMerchantInfo(9);
		
		Assert.assertTrue(merchant.getShopList().size() == 1);
		
		for(Shop shop: merchant.getShopList()){
			System.out.println("Shop sid: " + shop.getSid());
			System.out.println("Shop mid: " + shop.getMid());
			System.out.println("Shop name: " + shop.getName());
			System.out.println("Shop decription: " + shop.getDescr());
			System.out.println("Shop image_path: " + shop.getImagePath());
			
			Assert.assertTrue(shop.getShopContactList().size() == 2);
			
			for(ShopContact contact : shop.getShopContactList()){
				System.out.println("\tShop cid: " + contact.getCid());
				System.out.println("\tShop sid: " + contact.getSid());
				System.out.println("\tShop type: " + contact.getType());
				System.out.println("\tShop info: " + contact.getInfo());
				System.out.println();
			}
			System.out.println();
		}
	}
	
	@Test
	public void testRetrieveShopOnly(){
		List<Shop> shops = service.retrieveShopOnly(9);
		
		Assert.assertTrue(shops.size() == 1);
		
		for(Shop shop: shops){
			System.out.println("Shop sid: " + shop.getSid());
			System.out.println("Shop mid: " + shop.getMid());
			System.out.println("Shop name: " + shop.getName());
			System.out.println("Shop decription: " + shop.getDescr());
			System.out.println("Shop image_path: " + shop.getImagePath());

			System.out.println();
		}
	}
	
	@Test
	public void testRetrieveShopContactOnly(){
		List<ShopContact> contacts = service.retrieveShopContactOnly(5);
		
		Assert.assertTrue(contacts.size() == 2);
		
		for(ShopContact contact : contacts){
			System.out.println("\tShop cid: " + contact.getCid());
			System.out.println("\tShop sid: " + contact.getSid());
			System.out.println("\tShop type: " + contact.getType());
			System.out.println("\tShop info: " + contact.getInfo());
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	public void testRetrieveDishesByMid(){
		
	}
}
