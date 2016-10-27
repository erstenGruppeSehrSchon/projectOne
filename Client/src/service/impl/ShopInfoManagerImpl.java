package service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import dao.DishDao;
import dao.OrderDao;
import dao.ShopDao;
import po.Dish;
import po.Order;
import po.Shop;
import service.ShopInfoManager;

@Service
public class ShopInfoManagerImpl implements ShopInfoManager {
	@Autowired
	private ShopDao shopDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private DishDao dishDao;
	
	@Override
	public ModelAndView getShopInfoBySid(String sid) {
		ModelAndView mv = new ModelAndView();
		Shop shop = shopDao.getShopBySid(sid);
		mv.addObject("shop", shop);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String opening = sdf.format(shop.getOpenTime())+" ~ "+sdf.format(shop.getCloseTime());  
		mv.addObject("opening", opening);
		List<Order> orderList = orderDao.getOrderBySid(sid);
		int score = 0;
		for (Order o : orderList){
			score += o.getRating();
		}
		mv.addObject("score", score);
		mv.setViewName("shopDetails");
		return mv;
	}
	
	@Override
	public ModelAndView getDishInfoByDid(String did,String sid){
		ModelAndView mv = new ModelAndView();
		Shop shop = shopDao.getShopBySid(sid);
		mv.addObject("shop", shop);
		
		Dish dish = dishDao.getDishByDid(did);
		mv.addObject("dish",dish);
		
		
		mv.setViewName("dishDetails");
		return mv;
	}
	
	

}
