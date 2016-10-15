package object;

import java.util.ArrayList;

public class Dish {
	private int did;
	private String name;
	private String type;
	private double price;
	private int sid;
	private int active;
	private ArrayList<DishImage> dishImages;
	
	public int getDid() {
		return did;
	}
	
	public void setDid(int did) {
		this.did = did;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int active) {
		this.active = active;
	}
	
	public ArrayList<DishImage> getDishImages() {
		return dishImages;
	}
	
	public void setDishImages(ArrayList<DishImage> dishImages) {
		this.dishImages = dishImages;
	}
	

}
