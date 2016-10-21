package dao;

import java.util.List;
import po.Merchant;

public interface MerchantDao {

	public Merchant getMerchant(int id);
	public List<Merchant> getAllMerchants();
	public List<Merchant> getMerchantsByCriteria(Integer id, String name, String gender, Integer ageIndex, String regDate, String status);

}
