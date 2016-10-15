package service;

import po.MeMerchant;
import po.Merchant;

public interface MerchantRegisterService {
	public int addMerchant(MeMerchant merchant);
	public MeMerchant searchMerchant(int mid);
}
