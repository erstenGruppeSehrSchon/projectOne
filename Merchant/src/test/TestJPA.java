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
import po.Merchant;

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
	public void testPersist2() {
		// Create merchants
		Merchant merchant1 = new Merchant();
		merchant1.setMid(-1);
		merchant1.setUsername("m1");
		merchant1.setPassword("AAC11529ECCD0AA876CB2ECBF277476620F36E412E457D7B08B70324D57B1ECE");
		merchant1.setBirthDate(new Date());
		merchant1.setGender("M");
		merchant1.setName("Merchant A");
		merchant1.setRegDate(new Date());
		merchant1.setStatus("Pending");
		
		Merchant merchant2 = new Merchant();
		merchant2.setMid(-2);
		merchant1.setUsername("m2");
		merchant1.setPassword("AAC11529ECCD0AA876CB2ECBF277476620F36E412E457D7B08B70324D57B1ECE");
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
