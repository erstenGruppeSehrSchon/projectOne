package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="M_DISH_IMG")
public class DishImage {

	@Id
	@GenericGenerator(strategy="uuid", name="uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name="IMG_ID")
	private String imgId;
	
	@Column(name="IMG_PATH", length=500, nullable=false)
	private String imgPath;

	public String getImgId() {
		return imgId;
	}

	@SuppressWarnings("unused")
	private void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
