package dao;

import po.OrderDetail;

public interface OrderDetailDao {

	public OrderDetail addOrderDetail(String did, int quantity);
	
}
