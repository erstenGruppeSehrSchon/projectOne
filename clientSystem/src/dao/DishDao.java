package dao;

import java.util.List;

import object.Dish;
import object.DishImage;

public interface DishDao {
	
	public void addDish(Dish f);
	public void updateDish(Dish d);
	public void deleteDish(int id);
	public Dish loadDish(int id);
	public List<Dish> findAllDish();

	public void addDishImg(DishImage di);
	public void updateDishImg(DishImage di);
	public void deleteDishImg(int imgid);
	public DishImage loadDishImage(int id);
	public List<DishImage> findAllDishImage();
	
}
