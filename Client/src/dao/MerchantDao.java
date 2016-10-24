package dao;

import java.util.List;
import po.Merchant;

public interface MerchantDao {

	public Merchant getMerchantByMid(String mid);
	public List<Merchant> getAllMerchants();
	
}
