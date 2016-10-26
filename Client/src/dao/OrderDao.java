package dao;

import java.util.List;

import po.Order;

public interface OrderDao {
	
	public Order addOrder(String sid, Order order);
	public List<Order> getAllOrder();
	public Order getOrderByOid(String oid);
	public List<Order> getOrderBySid(String sid);
	public Order addComment(String oid, String comment);
	public Order addRating(String oid, int rating);

}
