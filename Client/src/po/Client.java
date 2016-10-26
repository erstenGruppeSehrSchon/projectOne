package po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Client")
public class Client {
	
	@Id
	@GenericGenerator(name="miduuid",strategy="uuid")
	@GeneratedValue(generator="miduuid")
	private String cid;
	
	@Column(length=100, nullable=false, unique=true)
	private String username;
	
	@Column(length=100, nullable=false)
	private String password;
	

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Address> address = new HashSet<Address>();
	
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Order> order = new ArrayList<Order>();
	
	
    public Client(){
		
	}
	
	public Client(String cid) {
		super();
		this.cid = cid;
		
	}


	

	public Set<Address> getAddress() {
		return address;
	}



	public void setAddress(Set<Address> address) {
		this.address = address;
	}



	public String getCid() {
		return cid;
	}



	public void setCid(String cid) {
		this.cid = cid;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Order> getOrder() {
		return order;
	}



	public void setOrder(List<Order> order) {
		this.order = order;
	}



	public String getPassword() {
		return password;
	}








	public void setPassword(String password) {
		this.password = password;
	}

	


}
