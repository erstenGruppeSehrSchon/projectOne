package service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import po.Dish;


public interface DishManager {

	public Dish getDishByDid(String did);
	public List<Dish> getDishesBySid(String sid);
	public Dish addDish(String sid, String name, String type, float price, int isActive, List<MultipartFile> files);
	public boolean removeDish(String did);
	public Dish updateDish(String did, String sid, String name, String type, float price, int isActive);

}
