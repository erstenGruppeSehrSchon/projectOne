package service;

import java.util.List;

import po.Order;
import po.OrderDetail;

public interface OrderManager {

	public Order addOrder(String sid, String deliveryAddress, List<OrderDetail> orderDetails);
	public List<Order> getAllOrder();
	public Order getOrder(String oid);
	public Order addComment(String oid, String comment);
	public Order addRating(String oid, int rating);

}
