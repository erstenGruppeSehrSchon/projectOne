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
@Table(name="M_SHOP") // Change default table name
public class Shop {

	@Id
	@GeneratedValue
	private Integer sid;
	
	// Link to M_MERCHANT mid
	@Column
	private Integer mid;
	
	@Column(length=100, nullable=false)
	private String name;
	
	@Column(length=255, nullable=false)
	private String description;
	
	@Column(name="IMG_PATH", length=500, nullable=false)
	private String imgPath;

	@OneToMany
	@JoinTable(
		name="M_DISH",
		joinColumns={@JoinColumn(name="sid", referencedColumnName="sid")},
		inverseJoinColumns={@JoinColumn(name="dish_sid", referencedColumnName="sid")}
	)
	private Set<Dish> dishes = new HashSet<>();

	@OneToMany
	@JoinTable(
		name="M_SHOP_CONTACT",
		joinColumns={@JoinColumn(name="sid", referencedColumnName="sid")},
		inverseJoinColumns={@JoinColumn(name="shop_contact_sid", referencedColumnName="sid")}
	)	
	private Set<ShopContact> shopContacts = new HashSet<>();
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Set<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}

	public Set<ShopContact> getShopContacts() {
		return shopContacts;
	}

	public void setShopContacts(Set<ShopContact> shopContacts) {
		this.shopContacts = shopContacts;
	}
}
