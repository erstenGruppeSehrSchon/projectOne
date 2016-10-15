package po;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import object.Shop;

public class Mechant {
	protected int mid;
	protected String name;
	protected Date birth;
	protected String gender;
	protected String status;
	protected Date regDate;
	protected List<Shop> shopList;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Mechant(){
		shopList= new ArrayList<Shop>();
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
		if (birth != null){
			Calendar today = Calendar.getInstance();
			Calendar birthday = Calendar.getInstance();
			int age = 0;
			birthday.setTime(birth);
			age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
			if ( (birthday.get(Calendar.DAY_OF_YEAR) - birthday.get(Calendar.DAY_OF_YEAR) > 3) ||
		            (birthday.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
		        age--;

		     // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
		    }else if ((birthday.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
		              (birthday.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
		        age--;
		    }
			this.setAge(age);
		}		
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
	public List<Shop> getShopList() {
		return shopList;
	}
	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}

}
