package service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import po.Dish;


public interface DishManager {

	public Dish getDishByDid(String did);
	public List<Dish> getDishesBySid(String sid);
	public Dish addDish(String sid, String name, String type, float price, String descritpion, List<MultipartFile> files, ServletContext context);
	public boolean removeDish(String did);

}
