package dao;

import java.util.List;

import object.Admin;
import object.merchant.AdminMerchant;

public interface AdminDao {
	
	public Admin loadUser(String id, String password);
	public List<AdminMerchant> findAllMerchants();

}
