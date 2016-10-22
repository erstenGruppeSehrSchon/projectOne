package service;

import java.util.List;
import po.ShopContact;

public interface ShopContactManager {

	public List<ShopContact> getShopContactsBySid(int sid);
	public ShopContact addShopContact(int sid, String type, String info);
	public boolean removeShopContact(int cid);
	public ShopContact updateShopContact(int cid, int sid, String type, String info);
	
}
