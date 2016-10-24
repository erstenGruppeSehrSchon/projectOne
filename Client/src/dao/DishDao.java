package dao;

import java.util.List;
import po.Dish;

public interface DishDao {

	public Dish getDishByDid(String did);
	public List<Dish> getDishesBySid(String sid);
	public List<Dish> getDishesByCriteria(String name, String type, Float lowerPrice, Float higherPrice);
	
}
