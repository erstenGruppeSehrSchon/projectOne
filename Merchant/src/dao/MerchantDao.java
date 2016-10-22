package dao;

import po.Merchant;

public interface MerchantDao {
	
	public Merchant getMerchantByMid(int mid);
	public Merchant getMerchantByUsername(String username);
	public Merchant addMerchant(Merchant merchant);

}
