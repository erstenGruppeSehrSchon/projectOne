package dao;

import java.util.List;

import common.po.Dish;
import common.po.DishImage;
import common.po.Shop;
import common.po.ShopContact;
import common.po.MeMerchant;

public interface MerchantProfileDao {
	public MeMerchant retrieveMerchantByMid(int mid);
	public Shop retrieveShopBySid(int sid);
	public List<Shop> retrieveShopInfoByMid(int mid);
	public List<ShopContact> retrieveShopContactBySid(int sid);
	public List<Dish> retrieveDishesByMid(int mid);
	public List<Dish> retrieveDishesBySid(int sid);
	public List<DishImage> retrieveDishImagesByDid(int did);
	public boolean updateMerchantInfo(MeMerchant merchant, String oldPassword);
	public void updateShopInfo(Shop shop);
	public void updateShopContactInfo(ShopContact shopContact);
	public void updateMerchantStatus(int mid, String status);
}
