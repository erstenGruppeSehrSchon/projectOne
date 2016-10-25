package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Shop;
import dao.ShopDao;

@Repository
@Transactional
public class ShopDaoImpl implements ShopDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Shop getShopBySid(String sid) {
		return em.find(Shop.class, sid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopsByName(String name) {
		Session session = (Session)em.getDelegate();
		
		// Add criteria
		Criteria criteria = session.createCriteria(Shop.class);
		criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		
		// Retrieve match shops
		List<Shop> shops = criteria.list();
		
		// Return match shops
		return shops;
	}

}
