package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="M_SHOP_CONTACT")
public class ShopContact {

	@Id
	@GenericGenerator(strategy="uuid", name="uuid")
	@GeneratedValue(generator = "uuid")
	private String cid;
	
	@Column(nullable=false)
	private String sid;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private String info;

	public String getCid() {
		return cid;
	}

	@SuppressWarnings("unused")
	private void setCid(String cid) {
		this.cid = cid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
