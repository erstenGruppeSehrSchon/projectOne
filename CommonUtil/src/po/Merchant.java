package po;

import java.util.ArrayList;
import java.util.Date;


public class Merchant {
	
	public static final String STATUS_ACCEPT = "Accepted";
	public static final String STATUS_PENDING = "Pending";
	public static final String STATUS_REJECT = "Rejected";
	public static final String STATUS_FROZEN = "Frozen";
	
	protected int mid;
	protected String name;
	protected Date birth;
	protected String gender;
	protected String status;
	protected Date regDate;
	protected ArrayList<Shop> shopList;
	protected int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
	public Date getBirth() {
		return birth;
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(ArrayList<Shop> shopList) {
		this.shopList = shopList;
	}

}
