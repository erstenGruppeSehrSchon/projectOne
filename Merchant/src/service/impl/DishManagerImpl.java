package service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import common.util.FileUploader;

import dao.DishDao;
import dao.DishImageDao;
import po.Dish;
import po.DishImage;
import service.DishManager;

@Service
public class DishManagerImpl implements DishManager {

	@Autowired
	private DishDao dishDao;
	
	@Autowired
	private DishImageDao dishImageDao;
	
	@Override
	public Dish getDishByDid(String did) {
		return dishDao.getDishByDid(did);
	}
	
	@Override
	public List<Dish> getDishesBySid(String sid) {
		return dishDao.getDishesBySid(sid);
	}

	@Override
	public Dish addDish(String sid, String name, String type, float price, String description, List<MultipartFile> files, ServletContext context) {
		// Upload images
		FileUploader uploader = FileUploader.getFileUploader();
		ArrayList<String> imgPaths = uploader.upload(files, context);
		
		// Create dish object
		Dish dish = new Dish();
		dish.setName(name);
		dish.setDescription(description);
		dish.setType(type);
		dish.setPrice(price);
		
		Dish returnedDish = dishDao.addDish(sid, dish);
		
		// Create dish image objects
		Set<DishImage> dishImages = new HashSet<>();
		for (String imgPath : imgPaths) {
			DishImage dishImage = new DishImage();
			dishImage.setImgPath(imgPath);
			dishImages.add(dishImageDao.addDishImage(returnedDish.getDid(), dishImage));
		}
		
		// Store dish images to dish
		dish.setDishImages(dishImages);
		
		// Add dish and return
		return returnedDish;
	}

	@Override
	public boolean removeDish(String did) {
		return dishDao.removeDish(did);
	}

}
