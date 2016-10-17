package service.impl;

import dao.MerchantShopDao;
import dao.impl.MerchantShopDaoImpl;
import common.po.Shop;
import service.MerchantShopService;

public class MerchantShopServiceImpl implements MerchantShopService {
	public MerchantShopDao dao = new MerchantShopDaoImpl();
	
	@Override
	public int addMerchantShop(Shop s) {
		
		return dao.addShop(s);
	}

}
