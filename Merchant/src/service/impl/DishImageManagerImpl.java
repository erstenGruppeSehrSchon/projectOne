package service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import common.util.FileUploader;
import dao.DishImageDao;
import po.DishImage;
import service.DishImageManager;

@Service
public class DishImageManagerImpl implements DishImageManager {

	@Autowired
	private DishImageDao dao;

	@Override
	public List<DishImage> addDishImages(String did, List<MultipartFile> files) {
		// Upload images
		FileUploader uploader = FileUploader.getFileUploader();
		ArrayList<String> imgPaths = uploader.upload(files);
		
		// Create dish image objects and persist
		List<DishImage> dishImages = new ArrayList<>();
		for (String imgPath : imgPaths) {
			DishImage dishImage = new DishImage();
			dishImage.setImgPath(imgPath);
			dishImages.add(dao.addDishImage(did, dishImage));
		}
		
		return dishImages;
	}

	@Override
	public boolean removeDishImage(String imgId) {
		return dao.removeDishImage(imgId);
	}

}
