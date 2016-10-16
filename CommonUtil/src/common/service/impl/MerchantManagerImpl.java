package common.service.impl;

import common.dao.MerchantDao;
import common.dao.impl.MerchantDaoImpl;
import common.po.MeMerchant;
import common.po.Merchant;
import common.service.MerchantManager;


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
