package dao;

import object.merchant.MeMerchant;
import object.merchant.Merchant;

public interface MerchantRegisterDao {
	public int addMerchant(MeMerchant merchant);
	public int addMerchantWithoutShop(MeMerchant merchant);
	public MeMerchant searchMerchant(int mid);
}
