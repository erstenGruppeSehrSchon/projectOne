package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.OrderDao;
import po.Order;
import service.OrderManager;

@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	public OrderDao orderDao;
	
	@Override
	public List<Order> getOrdersBySid(String sid) {
		return orderDao.getOrdersBySid(sid);
	}

	@Override
	public Order updateOrderStatus(String oid, String status) {
		return orderDao.updateOrderStatus(oid, status);
	}

	@Override
	public Order replyOrderComment(String oid, String reply) {
		Date replyTime = new Date();
		return orderDao.replyOrderComment(oid, reply, replyTime);
	}

}
