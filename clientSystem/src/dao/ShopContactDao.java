package dao;

import java.util.ArrayList;

import object.ShopContact;

public interface ShopContactDao {

	public ShopContact getShopContactsByCID(int cid);
	public ArrayList<ShopContact> getShopContactsBySID(int sid);
	
}
