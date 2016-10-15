package service;

import java.util.List;
import po.Dish;
import po.Shop;
import po.MeMerchant;

public interface MerchantProfileService {
	
	// retrieve merchant & shop info
	public MeMerchant retrieveMerchantInfo(int mid);
	
	// retrieve merchant's dish info
	public List<Dish> retrieveDishesByMid(int mid);
	
	// update both merchant & shop info
	public void updateMerchantInfo(MeMerchant merchant);
	
	// only update shop info
	public void updateShopInfo(List<Shop> shops);
}
