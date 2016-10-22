package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_DISH_IMG")
public class DishImage {

	@Id
	@GeneratedValue
	@Column(name="IMG_ID")
	private Integer imgId;
	
	@Column(nullable=false)
	private Integer did;
	
	@Column(name="IMG_PATH", length=500, nullable=false)
	private String imgPath;

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
