package service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import common.util.FileUploader;

import dao.DishDao;
import po.Dish;
import po.DishImage;
import service.DishManager;

@Service
public class DishManagerImpl implements DishManager {

	@Autowired
	private DishDao dao;

	public DishDao getDao() {
		return dao;
	}

	public void setDao(DishDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Dish getDishByDid(int did) {
		return dao.getDishByDid(did);
	}
	
	@Override
	public List<Dish> getDishesBySid(int sid) {
		return dao.getDishesBySid(sid);
	}

	@Override
	public Dish addDish(int sid, String name, String type, float price, int isActive, List<MultipartFile> files) {
		// Upload images
		FileUploader uploader = FileUploader.getFileUploader();
		ArrayList<String> imgPaths = uploader.upload(files);
		
		// Create dish image objects
		Set<DishImage> dishImages = new HashSet<>();
		for (String imgPath : imgPaths) {
			DishImage dishImage = new DishImage();
			dishImage.setImgPath(imgPath);
			dishImages.add(dishImage);
		}
		
		// Create dish object
		Dish dish = new Dish();
		dish.setSid(sid);
		dish.setName(name);
		dish.setType(type);
		dish.setPrice(price);
		dish.setIsActive(isActive);
		dish.setDishImages(dishImages);
		
		return dish;
	}

	@Override
	public boolean removeDish(int did) {
		return dao.removeDish(did);
	}

	@Override
	public Dish updateDish(int did, int sid, String name, String type, float price, int isActive) {
		return dao.updateDish(did, sid, name, type, price, isActive);
	}

}
