package service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import po.Shop;

public interface ShopManager {

	public Shop getShopBySid(int sid);
	public Shop addShop(int mid, String name, String description, List<MultipartFile> files);
	public boolean removeShop(int sid);
	public Shop updateShop(int sid, int mid, String name, String description);
	
}
