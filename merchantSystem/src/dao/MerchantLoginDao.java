package dao;

import object.merchant.MeMerchant;
import object.merchant.Merchant;

public interface MerchantLoginDao {
	public int checkMerchantExist(String username, String password);
	public String retrieveMerchantStatus(int mid);
}
