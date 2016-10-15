package dao;

import object.merchant.AdminMerchant;
import object.merchant.MeMerchant;

public interface MerchantDao {
	public MeMerchant findMeMerchantById(int id);
	
	public void setAdminMerchant(AdminMerchant adminMerchant);
}
