package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Dish;
import po.OrderDetail;

import dao.OrderDetailDao;

@Repository
@Transactional
public class OrderDetailDaoImpl implements OrderDetailDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public OrderDetail addOrderDetail(String did, int quantity) {
		Dish dish = em.find(Dish.class, did);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDish(dish);
		em.persist(orderDetail);
		return orderDetail;
	}

}
