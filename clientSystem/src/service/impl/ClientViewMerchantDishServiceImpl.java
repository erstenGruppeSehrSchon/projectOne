package service.impl;

import java.util.List;

import dao.DishDao;
import dao.impl.DishDaoImpl;
import object.Dish;
import object.DishImage;
import service.ClientViewMerchantDishService;

public class ClientViewMerchantDishServiceImpl implements ClientViewMerchantDishService{
	
	private DishDao dish = new DishDaoImpl();

	@Override
	public Dish loadDish(int id) {
		return dish.loadDish(id);
		
	}
	@Override
	public List<Dish> findAllDish() {
		// TODO Auto-generated method stub
		return dish.findAllDish();
	}

	@Override
	public DishImage loadDishImage(int id) {
		// TODO Auto-generated method stub
		return dish.loadDishImage(id);
	}

	@Override
	public List<DishImage> findAllDishImage() {
		// TODO Auto-generated method stub
		return dish.findAllDishImage();
	}
	
	

}
