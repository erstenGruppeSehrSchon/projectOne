package service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import po.DishImage;

public interface DishImageManager {

	public List<DishImage> addDishImages(int did, List<MultipartFile> files);
	public boolean removeDishImage(int imgId);
	
}
