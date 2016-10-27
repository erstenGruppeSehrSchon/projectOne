package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.MerchantDao;
import po.Merchant;

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
	public List<Merchant> getAllMerchants() {
		Session session = (Session)em.getDelegate();
		List<Merchant> merchants = session.createCriteria(Merchant.class).list();
		return merchants;
	}
	
}
