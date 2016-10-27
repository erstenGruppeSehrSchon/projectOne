package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import po.Advertisement;
import dao.AdvertisementDao;

@Repository
@Transactional
public class AdvertisementDaoImpl implements AdvertisementDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAllAdvertisement() {
		
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Advertisement.class); 
		List<Advertisement> AdvAllList = criteria.list();
		return AdvAllList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getLatestAdvertisement() {
		Session session = (Session)em.getDelegate();
		
		Criteria criteria = session.createCriteria(Advertisement.class).addOrder( Order.desc("createdTime"));
		List<Advertisement> AdvLatestList = criteria.list();
		return AdvLatestList;
	}

}
