package dao;

import java.util.List;

import po.Dish;
import po.DishImage;
import po.Shop;
import po.ShopContact;
import po.MeMerchant;

public interface MerchantProfileDao {
	public MeMerchant retrieveMerchantByMid(int mid);
	public List<Shop> retrieveShopInfoByMid(int mid);
	public List<ShopContact> retrieveShopContactBySid(int sid);
	public List<Dish> retrieveDishesByMid(int mid);
	public List<DishImage> retrieveDishImagesByDid(int did);
	public boolean updateMerchantInfo(MeMerchant merchant, String oldPassword);
	public void updateShopInfo(Shop shop);
	public void updateShopContactInfo(ShopContact shopContact);
	public void updateMerchantStatus(int mid, String status);
}
