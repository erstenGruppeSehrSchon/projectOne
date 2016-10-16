package common.dao;

import common.po.MeMerchant;
import common.po.Merchant;

public interface MerchantDao {
	
	public MeMerchant findMeMerchantById(int id);
	
	public void setMerchant(Merchant merchant);
}
