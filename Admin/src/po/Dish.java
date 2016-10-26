package po;

import java.util.HashSet;
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
	private String name;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private float price;
	
	@Column(nullable=false)
	private String description;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="dish_id")
	private Set<DishImage> dishImages = new HashSet<>();
	
	public String getDid() {
		return did;
	}

	@SuppressWarnings("unused")
	private void setDid(String did) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<DishImage> getDishImages() {
		return dishImages;
	}

	public void setDishImages(Set<DishImage> dishImages) {
		this.dishImages = dishImages;
	}

}
