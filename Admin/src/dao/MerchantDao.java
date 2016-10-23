package dao;

import java.util.List;
import po.Merchant;

public interface MerchantDao {

	public Merchant getMerchantByMid(int mid);
	public List<Merchant> getAllMerchants();
	public List<Merchant> getMerchantsByCriteria(Integer mid, String name, String gender, Integer ageIndex, String regDate, String status);
	public Merchant updateMerchantStatus(int mid, String status);
	
}
