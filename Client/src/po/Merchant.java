package po;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="M_MERCHANT") // Change default table name
public class Merchant {
	
	@Id
	@GeneratedValue
	private Integer mid;
	
	@Column(length=100, nullable=false)
	private String name;
	
	@Column(length=8, nullable=false)
	private String gender;
	
	@Column(name="BIRTH_DATE", nullable=false)
	private Date birthDate;
	
	@Column(name="REG_DATE", nullable=false)
	private Date regDate;
	
	@Column(nullable=false)
	private String status;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="mid", referencedColumnName="mid", insertable = false, updatable = false)	
	private Set<Shop> shops;
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Shop> getShops() {
		return shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}
}
