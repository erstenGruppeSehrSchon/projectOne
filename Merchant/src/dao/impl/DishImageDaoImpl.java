package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import po.DishImage;
import dao.DishImageDao;

public class DishImageDaoImpl implements DishImageDao {

	@Override
	public DishImage addDishImage(DishImage dishImage) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(dishImage);
		tx.commit();
		em.close();
		factory.close();
		return dishImage;
	}

	@Override
	public boolean removeDishImage(int imgId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		
		// Get original dish image
		DishImage dishImage = em.find(DishImage.class, imgId);
		
		// Remove dish image
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(dishImage);
		tx.commit();
		
		// Close object and return
		em.close();
		factory.close();
		return true;
	}

}
