package dao;

import common.po.MeMerchant;
import common.po.Merchant;

public interface MerchantRegisterDao {
	public int addMerchant(MeMerchant merchant);
	public int addMerchantWithoutShop(MeMerchant merchant);
	public MeMerchant searchMerchant(int mid);
}
