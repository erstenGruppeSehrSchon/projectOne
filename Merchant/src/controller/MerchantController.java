package controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import po.Dish;
import po.DishImage;
import po.Merchant;
import po.Shop;
import service.DishImageManager;
import service.DishManager;
import service.MerchantManager;
import service.ShopManager;

@Controller
public class MerchantController {

	@Autowired
	private MerchantManager merchantManager;
	
	@Autowired
	private ShopManager shopManager;
	
	@Autowired
	private DishManager dishManager;
	
	@Autowired
	private DishImageManager dishImageManager;
	
	// Merchant Start
	@RequestMapping(value="login", method={RequestMethod.POST})
	@ResponseBody
	public Merchant login(String username, String password) {
		return merchantManager.login(username, password);
	}
	
	@RequestMapping(value="getMerchantByMid", method={RequestMethod.GET})
	@ResponseBody
	public Merchant getMerchantByMid(String mid) {
		return merchantManager.getMerchantByMid(mid);
	}
	
	@RequestMapping(value="register", method={RequestMethod.GET})
	@ResponseBody
	public Merchant register(String username, String password, String name, String gender, String birthDate) {
		return merchantManager.addMerchant(username, password, name, gender, birthDate);
	}
	// Merchant End
	
	// Shop Start
	@RequestMapping(value="getShopBySid", method={RequestMethod.GET})
	@ResponseBody
	public Shop getShopBySid(String sid) {
		return shopManager.getShopBySid(sid);
	}
	
	@RequestMapping(value="addShop", method={RequestMethod.GET})//Change later
	@ResponseBody
	public Shop addShop(String mid, String name, String description, String type, String openTime, String closeTime, List<MultipartFile> files) {
		return shopManager.addShop(mid, name, description, type, openTime, closeTime, files);
	}
	
	@RequestMapping(value="removeShop", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public boolean removeShop(String sid) {
		return shopManager.removeShop(sid);
	}
	
	@RequestMapping(value="updateShop", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Shop updateShop(String sid, String name, String description, String type, String openTime, String closeTime, String address, String phone) {
		return shopManager.updateShop(sid, name, description, type, openTime, closeTime, address, phone);
	}	
	// Shop End
	
	// Dish Start
	@RequestMapping(value="getDishByDid", method={RequestMethod.GET})
	@ResponseBody
	public Dish getDishByDid(String did) {
		return dishManager.getDishByDid(did);
	}
	
	@RequestMapping(value="getDishesBySid", method={RequestMethod.GET})
	@ResponseBody
	public List<Dish> getDishesBySid(String sid) {
		return dishManager.getDishesBySid(sid);
	}
	
	@RequestMapping(value="addDish", method={RequestMethod.GET})//Change later
	@ResponseBody
	public Dish addDish(String sid, String name, String type, float price, String description, List<MultipartFile> files) {
		return dishManager.addDish(sid, name, type, price, description, files);
	}
	
	@RequestMapping(value="removeDish", method={RequestMethod.GET})//Change later
	@ResponseBody
	public boolean removeDish(String did) {
		return dishManager.removeDish(did);
	}
	// Dish End
	
	// Dish Image Start
	@RequestMapping(value="addDishImages", method={RequestMethod.GET})//Change later
	@ResponseBody
	public List<DishImage> addDishImages(String did, List<MultipartFile> files) {
		return dishImageManager.addDishImages(did, files);
	}
	
	@RequestMapping(value="removeDishImage", method={RequestMethod.GET})//Change later
	@ResponseBody
	public boolean removeDishImage(String imgId) {
		return dishImageManager.removeDishImage(imgId);
	}
	// Dish Image End
}
