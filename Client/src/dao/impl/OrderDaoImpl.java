package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrder() {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Order.class);
		List<Order> orderList = criteria.list();
		return orderList;
	}

	@Override
	public Order getOrderByOid(String oid) {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("oid", oid));
		Order order = (Order) criteria.uniqueResult();		
		return order;
	}

	@Override
	public Order addComment(String oid, String comment) {
		Order order = em.find(Order.class, oid);
		order.setComment(comment);
		order.setCommentTime(new Date());
		
		
		return order;
	}

	@Override
	public Order addRating(String oid, int rating) {
		Order order = em.find(Order.class, oid);
		order.setRating(rating);
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderBySid(String sid) {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.createCriteria("shop","s");
		criteria.add(Restrictions.eq("s.sid", sid));		
		List<Order> order = (List<Order>) criteria.list();		
		return order;
	}



}
