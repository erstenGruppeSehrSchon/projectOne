package dao;

import object.merchant.Merchant;
import object.merchant.MeMerchant;

public interface MerchantDao {
	
	public MeMerchant findMeMerchantById(int id);
	
	public void setAdminMerchant(Merchant adminMerchant);
}
