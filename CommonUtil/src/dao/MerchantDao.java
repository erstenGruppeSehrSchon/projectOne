package dao;

import po.MeMerchant;
import po.Merchant;

public interface MerchantDao {
	
	public MeMerchant findMeMerchantById(int id);
	
	public void setMerchant(Merchant merchant);
}
