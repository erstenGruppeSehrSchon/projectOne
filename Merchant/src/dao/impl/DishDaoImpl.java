package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
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

	@Override
	public Dish addDish(Dish dish) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(dish);
		tx.commit();
		em.close();
		factory.close();
		return dish;
	}

	@Override
	public boolean removeDish(int did) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Dish dish = em.find(Dish.class, did);
		em.remove(dish);
		em.close();
		factory.close();
		return true;
	}

	@Override
	public Dish updateDish(int did, int sid, String name, String type, double price, int isActive) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		
		// Get origin dish
		Dish dish = em.find(Dish.class, did);
		EntityTransaction tx = em.getTransaction();
		
		// Update dish
		tx.begin();
		dish.setSid(sid);
		dish.setName(name);
		dish.setType(type);
		dish.setPrice(price);
		dish.setIsActive(isActive);
		tx.commit();
		
		// close object
		em.close();
		factory.close();
		
		// Return updated dish
		return dish;
	}


}
