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
		return dishImage;
	}

	@Override
	public boolean removeDishImage(int imgId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		DishImage dishImage = em.find(DishImage.class, imgId);
		em.remove(dishImage);
		em.close();
		factory.close();
		return true;
	}

}
