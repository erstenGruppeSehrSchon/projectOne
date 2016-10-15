package service.impl;

import java.util.ArrayList;
import po.Dish;
import dao.DishDao;
import dao.impl.DishDaoImpl;

import service.ClientViewMerchantDishService;

public class ClientViewMerchantDishServiceImpl implements ClientViewMerchantDishService{
	
	private DishDao dish = new DishDaoImpl();

	@Override
	public Dish loadDish(int id) {
		return dish.getDishByDid(id);
		
	}
	
	@Override
	public ArrayList<Dish> findAllDish() {
		return dish.findAllDish();
	}

}
