package service.impl;

import java.util.ArrayList;

import common.po.Dish;
import dao.MerchantDishDao;
import dao.impl.MerchantDishDaoImpl;
import service.MerchantDishService;

public class MerchantDishServiceImpl implements  MerchantDishService{
	private MerchantDishDao dao = new MerchantDishDaoImpl();
	
	
	@Override
	public void updatedish(Dish dish) {
		dao.updatedish(dish);
		
	}

	@Override
	public void adddish(Dish dish) {
		dao.adddish(dish);
		
	}

	@Override
	public void deletedish(int did) {
		dao.deletedish(did);
		
	}

	@Override
	public Dish getDishByDid(int did) {
		// TODO Auto-generated method stub
		return dao.getDishByDid(did);
	}

	@Override
	public ArrayList<Dish> getDishBySid(int sid) {
		// TODO Auto-generated method stub
		return dao.getDishBySid(sid);
	}

	@Override
	public ArrayList<Dish> findAllDish() {
		// TODO Auto-generated method stub
		return dao.findAllDish();
	}

}
