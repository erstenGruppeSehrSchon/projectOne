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
	
	@Override
	public Shop getShopByDid(String did) {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Shop.class);
		criteria.createCriteria("dishes", "d");
		criteria.add(Restrictions.eq("d.did", did));
		return (Shop)criteria.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopsByCriteria(String name, String type, String address) {
		Session session = (Session)em.getDelegate();
		
		// Add criteria
		Criteria criteria = session.createCriteria(Shop.class);
		
		if (name != null && name.length() > 0) {
			criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}
		
		if (type != null && type.length() > 0) {
			criteria.add(Restrictions.eq("type", type));
		}
		
		if (address != null && address.length() > 0) {
			criteria.add(Restrictions.like("address", address, MatchMode.ANYWHERE));
		}
		
		// Retrieve match shops
		List<Shop> shops = criteria.list();
		
		// Return match shops
		return shops;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShops() {
		Session session = (Session)em.getDelegate();
		
		// Add criteria
		Criteria criteria = session.createCriteria(Shop.class);
		
		// Retrieve match shops
		List<Shop> shops = criteria.list();
		
		// Return match shops
		return shops;
	}

}
