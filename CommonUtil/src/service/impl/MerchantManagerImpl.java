package service.impl;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import object.merchant.MeMerchant;
import object.merchant.Merchant;
import service.MerchantManager;

public class MerchantManagerImpl implements MerchantManager {
	
	private MerchantDao md = new MerchantDaoImpl();
	
	@Override
	public MeMerchant findMeMerchantById(int id) {
		return md.findMeMerchantById(id);
	}
	
	@Override
	public void setMerchant(Merchant adminMerchant) {
		md.setMerchant(adminMerchant);
	}

}
