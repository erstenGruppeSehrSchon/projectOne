package service.impl;

import dao.ShopDao;
import dao.impl.ShopDaoImpl;
import po.Shop;
import service.ShopManager;

public class ShopManagerImpl implements ShopManager {
    
	private ShopDao shopdao = new ShopDaoImpl();
	
	@Override
	public Shop findShopById(int id) {
		return shopdao.findShopById(id);
	}

}
