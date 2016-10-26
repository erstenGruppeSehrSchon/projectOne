package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Order;
import po.Shop;
import dao.OrderDao;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Order addOrder(String sid, Order order) {
		Shop shop = em.find(Shop.class, sid);
		order.setShop(shop);
		em.persist(order);
		return order;
	}

}
