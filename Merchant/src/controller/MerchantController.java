package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import po.Advertisement;
import po.Dish;
import po.DishImage;
import po.Merchant;
import po.Order;
import po.OrderDetail;
import po.Shop;
import service.AdvertisementManager;
import service.DishImageManager;
import service.DishManager;
import service.MerchantManager;
import service.OrderManager;
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
	
	@Autowired
	private OrderManager orderManager;
	
	@Autowired
	private AdvertisementManager advertisementManager;
	
	// Merchant Start
	@RequestMapping(value="login", method={RequestMethod.POST})
	@ResponseBody
	public ModelAndView login(String username, String password) {
		
		ModelAndView mv = new ModelAndView();
		Merchant merchant = merchantManager.login(username, password);
		
		// stay on login page if user not exist
		if(merchant != null){
			
			// merchant status
			if(merchant.getStatus() != null && merchant.getStatus().equals("Accepted")){
				mv.setViewName("index");
				mv.addObject("merchant", merchant);
			}
			else{
				mv.setViewName("login");
				mv.addObject("error", "Invalid account");
			}
			
		}
		else{
			mv.setViewName("login");
			mv.addObject("error", "User not exist!");
		}
		
		return mv;
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
	
	// Order Start
	@RequestMapping(value="getOrdersBySid", method={RequestMethod.GET})
	@ResponseBody
	public List<Order> getOrdersBySid(String sid) {
		return orderManager.getOrdersBySid(sid);
	}
	
	@RequestMapping(value="updateOrderStatus", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Order updateOrderStatus(String oid, String status) {
		return orderManager.updateOrderStatus(oid, status);
	}
	
	@RequestMapping(value="replyOrderComment", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Order replyOrderComment(String oid, String reply) {
		return orderManager.replyOrderComment(oid, reply);
	}
	// Order End
	
	// Advertisement Start
	@RequestMapping(value="getAdvertisementBySid", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public List<Advertisement> getAdvertisementBySid(String sid) {
		return advertisementManager.getAdvertisementBySid(sid);
	}
	
	@RequestMapping(value="addAdvertisement", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Advertisement addAdvertisement(String sid, List<MultipartFile> files) {
		return advertisementManager.addAdvertisement(sid, files);
	}
	// Advertisement End
}
