package service;

import java.util.List;
import po.Merchant;

public interface MerchantManager {

	public Merchant getMerchant(int id);
	public List<Merchant> getAllMerchants();
	public List<Merchant> getMerchantsByCriteria(Integer id, String name, String gender, Integer ageIndex, String regDate, String status);

}
