package dao;

import java.util.ArrayList;
import object.Dish;

public interface DishDao {
	
	public Dish getDishByDid(int did);
	public ArrayList<Dish> getDishByMid(int mid);
	public ArrayList<Dish> findAllDish();
	
}
