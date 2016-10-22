package service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import po.Dish;


public interface DishManager {

	public Dish getDishByDid(int did);
	public List<Dish> getDishesBySid(int sid);
	public Dish addDish(int sid, String name, String type, Double price, int isActive, List<MultipartFile> files);
	public boolean removeDish(int did);
	public Dish updateDish(int did, int sid, String name, String type, double price, int isActive);

}
