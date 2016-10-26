package dao;

import po.Order;

public interface OrderDao {
	
	public Order addOrder(String sid, Order order);

}
