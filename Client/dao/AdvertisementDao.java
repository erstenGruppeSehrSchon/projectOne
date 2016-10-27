package dao;

import java.util.List;

import po.Advertisement;

public interface AdvertisementDao {
	
	public List<Advertisement> getAllAdvertisement();
	public List<Advertisement> getLatestAdvertisement();

}
