package dao;

import java.util.List;

import object.Dish;
import object.Shop;
import object.ShopContact;
import object.merchant.MeMerchant;

public interface MerchantProfileDao {
	public MeMerchant retrieveMerchantByMid(int mid);
	public List<Shop> retrieveShopInfoByMid(int mid);
	public List<ShopContact> retrieveShopContactBySid(int sid);
	public List<Dish> retrieveDishesByMid(int mid);
	public void updateMerchantInfo(MeMerchant merchant);
	public void updateShopInfo(Shop shop);
	public void updateShopContactInfo(ShopContact shopContact);
	
}
