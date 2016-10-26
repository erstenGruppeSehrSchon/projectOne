package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Advertisement;
import service.AdvertisementManager;
import dao.AdvertisementDao;
import dao.impl.AdvertisementDaoImpl;

@Service
public class AdvertisementManagerImpl implements AdvertisementManager {
	
	@Autowired
	AdvertisementDao dao = new AdvertisementDaoImpl();

	@Override
	public List<Advertisement> getAllAdvertisement() {
	List<Advertisement> advList = dao.getAllAdvertisement();
		return advList;
	}

	@Override
	public List<Advertisement> getLatestAdvertisement() {
		List<Advertisement> advLatestList = dao.getLatestAdvertisement();
		return advLatestList;
	}

}
