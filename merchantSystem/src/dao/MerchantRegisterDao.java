package dao;

import po.MeMerchant;
import po.Merchant;

public interface MerchantRegisterDao {
	public int addMerchant(MeMerchant merchant);
	public int addMerchantWithoutShop(MeMerchant merchant);
	public MeMerchant searchMerchant(int mid);
}
