package test;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import po.Admin;
import po.Merchant;
import util.PasswordEncrypter;

public class TestJPA {

	private static EntityManagerFactory factory;
	private EntityManager em;
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("project");
	}
	
	@Before
	public void start() {
		em = factory.createEntityManager(); 
	}
	
	@After
	public void end() {
		em.close();
	}
	
	@AfterClass
	public static void destroy() {
		factory.close();
	}
	
	
	@Test
	public void testPersist() {
		// Create admin
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword(PasswordEncrypter.getPasswordEncrypter().encrypt("123"));
		
		// Open transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Persist
		em.persist(admin);
		
		// Commit;
		tx.commit();
	}
	
	@Test
	public void testPersist2() {
		// Create merchants
		Merchant merchant1 = new Merchant();
		merchant1.setId(-1);
		merchant1.setBirthDate(new Date());
		merchant1.setGender("M");
		merchant1.setName("Merchant A");
		merchant1.setRegDate(new Date());
		merchant1.setStatus("Pending");
		
		Merchant merchant2 = new Merchant();
		merchant2.setId(-2);
		merchant2.setBirthDate(new Date());
		merchant2.setGender("Unknown");
		merchant2.setName("Merchant B");
		merchant2.setRegDate(new Date());
		merchant2.setStatus("Pending");
		
		// Open transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Persist
		em.persist(merchant1);
		em.persist(merchant2);
		
		// Commit;
		tx.commit();
	}
}
