package service;

import po.Merchant;

public interface MerchantManager {

	public Merchant login(String username, String password);
	public Merchant getMerchantByMid(String mid);
	public Merchant addMerchant(String username, String password, String name, String gender, String birthDate);
	
}
