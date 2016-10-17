package service;

import common.po.Shop;

public interface MerchantShopService {
	
	public int addMerchantShop(Shop s);
	
	public boolean updateShopImage(String s, int sid, int mid);

	public boolean updateShop(Shop shop);

}
