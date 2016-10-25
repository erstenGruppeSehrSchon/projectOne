package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.ShopContact;
import dao.ShopContactDao;

@Repository
@Transactional
public class ShopContactDaoImpl implements ShopContactDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShopContact> getShopContactsBySid(String sid) {
		Session session = (Session)em.getDelegate();

		// Retrieve shop contact records by sid
		Criteria criteria = session.createCriteria(ShopContact.class);
		criteria.add(Restrictions.eq("sid", sid));
		List<ShopContact> shopContacts = criteria.list();
		
		return shopContacts;
	}

	@Override
	public ShopContact addShopContact(ShopContact shopContact) {
		em.persist(shopContact);
		return shopContact;
	}

	@Override
	public boolean removeShopContact(String cid) {
		ShopContact shopContact = em.find(ShopContact.class, cid);
		em.remove(shopContact);
		return true;
	}

	@Override
	public ShopContact updateShopContact(String cid, String sid, String type, String info) {
		// Get origin shop contact
		ShopContact shopContact = em.find(ShopContact.class, cid);
		
		// Update shop contact
		shopContact.setSid(sid);
		shopContact.setType(type);
		shopContact.setInfo(info);
		
		// Return updated shop contact
		return shopContact;
	}

}
