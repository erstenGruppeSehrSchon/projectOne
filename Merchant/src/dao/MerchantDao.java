package dao;

import po.Merchant;

public interface MerchantDao {
	
	public Merchant getMerchantByMid(String mid);
	public Merchant getMerchantByUsername(String username);
	public Merchant addMerchant(Merchant merchant);
	public Merchant editMerchant(String mid, String password);
	public Merchant updateMerchantStatus(String mid, String status);

}
