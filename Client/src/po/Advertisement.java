package po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="M_ADVERTISEMENT")
public class Advertisement {

	public static final String INIT_STATUS = "Pending";

	@Id
	private Integer ADV_IMG_ID;
	
	@Column(nullable=false)
	private String imgPath;
	
	@Column(nullable=false)
	private String status;

	@Column(nullable=false)
	private Date createdTime;
	
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public static String getInitStatus() {
		return INIT_STATUS;
	}
}
