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
import dao.OrderDao;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrdersBySid(String sid) {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.createCriteria("shop","s");
		criteria.add(Restrictions.eq("s.sid", sid).ignoreCase());
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Order> order = (List<Order>) criteria.list();		
		return order;
	}

	@Override
	public Order updateOrderStatus(String oid, String status) {
		Order order = em.find(Order.class, oid);
		order.setStatus(status);
		return order;
	}

	@Override
	public Order replyOrderComment(String oid, String reply, Date replyTime) {
		Order order = em.find(Order.class, oid);
		order.setReply(reply);
		order.setReplyTime(replyTime);
		return order;
	}

}
