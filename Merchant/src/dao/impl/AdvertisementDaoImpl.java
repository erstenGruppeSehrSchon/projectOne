package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Advertisement;
import po.Dish;
import po.Shop;
import dao.AdvertisementDao;

@Repository
@Transactional
public class AdvertisementDaoImpl implements AdvertisementDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAdvertisementBySid(String sid) {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Advertisement.class);
		criteria.createCriteria("shop", "s");
		criteria.add(Restrictions.eq("s.sid", sid));
		List<Advertisement> advertisements = criteria.list();
		return advertisements;
	}
	
	@Override
	public Advertisement addAdvertisement(String sid, Advertisement advertisement) {
		Shop shop = em.find(Shop.class, sid);
		advertisement.setShop(shop);
		em.persist(advertisement);
		return advertisement;
	}
	
	@Override
	public void updateAdvertisementStatus(String sid,String status){
		Advertisement adv = em.find(Advertisement.class, sid);
		adv.setStatus(status);
		em.persist(adv);
	}

}
