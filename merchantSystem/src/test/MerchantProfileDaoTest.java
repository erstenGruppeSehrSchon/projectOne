package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.impl.MerchantProfileDaoImpl;
import object.Shop;
import object.ShopContact;
import object.merchant.MeMerchant;

public class MerchantProfileDaoTest {

	@Test
	public void testRetrieveMerchantByMid(){
		MeMerchant merchant = new MerchantProfileDaoImpl().retrieveMerchantByMid(0);
		Assert.assertTrue(merchant == null);
		
		merchant = new MerchantProfileDaoImpl().retrieveMerchantByMid(6);
		Assert.assertTrue(merchant.getMid() == 6);
	}
	
	@Test
	public void testRetrieveShopInfoByMid(){
		List<Shop> shops = new MerchantProfileDaoImpl().retrieveShopInfoByMid(0);
		Assert.assertTrue(shops == null || shops.size() == 0);
		
		shops = new MerchantProfileDaoImpl().retrieveShopInfoByMid(8);
		Assert.assertTrue(shops.size() == 1);
		
		for(Shop shop: shops){
			System.out.println("Shop sid: " + shop.getSid());
			System.out.println("Shop mid: " + shop.getMid());
			System.out.println("Shop name: " + shop.getName());
			System.out.println("Shop decription: " + shop.getDescr());
			System.out.println("Shop image_path: " + shop.getImagePath());
//			for(ShopContact contact : shop.getShopContactList()){
//				System.out.println("\tShop cid: " + contact.getCid());
//				System.out.println("\tShop sid: " + contact.getSid());
//				System.out.println("\tShop type: " + contact.getType());
//				System.out.println("\tShop info: " + contact.getInfo());
//				System.out.println();
//			}
			System.out.println();
		}
	}
	
	@Test
	public void testRetrieveShopContactByMid(){
		List<ShopContact> contacts = new MerchantProfileDaoImpl().retrieveShopContactBySid(0);
		Assert.assertTrue(contacts == null || contacts.size() == 0);
		
		contacts = new MerchantProfileDaoImpl().retrieveShopContactBySid(5);
		Assert.assertTrue(contacts.size() == 2);
		
		for(ShopContact contact: contacts){
			
			System.out.println("\tShop cid: " + contact.getCid());
			System.out.println("\tShop sid: " + contact.getSid());
			System.out.println("\tShop type: " + contact.getType());
			System.out.println("\tShop info: " + contact.getInfo());
			System.out.println();
		}
	}
}
