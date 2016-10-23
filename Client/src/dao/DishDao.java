package dao;

import java.util.List;
import po.Dish;

public interface DishDao {

	public Dish getDishByDid(int did);
	public List<Dish> getDishesBySid(int sid);
	public List<Dish> getDishesByCriteria(String name, String type, Float lowerPrice, Float higherPrice);
	
}
