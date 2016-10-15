package dao;

import java.util.ArrayList;

import object.DishImage;

public interface DishImageDao {

	public ArrayList<DishImage> getDishImageByDid(int did);
	public ArrayList<DishImage> findAllDishImage();

}
