package dao;

import java.util.Date;
import po.Shop;

public interface ShopDao {

	public Shop getShopBySid(String sid);
	public Shop addShop(String mid, Shop shop);
	public boolean removeShop(String sid);
	public Shop updateShop(String sid, String name, String description, String type, Date openTime, Date closeTime, String address, String phone);
	
}
