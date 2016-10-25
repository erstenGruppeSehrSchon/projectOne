package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import po.Shop;
import dao.ShopDao;

@Repository
@Transactional
public class ShopDaoImpl implements ShopDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Shop getShopBySid(String sid) {
		return em.find(Shop.class, sid);
	}

	@Override
	public Shop addShop(Shop shop) {
		em.persist(shop);
		return shop;
	}

	@Override
	public boolean removeShop(String sid) {
		Shop shop = em.find(Shop.class, sid);
		em.remove(shop);
		return true;
	}

	@Override
	public Shop updateShop(String sid, String mid, String name, String description) {
		// Get origin shop
		Shop shop = em.find(Shop.class, sid);
		
		// Update shop
		shop.setMid(mid);
		shop.setName(name);
		shop.setDescription(description);
		
		// Return updated shop
		return shop;
	}

}
