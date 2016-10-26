package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import po.Dish;
import po.DishImage;
import po.LoginResponse;
import po.Merchant;
import po.Shop;
import service.DishImageManager;
import service.DishManager;
import service.MerchantManager;
import service.ShopManager;

@Controller
public class MerchantController {
	
	// web service path
	private final static String register_path ="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/regist";

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
	public Merchant login(String username, String password) throws Exception {
		return merchantManager.login(username, password);
	
//		Client client = Client.create();
//		WebResource wr = client.resource(register_path);
//		
//		Form form= new Form();
//		form.add("username", username);
//		form.add("password", password);
//		
//		
//		ClientResponse resp = wr
//				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
//				.accept(MediaType.APPLICATION_JSON_TYPE)
//				.post(ClientResponse.class, form);
//		String rs = resp.getEntity(String.class);
//		
//		System.out.println(rs);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		LoginResponse r = mapper.readValue(rs.getBytes(), LoginResponse.class);
//		
//		System.out.println(r.getId()+"...."+r.getStatus());
//		
//		return r;
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
