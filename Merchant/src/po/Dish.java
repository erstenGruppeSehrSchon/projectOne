package po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="M_DISH")
public class Dish {

	@Id
	@GeneratedValue
	private Integer did;
	
	@Column(nullable=false)
	private Integer sid;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private double price;
	
	@Column(length=1, nullable=false)
	private int isActive;
	
	@OneToMany
	@JoinTable(
		name="M_DISH_IMG",
		joinColumns={@JoinColumn(name="did", referencedColumnName="did")},
		inverseJoinColumns={@JoinColumn(name="dish_img_did", referencedColumnName="did")}
	)
	private Set<DishImage> dishImages = new HashSet<>();

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Set<DishImage> getDishImages() {
		return dishImages;
	}

	public void setDishImages(Set<DishImage> dishImages) {
		this.dishImages = dishImages;
	} 
	
}
