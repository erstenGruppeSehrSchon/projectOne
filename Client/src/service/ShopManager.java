package service;

import java.util.List;
import po.Shop;

public interface ShopManager {
	
	public Shop getShopBySid(int sid);
	public List<Shop> getShopsByName(String name);
	
}
