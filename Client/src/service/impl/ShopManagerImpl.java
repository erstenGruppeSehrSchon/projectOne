package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.ShopDao;
import po.Shop;
import service.ShopManager;

@Service
public class ShopManagerImpl implements ShopManager {

	@Autowired
	private ShopDao dao;
	
	public ShopDao getDao() {
		return dao;
	}

	public void setDao(ShopDao dao) {
		this.dao = dao;
	}

	@Override
	public Shop getShopBySid(String sid) {
		return dao.getShopBySid(sid);
	}

	@Override
	public List<Shop> getShopsByName(String name) {
		return dao.getShopsByName(name);
	}

}
