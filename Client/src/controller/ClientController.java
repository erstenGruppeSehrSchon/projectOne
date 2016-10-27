package controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Address;
import po.Advertisement;
import po.Client;
import po.Dish;
import po.Merchant;
import po.Order;
import po.OrderDetail;
import po.Shop;
import service.AdvertisementManager;
import service.ClientManager;
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
	
	@Autowired 
	private ClientManager clientManager;
	
	@Autowired
	private AdvertisementManager advertisementManager;
	
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
	
	@RequestMapping(value="getShopsByCriteria", method={RequestMethod.GET})
	@ResponseBody
	public List<Shop> getShopsByName(String name, String type, String address) {
		return shopManager.getShopsByCriteria(name, type, address);
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
	
	@RequestMapping(value="getAllOrder", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public List<Order> getAllOrder() {
		return orderManager.getAllOrder();
	}
	
	@RequestMapping(value="getOrderByOid", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Order getOrderByOid(String oid) {
		return orderManager.getOrderByOid(oid);
	}
	
	@RequestMapping(value="addComment", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public Order addComment(String oid, String comment) {
		return null;
	}
	
	@RequestMapping(value="getOrderBySid", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public List<Order> getOrder(String Sid) {
		return orderManager.getOrderBySid(Sid);
	}
	
	
	
	// Order End
	
	//Client Start
	@RequestMapping(value="clientRegister", method={RequestMethod.GET})
	@ResponseBody
	public boolean clientRegister(String username, String password, Set<Address> addresses) {
		return clientManager.register(username, password, addresses);
	}
	
	@RequestMapping(value="clientLogin", method={RequestMethod.GET}) 
	@ResponseBody
	public Client clientLogin(String username, String password) {
		return clientManager.login(username, password);
	}
	
	//Client End
	
	//Advertisement Start
	
	@RequestMapping(value="getLatestAdv", method={RequestMethod.GET}) 
	@ResponseBody
	public List<Advertisement> getLatestAdv() {
		return advertisementManager.getLatestAdvertisement();
	}
	
	
	//Advertisement End
	
	//Comment Start
	
	@RequestMapping(value="getOrderWithCommentBySid", method={RequestMethod.GET}) // Change later
	@ResponseBody
	public List<Order> getOrderWithCommentBySid(String Sid) {

		List<Order> orderList = orderManager.getOrderBySid(Sid);
		List<Order> orderListWithComment = orderManager.getOrderBySid(Sid);
		
		for(Order order :orderList){
			if(!order.getComments().isEmpty()){
				orderListWithComment.add(order);
			}
		}
		return orderListWithComment;
	}
	
	//Comment End
}
