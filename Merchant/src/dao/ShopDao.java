package dao;

import po.Shop;

public interface ShopDao {

	public Shop getShopBySid(String sid);
	public Shop addShop(Shop shop);
	public boolean removeShop(String sid);
	public Shop updateShop(String sid, String mid, String name, String description);
	
}
