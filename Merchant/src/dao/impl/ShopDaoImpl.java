package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import po.Shop;
import dao.ShopDao;

public class ShopDaoImpl implements ShopDao {

	@Override
	public Shop getShopBySid(int sid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Shop shop = em.find(Shop.class, sid);
		em.close();
		factory.close();
		return shop;
	}

	@Override
	public Shop addShop(Shop shop) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(shop);
		tx.commit();
		em.close();
		factory.close();
		return shop;
	}

	@Override
	public boolean removeShop(int sid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		
		// Get origin shop
		Shop shop = em.find(Shop.class, sid);
		
		// Remove shop
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(shop);
		tx.commit();
		
		// Close objects and return 
		em.close();
		factory.close();
		return true;
	}

	@Override
	public Shop updateShop(int sid, int mid, String name, String description) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		
		// Get origin shop
		Shop shop = em.find(Shop.class, sid);
		
		// Update shop
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		shop.setMid(mid);
		shop.setName(name);
		shop.setDescription(description);
		tx.commit();
		
		// close object
		em.close();
		factory.close();
		
		// Return updated shop
		return shop;
	}

}
