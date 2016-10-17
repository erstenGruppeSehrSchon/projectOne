package dao;

import java.util.ArrayList;

import common.po.Dish;

public interface MerchantDishDao {
	
	public void updatedish(Dish dish);
	public int adddish(Dish dish);
	public void deletedish(int did);
	public Dish getDishByDid(int did);
	public ArrayList<Dish> getDishBySid(int sid);
	public ArrayList<Dish> findAllDish();
	

}
