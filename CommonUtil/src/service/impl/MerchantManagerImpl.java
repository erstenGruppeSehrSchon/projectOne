package service.impl;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import object.merchant.AdminMerchant;
import object.merchant.MeMerchant;
import service.MerchantManager;

public class MerchantManagerImpl implements MerchantManager {
	private MerchantDao md = new MerchantDaoImpl();
	@Override
	public MeMerchant findMeMerchantById(int id) {
		return md.findMeMerchantById(id);
	}
	@Override
	public void setAdminMerchant(AdminMerchant adminMerchant) {
		// TODO Auto-generated method stub
		md.setAdminMerchant(adminMerchant);
	}

}
