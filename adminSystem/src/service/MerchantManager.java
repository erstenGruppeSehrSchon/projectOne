package service;

import java.util.ArrayList;
import common.po.Merchant;

public interface MerchantManager {
	
	public Merchant getMerchantById(int id);
	public ArrayList<Merchant> getAllMerchants();
	public ArrayList<Merchant> getOutstandingMerchants();
	public boolean updateMerchantStatus(String status, int id);
	
}
