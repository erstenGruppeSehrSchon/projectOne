package service;

public interface MerchantLoginService {
	public boolean checkMerchantExist(String username, String password);
	public String retrieveMerchantStatus(String username, String password);
}
