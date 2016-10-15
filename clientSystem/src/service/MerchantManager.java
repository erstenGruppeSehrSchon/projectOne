package service;

import object.merchant.AdminMerchant;
import object.merchant.MeMerchant;

public interface MerchantManager {
	public MeMerchant findMeMerchantById(int id);
	
	public void setAdminMerchant(AdminMerchant adminMerchant);
}
