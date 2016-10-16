package dao;

import java.util.ArrayList;

import po.ShopContact;

public interface ShopContactDao {

	public ShopContact getShopContactsByCID(int cid);
	public ArrayList<ShopContact> getShopContactsBySID(int sid);
	
}
