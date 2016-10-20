package dao;

import java.util.ArrayList;

import common.po.Dish;

public interface MerchantDishDao {
	
	public void updateDish(Dish dish);
	public int addDish(Dish dish);
	public void deleteDish(int did);
	public Dish getDishByDid(int did);
	public ArrayList<Dish> getDishBySid(int sid);
	public ArrayList<Dish> findAllDish();
	

}
