package dao;

import java.util.List;

import po.Advertisement;

public interface AdvertisementDao {

	public int countAdvertisementByStatus(String status);
	public List<Advertisement> getAdvertisementsByStatus(String status);
	public void updateAdvertisementStatus(Integer advId, String status);
	
}
