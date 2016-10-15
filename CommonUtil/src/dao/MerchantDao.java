package dao;

import object.merchant.MeMerchant;
import object.merchant.Merchant;

public interface MerchantDao {
	
	public MeMerchant findMeMerchantById(int id);
	
	public void setMerchant(Merchant merchant);
}
