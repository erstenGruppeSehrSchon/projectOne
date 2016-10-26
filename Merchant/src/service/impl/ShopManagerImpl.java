package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import common.util.DateFormatter;
import common.util.FileUploader;

import dao.ShopDao;

import po.Shop;
import service.ShopManager;

@Service
public class ShopManagerImpl implements ShopManager {

	@Autowired
	private ShopDao dao;

	@Override
	public Shop getShopBySid(String sid) {
		return dao.getShopBySid(sid);
	}

	@Override
	public Shop addShop(String mid, String name, String description, String type, String openTime, String closeTime, List<MultipartFile> files) {
		// Upload images
		ArrayList<String> imgPaths = new ArrayList<>();
		imgPaths.add("test.jpg");
		if (files != null) {
			FileUploader uploader = FileUploader.getFileUploader();
			imgPaths = uploader.upload(files);
		}
		
		// Format open and close time
		DateFormatter formatter = DateFormatter.getDateFormatter();
		Date formattedOpenTime = formatter.parse(openTime);
		Date formattedCloseTime = formatter.parse(closeTime);
		
		// Create shop object
		Shop shop = new Shop();
		shop.setName(name);
		shop.setDescription(description);
		shop.setType(type);
		shop.setOpenTime(formattedOpenTime);
		shop.setCloseTime(formattedCloseTime);
		shop.setImgPath(imgPaths.get(0));
		
		return dao.addShop(mid, shop);
	}

	@Override
	public boolean removeShop(String sid) {
		return dao.removeShop(sid);
	}

	@Override
	public Shop updateShop(String sid, String name, String description, String type, String openTime, String closeTime, String address, String phone) {
		// Format open and close time
		DateFormatter formatter = DateFormatter.getDateFormatter();
		Date formattedOpenTime = formatter.parse(openTime);
		Date formattedCloseTime = formatter.parse(closeTime);
		
		return dao.updateShop(sid, name, description, type, formattedOpenTime, formattedCloseTime, address, phone);
	}

}
