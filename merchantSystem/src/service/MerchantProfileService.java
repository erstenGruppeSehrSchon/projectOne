package service;

import java.util.List;
import po.Dish;
import po.DishImage;
import po.Shop;
import po.ShopContact;
import po.MeMerchant;

public interface MerchantProfileService {
	
	// retrieve merchant only
	public MeMerchant retrieveMerchantOnly(int mid);
	
	//retrieve shop only
	public List<Shop> retrieveShopOnly(int mid);
	
	//retrieve shop contact only
	public List<ShopContact> retrieveShopContactOnly(int sid);
	
	// retrieve merchant & shop info
	public MeMerchant retrieveMerchantInfo(int mid);
	
	// retrieve merchant's dish info
	public List<Dish> retrieveDishesByMid(int mid);
	
	// retrieve merchant's dish info
	public List<DishImage> retrieveDishImagesByDid(int did);
	
	// update both merchant & shop info
	public boolean updateMerchantInfo(MeMerchant merchant, String oldPassword);
	
	// only update shop info
	public void updateShopInfo(Shop shop);
}
