package service;

import java.util.ArrayList;

import common.po.Dish;

public interface MerchantDishService {
	
	public void updatedish(Dish dish);
	public void adddish(Dish dish);
	public void deletedish(int did);
	public Dish getDishByDid(int did);
	public ArrayList<Dish> getDishBySid(int sid);
	public ArrayList<Dish> findAllDish(); 

}
