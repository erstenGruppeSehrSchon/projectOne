package service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;
import po.DishImage;

public interface DishImageManager {

	public List<DishImage> addDishImages(String did, List<MultipartFile> files, ServletContext context);
	public boolean removeDishImage(String imgId);
	
}
