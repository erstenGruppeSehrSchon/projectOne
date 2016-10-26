package service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.OrderDao;
import dao.OrderDetailDao;
import po.Order;
import po.OrderDetail;
import service.OrderManager;

@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	public OrderDao orderDao;
	
	@Autowired
	public OrderDetailDao orderDetailDao;
	
	@Override
	public Order addOrder(String sid, String deliveryAddress, List<OrderDetail> orderDetails) {
		Order order = new Order();
		order.setDeliveryAddress(deliveryAddress);
		order.setStatus(Order.INIT_STATUS);
		order.setOrderTime(new Date());
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetail tempDetail = orderDetailDao.addOrderDetail(orderDetail.getDid(), orderDetail.getQuantity());
			order.getOrderDetails().add(tempDetail);
		}
		orderDao.addOrder(sid, order);
		return order;
	}
}
