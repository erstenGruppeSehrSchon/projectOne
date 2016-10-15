package service;

import java.util.ArrayList;
import po.Dish;

public interface ClientViewMerchantDishService {
	
	public Dish loadDish(int id);
	public ArrayList<Dish> findAllDish();

}
