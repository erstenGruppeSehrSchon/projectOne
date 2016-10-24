package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import dao.MerchantDao;
import po.Merchant;

public class MerchantDaoImpl implements MerchantDao {

	@Override
	public Merchant getMerchantByMid(String mid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Merchant merchant = em.find(Merchant.class, mid);
		em.close();
		factory.close();
		return merchant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Merchant> getAllMerchants() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Session session = (Session)em.getDelegate();
		List<Merchant> merchants = session.createCriteria(Merchant.class).list();
		em.close();
		factory.close();
		return merchants;
	}
	
}
