package dao;

import java.util.List;
import po.ShopContact;

public interface ShopContactDao {

	public List<ShopContact> getShopContactsBySid(int sid);
	public ShopContact addShopContact(ShopContact shopContact);
	public boolean removeShopContact(int cid);
	public ShopContact updateShopContact(int cid, int sid, String type, String info);
	
}
