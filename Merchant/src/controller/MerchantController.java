package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import po.Advertisement;
import po.Dish;
import po.DishImage;
import po.Merchant;
import po.Order;
import po.Shop;
import service.AdvertisementManager;
import service.DishImageManager;
import service.DishManager;
import service.MerchantManager;
import service.OrderManager;
import service.ShopManager;
import javax.servlet.ServletContext;

@Controller
@SessionAttributes("merchant")
public class MerchantController {

	@Autowired
	ServletContext context;
	
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
			else if(merchant.getStatus() != null && merchant.getStatus().equals("Pending")){
				mv.setViewName("login");
				mv.addObject("error", "Your registration is still pending...");
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
	
	@RequestMapping(value="register", method={RequestMethod.POST})
	@ResponseBody
	public ModelAndView register(String username, String password, String name, String gender, String birthDate) {		
		ModelAndView mv = new ModelAndView();
		Merchant merchant = merchantManager.addMerchant(username, password, name, gender, birthDate);
		
		// add success
		if(merchant != null){
			mv.setViewName("login");
			mv.addObject("merchant", merchant);
		}
		else{
			mv.setViewName("merchantAdd");
			mv.addObject("error", "Register Fail!");
		}
		
		return mv;
	}
	@RequestMapping(value="editMerchant", method={RequestMethod.POST})
	@ResponseBody
	public ModelAndView editMerchant(String mid, String password) {	
		ModelAndView mv = new ModelAndView();
		Merchant merchant = merchantManager.editMerchant(mid, password);
		// add success
		if(merchant != null){
			mv.setViewName("login");
			mv.addObject("merchant", merchant);
		}
		
		
		return mv;
	}
	
	// Merchant End
	
	// Shop Start
	@RequestMapping(value="getShopBySid", method={RequestMethod.GET})
	@ResponseBody
	public Shop getShopBySid(String sid) {
		return shopManager.getShopBySid(sid);
	}
	
	@RequestMapping(value="addShop", method={RequestMethod.POST})
	public ModelAndView addShop(String mid, String name, String description, String type, String openTime, String closeTime, String address, String phone, List<MultipartFile> files) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("shopIndex");
		
		shopManager.addShop(mid, name, description, type, openTime, closeTime, address, phone, files, context);
		
		// Need to update merchant object if to index page
		
		return modelAndView;
	}
	
	@RequestMapping(value="removeShop", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public boolean removeShop(String sid) {
		return shopManager.removeShop(sid);
	}
	
	@RequestMapping(value="showShopUpdatePage", method={RequestMethod.GET})
	public ModelAndView showShopUpdatePage(String sid) {
		ModelAndView modelAndView = new ModelAndView();
		
		// Store shop information
		Shop shop = shopManager.getShopBySid(sid);
		modelAndView.addObject("shop", shop);
		
		// Set page
		modelAndView.setViewName("shopEdit");
		
		return modelAndView;
	}
	
	@RequestMapping(value="updateShop", method={RequestMethod.POST})
	public ModelAndView updateShop(String sid, String name, String description, String type, String openTime, String closeTime, String address, String phone) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("shopIndex");
		
		shopManager.updateShop(sid, name, description, type, openTime, closeTime, address, phone);
		
		// Need to update merchant object if to index page
		
		return modelAndView;
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
		return dishManager.addDish(sid, name, type, price, description, files, context);
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
		return dishImageManager.addDishImages(did, files, context);
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
	
	@RequestMapping(value="getOrdersByMid", method={RequestMethod.GET})
	@ResponseBody
	public List<Order> getOrdersByMid(String mid) {
		Merchant m = merchantManager.getMerchantByMid(mid);
		List<Order> result = new ArrayList<Order>();
		
		for(Shop s: m.getShops()){
			result.addAll(orderManager.getOrdersBySid(s.getSid()));
		}
		return result;
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
	
	@RequestMapping(value="getAdvertisementByMid", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public List<Advertisement> getAdvertisementByMid(String mid) {
		Merchant m = merchantManager.getMerchantByMid(mid);
		List<Advertisement> result = new ArrayList<Advertisement>();
		
		for(Shop s: m.getShops()){
			result.addAll(advertisementManager.getAdvertisementBySid(s.getSid()));
		}
		return result;
	}
	
	@RequestMapping(value="addAdvertisement", method={RequestMethod.POST}) // Change later
	@ResponseBody
	public ModelAndView addAdvertisement(String sid, List<MultipartFile> files) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adsIndex");
		return mv;
	}
	// Advertisement End
}
