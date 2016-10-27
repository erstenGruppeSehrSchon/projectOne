package dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getDishesBySid(String sid) {
//		Session session = (Session)em.getDelegate();
//		Criteria criteria = session.createCriteria(Dish.class);
//		criteria.add(Restrictions.eq("shop_id", sid));
//		List<Dish> dishes = criteria.list();
//		return dishes;
		
		Session session = (Session)em.getDelegate();
		
		// Retrieve dish records by sid
		Shop s = em.find(Shop.class,sid);
		List<Dish> dishes = new ArrayList<Dish>(s.getDishes());
		
		return dishes;
	}

	@Override
	public Dish addDish(String sid, Dish dish) {
		Shop shop = em.find(Shop.class, sid);
		shop.getDishes().add(dish);
		em.persist(dish);
		return dish;
	}

	@Override
	public boolean removeDish(String did) {
		Dish dish = em.find(Dish.class, did);
		em.remove(dish);
		return true;
	}


}
