package dao;

import common.po.Shop;

public interface MerchantShopDao {
	
	public int addShop(Shop shop);
	
	public boolean updateShopImage(String s, int sid, int mid);
}
