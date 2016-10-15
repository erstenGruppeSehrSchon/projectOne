package dao;

import java.util.ArrayList;

import po.Merchant;

public interface MerchantDao {
	
	public ArrayList<Merchant> getAllMerchants();
	public Merchant getMerchantById(int id);
	public ArrayList<Merchant> getMerchantByStatus(String status);
	public ArrayList<Merchant> getMerchantByCriteria(Integer id, String name, Integer ageIndex, String gender, String regDate);
	public boolean updateMerchantStatus(String status, int id);

}
