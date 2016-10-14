package service.impl;

import service.ClientViewMerchantDishService;

public class ClientViewMerchantDishServiceImpl implements ClientViewMerchantDishService{
	
	private Dish dish = new Dish();
	private DishImage dishimage = new DishImage();
	
	
	@Override
	public int getDishDid() {
		// TODO Auto-generated method stub
		return dish.getId();
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return dishimage.getImagePath;
	}

	@Override
	public int getDishPrice() {
		// TODO Auto-generated method stub
		return dish.getPrice();
	}

	@Override
	public int isDishAction() {
		// TODO Auto-generated method stub
		return dish.getActive();
	}

	@Override
	public String getDishType() {
		// TODO Auto-generated method stub
		return dish.getType();
	}

	@Override
	public String getDishName() {
		// TODO Auto-generated method stub
		return dish.getName();
	}

	@Override
	public int getDishMid() {
		// TODO Auto-generated method stub
		return dish.getMid();
	}

}
