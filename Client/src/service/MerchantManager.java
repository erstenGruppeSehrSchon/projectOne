package service;

import java.util.List;
import po.Merchant;

public interface MerchantManager {

	public Merchant getMerchantByMid(String mid);
	public List<Merchant> getAllMerchants();
	
}
