package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Dish;
import po.Merchant;
import po.Order;
import po.OrderDetail;
import po.Shop;

import service.DishManager;
import service.MerchantManager;
import service.OrderManager;
import service.ShopManager;

@Controller
public class ClientController {

	@Autowired
	private MerchantManager merchantManager;
	
	@Autowired
	private ShopManager shopManager;
	
	@Autowired
	private DishManager dishManager;
	
	@Autowired
	private OrderManager orderManager;
	
	// Merchant Start
	@RequestMapping(value="getMerchantByMid", method={RequestMethod.GET})
	@ResponseBody
	public Merchant getMerchant(String mid) {
		return merchantManager.getMerchantByMid(mid);
	}
	
	@RequestMapping(value="getAllMerchants", method={RequestMethod.GET})
	@ResponseBody
	public List<Merchant> getAllMerchants() {
		return merchantManager.getAllMerchants();
	}
	// Merchant End
	
	// Shop Start
	@RequestMapping(value="getShopBySid", method={RequestMethod.GET})
	@ResponseBody
	public Shop getShopBySid(String sid) {
		return shopManager.getShopBySid(sid);
	}
	
	@RequestMapping(value="getShopsByName", method={RequestMethod.GET})
	@ResponseBody
	public List<Shop> getShopsByName(String name) {
		return shopManager.getShopsByName(name);
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
	
	@RequestMapping(value="getDishesByCriteria", method={RequestMethod.GET})
	@ResponseBody
	public List<Dish> getDishesBySid(String name, String type, Float lowerPrice, Float higherPrice) {
		return dishManager.getDishesByCriteria(name, type, lowerPrice, higherPrice);
	}
	// Dish End
	
	// Order Start
	@RequestMapping(value="addOrder", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Order addOrder(String sid, String deliveryAddress, List<OrderDetail> orderDetails) {
		return orderManager.addOrder(sid, deliveryAddress, orderDetails);
	}
	// Order End
}
