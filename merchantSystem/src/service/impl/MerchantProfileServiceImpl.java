package service.impl;

import java.util.List;
import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;
import po.Dish;
import po.DishImage;
import po.Shop;
import po.ShopContact;
import po.MeMerchant;
import service.MerchantProfileService;

public class MerchantProfileServiceImpl implements MerchantProfileService {
	private MerchantProfileDao dao = new MerchantProfileDaoImpl();
	
	// retrieve merchant only
	@Override
	public MeMerchant retrieveMerchantOnly(int mid){
		MeMerchant merchant = new MeMerchant();

		// retrieve from merchant table
		merchant = dao.retrieveMerchantByMid(mid);
		
		return merchant;
	}
	
	//retrieve shop only
	@Override
	public List<Shop> retrieveShopOnly(int mid){
		// retrieve from shop table
		return dao.retrieveShopInfoByMid(mid);
	}
	
	//retrieve shop contact only
	@Override
	public List<ShopContact> retrieveShopContactOnly(int sid){
		// retrieve from shop contact table
		return dao.retrieveShopContactBySid(sid);
	}
	
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
	
	// retrieve merchant's dish info
	@Override
	public List<DishImage> retrieveDishImagesByDid(int did){
		List<DishImage> images = dao.retrieveDishImagesByDid(did);
		
		return images;
	}

	@Override
	public void updateMerchantInfo(MeMerchant merchant) {
		// update merchant info

	}

	@Override
	public void updateShopInfo(Shop shop) {
		// update shop info according to mid & sid
		
		// update shop contact info according to sid & cid
	}



}
