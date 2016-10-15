package service;

import object.merchant.Merchant;
import object.merchant.MeMerchant;

public interface MerchantManager {
	
	public MeMerchant findMeMerchantById(int id);
	public void setMerchant(Merchant adminMerchant);

}
