package common.service;

import common.po.MeMerchant;
import common.po.Merchant;

public interface MerchantManager {
	
	public MeMerchant findMeMerchantById(int id);
	public void setMerchant(Merchant adminMerchant);
	
}
