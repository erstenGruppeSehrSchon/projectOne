package dao;

import po.DishImage;

public interface DishImageDao {

	public DishImage addDishImage(DishImage dishImage);
	public boolean removeDishImage(int imgId);

}
