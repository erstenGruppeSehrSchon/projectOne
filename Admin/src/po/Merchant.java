package po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="A_MERCHANT") // Change default table name
public class Merchant {
	
	@Id
	private String mid;
	
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
}
