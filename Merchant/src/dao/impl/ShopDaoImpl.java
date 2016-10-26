package dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Merchant;
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
	public Shop addShop(String mid, Shop shop) {
		Merchant merchant = em.find(Merchant.class, mid);
		merchant.getShops().add(shop);
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
	public Shop updateShop(String sid, String name, String description, String type, Date openTime, Date closeTime, String address, String phone) {
		// Get origin shop
		Shop shop = em.find(Shop.class, sid);
		
		// Update shop
		shop.setName(name);
		shop.setDescription(description);
		shop.setType(type);
		shop.setOpenTime(openTime);
		shop.setCloseTime(closeTime);
		shop.getShopContact().setAddress(address);
		shop.getShopContact().setPhone(phone);
		
		// Return updated shop
		return shop;
	}

}
