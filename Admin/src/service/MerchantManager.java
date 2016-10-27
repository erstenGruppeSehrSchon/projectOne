package service;

import java.util.List;
import po.Merchant;

public interface MerchantManager {

	public Merchant getMerchantByMid(String mid);
	public List<Merchant> getAllMerchants();
	public List<Merchant> getMerchantsByCriteria(String mid, String name, String gender, Integer ageIndex, String regDate, String status);
	public Merchant updateMerchantStatus(String mid, String status);
	public Merchant addMerchant(Merchant merchant);
	public List<Merchant> getMerchantByStatus(String status);
	
}
