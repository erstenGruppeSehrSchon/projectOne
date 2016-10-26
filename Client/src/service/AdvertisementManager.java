package service;

import java.util.List;

import po.Advertisement;

public interface AdvertisementManager {
	
	public List<Advertisement> getAllAdvertisement();
	public List<Advertisement> getLatestAdvertisement();

}
