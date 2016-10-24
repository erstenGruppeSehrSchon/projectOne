package po;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="M_SHOP") // Change default table name
public class Shop {

	@Id
	private String sid;
	
	// Link to M_MERCHANT mid
	@Column(nullable=false)
	private String mid;
	
	@Column(length=100, nullable=false)
	private String name;
	
	@Column(length=255, nullable=false)
	private String description;
	
	@Column(name="IMG_PATH", length=500, nullable=false)
	private String imgPath;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="sid", referencedColumnName="sid",  insertable = false, updatable = false)	
	private Set<Dish> dishes;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="sid", referencedColumnName="sid", insertable = false, updatable = false)
	private Set<ShopContact> shopContacts;
	
	public String getSid() {
		return sid;
	}

	@SuppressWarnings("unused")
	private void setSid(String sid) {
		this.sid = sid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
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
