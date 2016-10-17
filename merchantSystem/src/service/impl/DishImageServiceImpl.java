package service.impl;

import dao.DishImageDao;
import dao.impl.DishImageDaoImpl;

import service.DishImageService;

public class DishImageServiceImpl implements DishImageService {

	private DishImageDao did = new DishImageDaoImpl();
	
	@Override
	public void addDishImage(int sid, String url) {
		did.addDishImage(sid, url);
		
	}

}
