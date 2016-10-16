package service.impl;

import java.util.ArrayList;
import po.Dish;
import dao.DishDao;
import dao.impl.DishDaoImpl;

import service.ClientViewMerchantDishService;

public class ClientViewMerchantDishServiceImpl implements ClientViewMerchantDishService{
	
	private DishDao dish = new DishDaoImpl();

	
	
	@Override
	public ArrayList<Dish> findAllDish() {
		return (ArrayList<Dish>) dish.findAllDish();
	}

	@Override
	public ArrayList<Dish> loadDishBySid(int sid) {
		// TODO Auto-generated method stub
		return dish.getDishBySid(sid);
	}

	@Override
	public Dish loadDishByDid(int did) {
		// TODO Auto-generated method stub
		return dish.getDishByDid(did);
	}

}
