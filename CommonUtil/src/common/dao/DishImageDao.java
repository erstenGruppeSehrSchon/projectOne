package common.dao;

import java.util.ArrayList;

import common.po.DishImage;


public interface DishImageDao {

	public ArrayList<DishImage> getDishImageByDid(int did);
	public ArrayList<DishImage> findAllDishImage();

}
