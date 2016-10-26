package po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="M_ORDER")
public class Order {
	
	public static final String INIT_STATUS = "Pending";
	
	@Id
	private String oid;
	
	@Column(nullable=false)
	private String deliveryAddress;
	
	@Column(nullable=false)
	private String status;

	private Date orderTime;
	
	private String comment;
	
	private Date commentTime;
	
	private String reply;
	
	private Date replyTime;
	
	private int rating;
	
	@ManyToOne(targetEntity=Shop.class)
	@JoinColumn(name="shop_id")
	private Shop shop;
	
	@OneToMany
	@JoinColumn(name="order_id")
	private Set<OrderDetail> orderDetails = new HashSet<>();

	public String getOid() {
		return oid;
	}

	@SuppressWarnings("unused")
	private void setOid(String oid) {
		this.oid = oid;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	

}
