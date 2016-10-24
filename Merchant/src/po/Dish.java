package po;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="M_DISH")
public class Dish {

	@Id
	@GenericGenerator(strategy="uuid", name="uuid")
	@GeneratedValue(generator = "uuid")
	private String did;
	
	@Column(nullable=false)
	private String sid;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private float price;
	
	@Column(length=1, nullable=false)
	private int isActive;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="sid", referencedColumnName="sid", insertable = false, updatable = false)	
	private Set<DishImage> dishImages;
	
	public String getDid() {
		return did;
	}

	@SuppressWarnings("unused")
	private void setDid(String did) {
		this.did = did;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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
