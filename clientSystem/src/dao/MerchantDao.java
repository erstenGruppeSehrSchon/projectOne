package dao;

import object.merchant.Merchant;
import object.merchant.MeMerchant;
import po.Merchant;

public interface MerchantDao {
<<<<<<< HEAD
	public Merchant findMeMerchantById(int id);
	

=======
	
	public MeMerchant findMeMerchantById(int id);
	
	public void setAdminMerchant(Merchant adminMerchant);
>>>>>>> Client_clientIndex
}
