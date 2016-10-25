package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Dish;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getDishesBySid(String sid) {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Dish.class);
		criteria.add(Restrictions.eq("sid", sid));
		List<Dish> dishes = criteria.list();
		return dishes;
	}

	@Override
	public Dish addDish(Dish dish) {
		em.persist(dish);
		return dish;
	}

	@Override
	public boolean removeDish(String did) {
		Dish dish = em.find(Dish.class, did);
		em.remove(dish);
		return true;
	}

	@Override
	public Dish updateDish(String did, String sid, String name, String type, float price, int isActive) {
		// Get origin dish
		Dish dish = em.find(Dish.class, did);
		
		// Update dish
		dish.setSid(sid);
		dish.setName(name);
		dish.setType(type);
		dish.setPrice(price);
		dish.setIsActive(isActive);
		
		// Return updated dish
		return dish;
	}


}
