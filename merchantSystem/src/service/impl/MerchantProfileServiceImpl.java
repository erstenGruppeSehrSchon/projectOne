package service.impl;

import java.util.List;
import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;
import po.Dish;
import po.Shop;
import po.MeMerchant;
import service.MerchantProfileService;

public class MerchantProfileServiceImpl implements MerchantProfileService {
	private MerchantProfileDao dao = new MerchantProfileDaoImpl();
	
	@Override
	public MeMerchant retrieveMerchantInfo(int mid) {
		MeMerchant merchant = new MeMerchant();
		
		// retrieve from merchant table
		merchant = dao.retrieveMerchantByMid(mid);
		
		// retrieve from shop table
		merchant.setShopList(dao.retrieveShopInfoByMid(mid));
		
		// retrieve from shop contact table
		for(Shop shop : merchant.getShopList()){
			int sid = shop.getSid();
			shop.setShopContactList(dao.retrieveShopContactBySid(sid));
		}
		
		return merchant;
	}
	
	@Override
	public List<Dish> retrieveDishesByMid(int mid) {
		// retrieve from dish & dish image table
		List<Dish> dishes = dao.retrieveDishesByMid(mid);
		
		return dishes;
	}

	@Override
	public void updateMerchantInfo(MeMerchant merchant) {
		// update merchant info

	}

	@Override
	public void updateShopInfo(List<Shop> shops) {
		// update shop info according to mid & sid
		
		// update shop contact info according to sid & cid
	}



}
