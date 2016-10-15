package dao;

import java.util.ArrayList;
import object.Shop;

public interface ShopDao {
	
	public Shop findShopById(int id);
	
	public ArrayList<Shop> findAllShop();

}
