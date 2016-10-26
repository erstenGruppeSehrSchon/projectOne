package dao;

import java.util.List;

import po.Advertisement;

public interface AdvertisementDao {

	public List<Advertisement> getAdvertisementBySid(String sid);
	public Advertisement addAdvertisement(String sid, Advertisement advertisement);
	public void updateAdvertisementStatus(String sid,String status);

}
