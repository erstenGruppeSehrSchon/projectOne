package dao;

import java.util.ArrayList;

import object.merchant.AdminMerchant;

public interface AdminMerchantDao {
	
	// Should put on AdminMerchant class
	public final String STATUS_ACCEPT = "Accepted";
	public final String STATUS_PENDING = "Pending";
	public final String STATUS_REJECT = "Rejected";
	public final String STATUS_FROZEN = "Frozen";
	
	public ArrayList<AdminMerchant> getAllMerchants();
	public AdminMerchant getMerchantById(int id);
	public ArrayList<AdminMerchant> getMerchantByStatus(String status);
	public ArrayList<AdminMerchant> getMerchantByCriteria(Integer id, String name, Integer ageIndex, String gender, String regDate);
	public boolean updateMerchantStatus(String status, int id);

}
