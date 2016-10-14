package object;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private int sid;
	private int mid;
	private String name;
	private String descr;
	private String imagePath;
	private List<Dish> dishList;
	private List <ShopContact> shopContactList;
	
	public Shop(){
		shopContactList= new ArrayList<ShopContact>();
		dishList= new ArrayList<Dish>();
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public List<Dish> getDishList() {
		return dishList;
	}

	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}

	public List<ShopContact> getShopContactList() {
		return shopContactList;
	}
	public void setShopContactList(List<ShopContact> shopContactList) {
		this.shopContactList = shopContactList;
	}
	
	
}
