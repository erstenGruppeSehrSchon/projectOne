package service;

import java.util.List;
import po.Merchant;

public interface MerchantManager {

	public Merchant getMerchantByMid(int mid);
	public List<Merchant> getAllMerchants();
	
}
