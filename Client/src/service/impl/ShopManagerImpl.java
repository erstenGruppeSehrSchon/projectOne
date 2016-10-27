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
	
	@Override
	public Shop getShopBySid(String sid) {
		return dao.getShopBySid(sid);
	}

	@Override
	public List<Shop> getShopsByCriteria(String name, String type, String address) {
		return dao.getShopsByCriteria(name, type, address);
	}

	@Override
	public List<Shop> getAllShops() {
		return dao.getAllShops();
	}

}
