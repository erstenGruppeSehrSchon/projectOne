package service;

import java.util.List;
import po.Shop;

public interface ShopManager {
	
	public Shop getShopBySid(String sid);
	public List<Shop> getShopsByName(String name);
	public List<Shop> getAllShops();
}
