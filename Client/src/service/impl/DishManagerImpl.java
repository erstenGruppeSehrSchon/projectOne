package service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Dish;
import dao.DishDao;
import service.DishManager;

@Service
public class DishManagerImpl implements DishManager {

	@Autowired
	private DishDao dao;
	
	@Override
	public Dish getDishByDid(String did) {
		return dao.getDishByDid(did);
	}
	
	@Override
	public List<Dish> getDishesBySid(String sid) {
		return dao.getDishesBySid(sid);
	}

	@Override
	public List<Dish> getDishesByCriteria(String name, String type, Float lowerPrice, Float higherPrice) {
		return dao.getDishesByCriteria(name, type, lowerPrice, higherPrice);
	}
}
