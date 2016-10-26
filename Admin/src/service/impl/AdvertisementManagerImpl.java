package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Advertisement;
import service.AdvertisementManager;
import dao.AdvertisementDao;

@Service
public class AdvertisementManagerImpl implements AdvertisementManager {
	
	@Autowired
	private AdvertisementDao dao;

	@Override
	public int countAdvertisementByStatus(String status) {
		return dao.countAdvertisementByStatus(status);
	}

	@Override
	public List<Advertisement> getAdvertisementsByStatus(String status) {
		return dao.getAdvertisementsByStatus(status);
	}

	@Override
	public Advertisement updateAdvertisementStatus(String advId, String status) {
		return dao.updateAdvertisementStatus(advId, status);
	}

}
