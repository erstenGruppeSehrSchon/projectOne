package service.impl;

import po.Shop;
import service.ShopManager;
import dao.ShopDao;
import dao.impl.ShopDaoImpl;

public class ShopManagerImpl implements ShopManager {
    private ShopDao shopdao = new ShopDaoImpl();
	@Override
	public Shop findShopById(int id) {
		return shopdao.findShopById(id);
	}

}
