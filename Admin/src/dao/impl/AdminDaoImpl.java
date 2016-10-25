package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Admin;
import dao.AdminDao;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Admin getAdmin(String username) {
		return em.find(Admin.class, username);
	}

}
