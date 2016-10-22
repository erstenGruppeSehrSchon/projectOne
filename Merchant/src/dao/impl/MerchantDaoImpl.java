package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import po.Merchant;
import dao.MerchantDao;

public class MerchantDaoImpl implements MerchantDao {

	@Override
	public Merchant getMerchantByMid(int mid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Merchant merchant = em.find(Merchant.class, mid);
		em.close();
		factory.close();
		return merchant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Merchant getMerchantByUsername(String username) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Session session = (Session)em.getDelegate();
		
		// Retrieve merchant record by username
		Criteria criteria = session.createCriteria(Merchant.class);
		criteria.add(Restrictions.eq("username", username));
		List<Merchant> merchants = criteria.list();

		// Close object
		em.close();
		factory.close();
		
		// Return merchant if record exists
		return (merchants.size() == 1 ? merchants.get(0) : null);
	}

	@Override
	public Merchant addMerchant(Merchant merchant) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(merchant);
		tx.commit();
		em.close();
		factory.close();
		return merchant;
	}
}
