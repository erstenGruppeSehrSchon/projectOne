package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import po.Dish;
import dao.DishDao;

public class DishDaoImpl implements DishDao {
	@Override
	public Dish getDishByDid(int did) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Dish dish = em.find(Dish.class, did);
		em.close();
		factory.close();
		return dish;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getDishesBySid(int sid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Session session = (Session)em.getDelegate();

		// Retrieve dish records by sid
		Criteria criteria = session.createCriteria(Dish.class);
		criteria.add(Restrictions.eq("sid", sid));
		List<Dish> dishes = criteria.list();
		
		// Close object
		em.close();
		factory.close();
		
		return dishes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getDishesByCriteria(String name, String type, Float lowerPrice, Float higherPrice) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
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
		
		// Close objects
		em.close();
		factory.close();
		
		// Return match dishes
		return dishes;
	}
}
