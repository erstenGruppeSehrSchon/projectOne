package service;

import java.util.List;
import po.Merchant;

public interface MerchantManager {

	public Merchant getMerchantByMid(int mid);
	public List<Merchant> getAllMerchants();
	public List<Merchant> getMerchantsByCriteria(Integer mid, String name, String gender, Integer ageIndex, String regDate, String status);

}
