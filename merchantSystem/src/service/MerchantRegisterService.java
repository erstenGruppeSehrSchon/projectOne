package service;

import object.merchant.MeMerchant;
import object.merchant.Merchant;

public interface MerchantRegisterService {
	public int addMerchant(MeMerchant merchant);
	public MeMerchant searchMerchant(int mid);
}
