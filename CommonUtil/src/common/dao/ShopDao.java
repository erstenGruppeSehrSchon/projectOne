package common.dao;

import java.util.ArrayList;

import common.po.Shop;


public interface ShopDao {
	
	public Shop findShopById(int id);
	
	public ArrayList<Shop> findAllShop();

}
