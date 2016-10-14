package service;

import java.util.List;

import object.Admin;
import object.merchant.AdminMerchant;

public interface AdminService {
	
	public List<AdminMerchant> findOutstandingMerchants();
	public Admin loadUser(String id, String password);
	public List<AdminMerchant> findAllMerchants();

}
