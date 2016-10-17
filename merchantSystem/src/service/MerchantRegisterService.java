package service;

import common.po.MeMerchant;
import common.po.Merchant;

public interface MerchantRegisterService {
	public int addMerchant(MeMerchant merchant);
	public MeMerchant searchMerchant(int mid);
}
