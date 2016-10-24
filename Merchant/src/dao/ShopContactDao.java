package dao;

import java.util.List;
import po.ShopContact;

public interface ShopContactDao {

	public List<ShopContact> getShopContactsBySid(String sid);
	public ShopContact addShopContact(ShopContact shopContact);
	public boolean removeShopContact(String cid);
	public ShopContact updateShopContact(String cid, String sid, String type, String info);
	
}
