package service;

import java.util.List;

import po.Advertisement;

public interface AdvertisementManager {

	public int countAdvertisementByStatus(String status);
	public List<Advertisement> getAdvertisementsByStatus(String status);
	public Advertisement updateAdvertisementStatus(String advId, String status);
	public void addAdvertisement(Advertisement adv);
	
}
