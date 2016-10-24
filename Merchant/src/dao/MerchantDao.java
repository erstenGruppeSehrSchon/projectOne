package dao;

import po.Merchant;

public interface MerchantDao {
	
	public Merchant getMerchantByMid(String mid);
	public Merchant getMerchantByUsername(String username);
	public Merchant addMerchant(Merchant merchant);

}
