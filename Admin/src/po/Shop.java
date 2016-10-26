package po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="M_SHOP") // Change default table name
public class Shop {

	@Id
	@GenericGenerator(strategy="uuid", name="uuid")
	@GeneratedValue(generator = "uuid")
	private String sid;
	
	@Column(length=100, nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private Date openTime;
	
	@Column(nullable=false)
	private Date closeTime;
	
	@Column(length=255, nullable=false)
	private String description;
	
	@Column(name="IMG_PATH", length=500, nullable=false)
	private String imgPath;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="shop_id")	
	private Set<Dish> dishes = new HashSet<>();

	@Embedded
	private ShopContact shopContact;
	
	public String getSid() {
		return sid;
	}

	@SuppressWarnings("unused")
	private void setSid(String sid) {
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

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
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

	public ShopContact getShopContact() {
		return shopContact;
	}

	public void setShopContact(ShopContact shopContact) {
		this.shopContact = shopContact;
	}

}
