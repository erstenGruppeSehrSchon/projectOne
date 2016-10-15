package dao;

import java.util.ArrayList;

import po.Dish;

public interface DishDao {
	
	public Dish getDishByDid(int did);
	public ArrayList<Dish> getDishBySid(int sid);
	public ArrayList<Dish> findAllDish();
	
}
