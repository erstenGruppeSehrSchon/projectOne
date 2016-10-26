package service;

import java.util.List;

import po.Order;
import po.OrderDetail;

public interface OrderManager {

	public Order addOrder(String sid, String deliveryAddress, List<OrderDetail> orderDetails);

}
