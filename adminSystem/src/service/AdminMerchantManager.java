package service;

import java.util.ArrayList;
import object.merchant.AdminMerchant;

public interface AdminMerchantManager {
	
	public AdminMerchant getMerchantById(int id);
	public ArrayList<AdminMerchant> getAllMerchants();
	public ArrayList<AdminMerchant> getOutstandingMerchants();
	
}
