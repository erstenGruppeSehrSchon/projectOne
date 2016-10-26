package dao;

import java.util.List;
import po.Dish;

public interface DishDao {

	public Dish getDishByDid(String did);
	public List<Dish> getDishesBySid(String sid);
	public Dish addDish(String sid, Dish dish);
	public boolean removeDish(String did);

}
