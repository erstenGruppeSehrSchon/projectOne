package service.impl;

import java.util.ArrayList;
import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import po.Merchant;
import service.MerchantManager;

public class MerchantManagerImpl implements MerchantManager {
	
	MerchantDao md = new MerchantDaoImpl();
	
	@Override
	public Merchant getMerchantById(int id) {
		return md.getMerchantById(id);
	}

	@Override
	public ArrayList<Merchant> getAllMerchants() {
		return md.getAllMerchants();
	}

	@Override
	public ArrayList<Merchant> getOutstandingMerchants() {
		ArrayList<Merchant> outstandingMerchants = md.getMerchantByStatus(Merchant.STATUS_PENDING);
		return outstandingMerchants;
	}

	@Override
	public boolean updateMerchantStatus(String status, int id) {
		return md.updateMerchantStatus(status, id);
	}
}
