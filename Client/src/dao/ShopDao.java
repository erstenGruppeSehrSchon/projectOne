package dao;

import java.util.List;
import po.Shop;

public interface ShopDao {

	public Shop getShopBySid(String sid);
	public List<Shop> getShopsByName(String name);
	
}
