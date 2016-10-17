package service;

import java.util.List;
import common.po.Dish;
import common.po.DishImage;
import common.po.Shop;
import common.po.ShopContact;
import common.po.MeMerchant;

public interface MerchantProfileService {
	
	// retrieve merchant only
	public MeMerchant retrieveMerchantOnly(int mid);
	
	//retrieve shop by sid
	public Shop retrieveShopBySid(int sid);
	
	//retrieve shop only
	public List<Shop> retrieveShopOnly(int mid);
	
	//retrieve shop contact only
	public List<ShopContact> retrieveShopContactOnly(int sid);
	
	// retrieve merchant & shop info
	public MeMerchant retrieveMerchantInfo(int mid);
	
	// retrieve merchant's dish info
	public List<Dish> retrieveDishesByMid(int mid);
	
	// retrieve merchant's dish info by sid
	public List<Dish> retrieveDishesBySid(int sid);
	
	// retrieve merchant's dish info by did
	public List<DishImage> retrieveDishImagesByDid(int did);
	
	// update both merchant & shop info
	public boolean updateMerchantInfo(MeMerchant merchant, String oldPassword);
	
	// Update merchant status
	public void updateMerchantStatus(int mid, String status);
	
	// only update shop info
	public void updateShopInfo(Shop shop);
}
