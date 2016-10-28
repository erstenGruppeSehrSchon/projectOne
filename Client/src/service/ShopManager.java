package service;

import java.util.List;
import po.Shop;

public interface ShopManager {
	
	public Shop getShopBySid(String sid);
	public List<Shop> getShopsByCriteria(String name, String type, String address);
	public List<Shop> getAllShops();
	public Shop getShopByDid(String did);
}
