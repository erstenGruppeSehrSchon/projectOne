package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import common.util.FileUploader;

import dao.ShopDao;

import po.Shop;
import service.ShopManager;

@Service
public class ShopManagerImpl implements ShopManager {

	@Autowired
	private ShopDao dao;
	
	public ShopDao getDao() {
		return dao;
	}

	public void setDao(ShopDao dao) {
		this.dao = dao;
	}

	@Override
	public Shop getShopBySid(int sid) {
		return dao.getShopBySid(sid);
	}

	@Override
	public Shop addShop(int mid, String name, String description, List<MultipartFile> files) {
		// Upload images
		FileUploader uploader = FileUploader.getFileUploader();
		ArrayList<String> imgPaths = uploader.upload(files);
		
		// Create shop object
		Shop shop = new Shop();
		shop.setMid(mid);
		shop.setName(name);
		shop.setDescription(description);
		if (imgPaths.size() > 0) {
			shop.setImgPath(imgPaths.get(0));
		}
		
		return dao.addShop(shop);
	}

	@Override
	public boolean removeShop(int sid) {
		return dao.removeShop(sid);
	}

	@Override
	public Shop updateShop(int sid, int mid, String name, String description) {
		return dao.updateShop(sid, mid, name, description);
	}

}
