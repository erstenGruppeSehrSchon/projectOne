package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Merchant;
import dao.MerchantDao;

@Repository
@Transactional
public class MerchantDaoImpl implements MerchantDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Merchant getMerchantByMid(String mid) {
		return em.find(Merchant.class, mid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Merchant getMerchantByUsername(String username) {
		Session session = (Session)em.getDelegate();
		
		// Retrieve merchant record by username
		Criteria criteria = session.createCriteria(Merchant.class);
		criteria.add(Restrictions.eq("username", username));
		List<Merchant> merchants = criteria.list();
		
		// Return merchant if record exists
		return (merchants.size() == 1 ? merchants.get(0) : null);
	}

	@Override
	public Merchant addMerchant(Merchant merchant) {
		em.persist(merchant);
		return merchant;
	}
	
	@Override
	public Merchant updateMerchantStatus(int mid, String status) {
		Merchant merchant = em.find(Merchant.class, mid);
		merchant.setStatus(status);
		return merchant;
	}
}
