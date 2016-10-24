package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ShopContactDao;
import po.ShopContact;
import service.ShopContactManager;

@Service
public class ShopContactManagerImpl implements ShopContactManager {

	@Autowired
	private ShopContactDao dao;
	
	public ShopContactDao getDao() {
		return dao;
	}

	public void setDao(ShopContactDao dao) {
		this.dao = dao;
	}

	@Override
	public List<ShopContact> getShopContactsBySid(String sid) {
		return dao.getShopContactsBySid(sid);
	}

	@Override
	public ShopContact addShopContact(String sid, String type, String info) {
		// Create shop contact object
		ShopContact shopContact = new ShopContact();
		shopContact.setSid(sid);
		shopContact.setType(type);
		shopContact.setInfo(info);
		
		// Add shop contact and return
		return dao.addShopContact(shopContact);
	}

	@Override
	public boolean removeShopContact(String cid) {
		return dao.removeShopContact(cid);
	}

	@Override
	public ShopContact updateShopContact(String cid, String sid, String type, String info) {
		return dao.updateShopContact(cid, sid, type, info);
	}

}
