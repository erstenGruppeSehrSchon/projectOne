package service;

import java.util.List;
import po.Order;

public interface OrderManager {

	public List<Order> getOrdersBySid(String sid);
	public Order updateOrderStatus(String oid, String status);
	public Order replyOrderComment(String oid, String reply);
	
}
