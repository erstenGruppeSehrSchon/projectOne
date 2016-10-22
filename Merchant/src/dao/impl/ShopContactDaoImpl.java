package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import po.ShopContact;
import dao.ShopContactDao;

public class ShopContactDaoImpl implements ShopContactDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopContact> getShopContactsBySid(int sid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Session session = (Session)em.getDelegate();

		// Retrieve shop contact records by sid
		Criteria criteria = session.createCriteria(ShopContact.class);
		criteria.add(Restrictions.eq("sid", sid));
		List<ShopContact> shopContacts = criteria.list();
		
		// Close object
		em.close();
		factory.close();

		// Return shop contacts
		return shopContacts;
	}

	@Override
	public ShopContact addShopContact(ShopContact shopContact) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(shopContact);
		tx.commit();
		em.close();
		factory.close();
		return shopContact;
	}

	@Override
	public boolean removeShopContact(int cid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		ShopContact shopContact = em.find(ShopContact.class, cid);
		em.remove(shopContact);
		em.close();
		factory.close();
		return true;
	}

	@Override
	public ShopContact updateShopContact(int cid, int sid, String type, String info) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		
		// Get origin shop contact
		ShopContact shopContact = em.find(ShopContact.class, cid);
		EntityTransaction tx = em.getTransaction();
		
		// Update shop contact
		tx.begin();
		shopContact.setCid(cid);
		shopContact.setSid(sid);
		shopContact.setType(type);
		shopContact.setInfo(info);
		tx.commit();
		
		// close object
		em.close();
		factory.close();
		
		// Return updated shop contact
		return shopContact;
	}

}
