package service;

import java.util.List;
import po.ShopContact;

public interface ShopContactManager {

	public List<ShopContact> getShopContactsBySid(String sid);
	public ShopContact addShopContact(String sid, String type, String info);
	public boolean removeShopContact(String cid);
	public ShopContact updateShopContact(String cid, String sid, String type, String info);
	
}
