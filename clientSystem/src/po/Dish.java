package po;

public class Dish {
	private int did;
	private String name;
	private String type;
	private double price;
	private int sid;
	private int active;
	
	public int getId() {
		return did;
	}
	public void setId(int did) {
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
	public int getMid() {
		return sid;
	}
	public void setMid(int sid) {
		this.sid = sid;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}
