package dao;

import java.util.ArrayList;

import po.Shop;





public interface ShopDao {
	
	public Shop findShopById(int id);
	
	public ArrayList<Shop> findAllShop();

}
