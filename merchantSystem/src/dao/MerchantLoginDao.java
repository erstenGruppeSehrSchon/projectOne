package dao;

import common.po.MeMerchant;
import common.po.Merchant;

public interface MerchantLoginDao {
	public int checkMerchantExist(String username, String password);
	public String retrieveMerchantStatus(int mid);
}
