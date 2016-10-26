package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Advertisement;
import dao.AdvertisementDao;

@Repository
@Transactional
public class AdvertisementDaoImpl implements AdvertisementDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;

	@Override
	public int countAdvertisementByStatus(String status) {
		return getAdvertisementsByStatus(status).size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAdvertisementsByStatus(String status) {
		String jqpl = "from Advertisement ad where ad.status = :status";
		return em.createQuery(jqpl).setParameter("status", status).getResultList();
	}

	@Override
	public Advertisement updateAdvertisementStatus(String advId, String status) {
		System.out.println(advId + "..." + status);
		Advertisement adv = em.find(Advertisement.class, advId);
		adv.setStatus(status);
		em.persist(adv);
		return adv;
	}
	
	@Override
	public void addAdvertisement(Advertisement adv){
		em.persist(adv);
	}
	
	

}
