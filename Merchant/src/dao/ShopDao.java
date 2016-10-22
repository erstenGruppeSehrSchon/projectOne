package dao;

import po.Shop;

public interface ShopDao {

	public Shop getShopBySid(int sid);
	public Shop addShop(Shop shop);
	public boolean removeShop(int sid);
	public Shop updateShop(int sid, int mid, String name, String description);
	
}
