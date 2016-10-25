package controller;

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
import po.ShopContact;
import service.DishImageManager;
import service.DishManager;
import service.MerchantManager;
import service.ShopContactManager;
import service.ShopManager;

@Controller
public class MerchantController {

	@Autowired
	private MerchantManager merchantManager;
	
	@Autowired
	private ShopManager shopManager;
	
	@Autowired
	private ShopContactManager shopContactManager;
	
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
	public Shop addShop(String mid, String name, String description, List<MultipartFile> files) {
		return shopManager.addShop(mid, name, description, files);
	}
	
	@RequestMapping(value="removeShop", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public boolean removeShop(String sid) {
		return shopManager.removeShop(sid);
	}
	
	@RequestMapping(value="updateShop", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Shop updateShop(String sid, String mid, String name, String description) {
		return shopManager.updateShop(sid, mid, name, description);
	}	
	// Shop End
	
	// Shop Contact Start
	@RequestMapping(value="getShopContactsBySid", method={RequestMethod.GET})
	@ResponseBody
	public List<ShopContact> getShopContactsBySid(String sid) {
		return shopContactManager.getShopContactsBySid(sid);
	}
	
	@RequestMapping(value="addShopContact", method={RequestMethod.GET})//Change later
	@ResponseBody
	public ShopContact addShopContact(String sid, String type, String info) {
		return shopContactManager.addShopContact(sid, type, info);
	}
	
	@RequestMapping(value="removeShopContact", method={RequestMethod.GET})//Change later
	@ResponseBody
	public boolean removeShopContact(String cid) {
		return shopContactManager.removeShopContact(cid);
	}
	
	@RequestMapping(value="updateShopContact", method={RequestMethod.GET})//Change later
	@ResponseBody
	public ShopContact updateShopContact(String cid, String sid, String type, String info) {
		return shopContactManager.updateShopContact(cid, sid, type, info);
	}
	// Shop Contact End
	
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
	public Dish addDish(String sid, String name, String type, float price, int isActive, List<MultipartFile> files) {
		return dishManager.addDish(sid, name, type, price, isActive, files);
	}
	
	@RequestMapping(value="removeDish", method={RequestMethod.GET})//Change later
	@ResponseBody
	public boolean removeDish(String did) {
		return dishManager.removeDish(did);
	}
	
	@RequestMapping(value="updateDish", method={RequestMethod.GET})//Change later
	@ResponseBody
	public Dish updateDish(String did, String sid, String name, String type, float price, int isActive, List<MultipartFile> files) {
		return dishManager.updateDish(did, sid, name, type, price, isActive);
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