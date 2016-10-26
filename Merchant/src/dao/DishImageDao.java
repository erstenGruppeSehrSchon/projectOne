package dao;

import po.DishImage;

public interface DishImageDao {

	public DishImage addDishImage(String did, DishImage dishImage);
	public boolean removeDishImage(String imgId);

}
