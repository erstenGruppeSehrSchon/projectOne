package service;

import java.util.List;

import object.Dish;
import object.DishImage;

public interface ClientViewMerchantDishService {
	
	public Dish loadDish(int id);
	public List<Dish> findAllDish();

	
	public DishImage loadDishImage(int id);
	public List<DishImage> findAllDishImage();

}
