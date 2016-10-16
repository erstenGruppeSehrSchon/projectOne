package service.impl;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;

import po.Merchant;
import service.MerchantManager;

public class MerchantManagerImpl implements MerchantManager {
	private MerchantDao md = new MerchantDaoImpl();
	@Override
	public Merchant findMeMerchantById(int id) {
		return md.findMeMerchantById(id);
	}


}
