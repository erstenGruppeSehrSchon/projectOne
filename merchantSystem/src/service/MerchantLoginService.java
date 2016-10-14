package service;

public interface MerchantLoginService {
	public int checkMerchantExist(String username, String password);
	public String retrieveMerchantStatus(int mid);
}
