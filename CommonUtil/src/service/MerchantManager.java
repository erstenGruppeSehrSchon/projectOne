package service;

import po.MeMerchant;
import po.Merchant;

public interface MerchantManager {
	
	public MeMerchant findMeMerchantById(int id);
	public void setMerchant(Merchant adminMerchant);
	
}
