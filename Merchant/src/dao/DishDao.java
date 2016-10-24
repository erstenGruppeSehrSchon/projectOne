package dao;

import java.util.List;
import po.Dish;

public interface DishDao {

	public Dish getDishByDid(String did);
	public List<Dish> getDishesBySid(String sid);
	public Dish addDish(Dish dish);
	public boolean removeDish(String did);
	public Dish updateDish(String did, String sid, String name, String type, float price, int isActive);

}
