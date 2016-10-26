package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="M_ADVERTISEMENT")
public class Advertisement {

	@Id
	@GenericGenerator(strategy="uuid", name="uuid")
	@GeneratedValue(generator = "uuid")
	private Integer ADV_IMG_ID;
	
	@Column(nullable=false)
	private String imgPath;
	
	@Column(nullable=false)
	private String status;

	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;

	public Integer getADV_IMG_ID() {
		return ADV_IMG_ID;
	}

	public void setADV_IMG_ID(Integer aDV_IMG_ID) {
		ADV_IMG_ID = aDV_IMG_ID;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
