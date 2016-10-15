package dao;

import po.MeMerchant;
import po.Merchant;

public interface MerchantLoginDao {
	public int checkMerchantExist(String username, String password);
	public String retrieveMerchantStatus(int mid);
}
