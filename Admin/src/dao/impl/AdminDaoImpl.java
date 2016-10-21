package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import po.Admin;
import dao.AdminDao;

public class AdminDaoImpl implements AdminDao {
	
	@Override
	public Admin getAdmin(String username) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
		EntityManager em = factory.createEntityManager();
		Admin admin = em.find(Admin.class, username);
		em.close();
		factory.close();
		return admin;
	}

}
