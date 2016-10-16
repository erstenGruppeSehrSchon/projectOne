package service;

import java.util.ArrayList;
import po.Dish;

public interface ClientViewMerchantDishService {
	
	public ArrayList<Dish> loadDishBySid(int sid);
	public Dish loadDishByDid(int did);
	public ArrayList<Dish> findAllDish();

}
