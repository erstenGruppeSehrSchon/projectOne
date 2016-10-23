package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import po.Shop;
import dao.ShopDao;

public class ShopDaoImpl implements ShopDao {

	@Override
	public Shop getShopBySid(int sid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Shop shop = em.find(Shop.class, sid);
		em.close();
		factory.close();
		return shop;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopsByName(String name) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Session session = (Session)em.getDelegate();
		
		// Add criteria
		Criteria criteria = session.createCriteria(Shop.class);
		criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		
		// Retrieve match shops
		List<Shop> shops = criteria.list();
		
		// Close objects
		em.close();
		factory.close();
		
		// Return match shops
		return shops;
	}

}
