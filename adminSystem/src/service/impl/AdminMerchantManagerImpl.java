package service.impl;

import dao.AdminMerchantDao;
import dao.impl.AdminMerchantDaoImpl;
import object.merchant.MeMerchant;
import service.AdminMerchantManager;

public class AdminMerchantManagerImpl implements AdminMerchantManager {
	AdminMerchantDao ad = new AdminMerchantDaoImpl();
	@Override
	public MeMerchant findMeMerchantById(int id) {
		return ad.findMeMerchantById(id);
	}

}
