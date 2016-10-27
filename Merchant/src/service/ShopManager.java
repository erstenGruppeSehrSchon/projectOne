package service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import po.Shop;

public interface ShopManager {

	public Shop getShopBySid(String sid);
	public Shop addShop(String mid, String name, String description, String type, String openTime, String closeTime, String address, String phone, List<MultipartFile> files);
	public boolean removeShop(String sid);
	public Shop updateShop(String sid, String name, String description, String type, String openTime, String closeTime, String address, String phone);
	
}
