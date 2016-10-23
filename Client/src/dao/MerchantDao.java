package dao;

import java.util.List;
import po.Merchant;

public interface MerchantDao {

	public Merchant getMerchantByMid(int mid);
	public List<Merchant> getAllMerchants();
	
}
