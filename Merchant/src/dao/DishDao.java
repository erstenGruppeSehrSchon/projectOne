package dao;

import java.util.List;
import po.Dish;

public interface DishDao {

	public Dish getDishByDid(int did);
	public List<Dish> getDishesBySid(int sid);
	public Dish addDish(Dish dish);
	public boolean removeDish(int did);
	public Dish updateDish(int did, int sid, String name, String type, float price, int isActive);

}
