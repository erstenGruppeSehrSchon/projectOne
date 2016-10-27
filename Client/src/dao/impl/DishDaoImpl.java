package dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import po.Dish;
import po.Shop;
import dao.DishDao;

@Repository
@Transactional
public class DishDaoImpl implements DishDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Dish getDishByDid(String did) {
		return em.find(Dish.class, did);
	}
	
	@Override
	public List<Dish> getDishesBySid(String sid) {
//		Session session = (Session)em.getDelegate();
//
//		// Retrieve dish records by sid
//		Criteria criteria = session.createCriteria(Dish.class);
//		criteria.createCriteria("Shop","s");
//		criteria.add(Restrictions.eq("s.SID", sid));
//		List<Dish> dishes = criteria.list();
		Shop s = em.find(Shop.class,sid);
		List<Dish> dishes = new ArrayList<Dish>(s.getDishes());
		return dishes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getDishesByCriteria(String name, String type, Float lowerPrice, Float higherPrice) {
		Session session = (Session)em.getDelegate();
		
		// Add criteria
		Criteria criteria = session.createCriteria(Dish.class);
		
		if (name != null) {
			criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}
		
		if (type != null) {
			criteria.add(Restrictions.eq("type", type));
		}
		
		if (lowerPrice != null) {
			criteria.add(Restrictions.ge("price", lowerPrice));
		}
		
		if (higherPrice != null) {
			criteria.add(Restrictions.le("regDate", higherPrice));
		}

		List<Dish> dishes = criteria.list();
		
		// Return match dishes
		return dishes;
	}
}
