package service.impl;

import java.util.ArrayList;
import dao.AdminMerchantDao;
import dao.impl.AdminMerchantDaoImpl;
import object.merchant.AdminMerchant;
import service.AdminMerchantManager;

public class AdminMerchantManagerImpl implements AdminMerchantManager {
	
	AdminMerchantDao ad = new AdminMerchantDaoImpl();
	
	@Override
	public AdminMerchant getMerchantById(int id) {
		return ad.getMerchantById(id);
	}

	@Override
	public ArrayList<AdminMerchant> getAllMerchants() {
		return ad.getAllMerchants();
	}

	@Override
	public ArrayList<AdminMerchant> getOutstandingMerchants() {
		ArrayList<AdminMerchant> outstandingMerchants = ad.getMerchantByStatus(AdminMerchantDao.STATUS_PENDING);
		return outstandingMerchants;
	}

	@Override
	public boolean updateMerchantStatus(String status, int id) {
		return ad.updateMerchantStatus(status, id);
	}
}
