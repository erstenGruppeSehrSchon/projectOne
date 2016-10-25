package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.DishImage;
import dao.DishImageDao;

@Repository
@Transactional
public class DishImageDaoImpl implements DishImageDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public DishImage addDishImage(DishImage dishImage) {
		em.persist(dishImage);
		return dishImage;
	}

	@Override
	public boolean removeDishImage(String imgId) {
		DishImage dishImage = em.find(DishImage.class, imgId);
		em.remove(dishImage);
		return true;
	}

}
