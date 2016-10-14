package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import servlet.LoginServlet;
import util.PasswordEncrypter;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;

public class JunitTesting {
	
	private AdminDao ad = new AdminDaoImpl();
	private Properties prop = new Properties();
	private InputStream in;

	@Test
	public void testDaoLoadUser() throws Exception {
		in = new FileInputStream("test.data");
		prop.load(in);
		System.out.println(ad.getAdmin(prop.getProperty("id"), prop.getProperty("password")));
	}
	
	@Test
	public void testCheckLogin() throws Exception {
		LoginServlet l = new LoginServlet();
		l.checkLogin(prop.getProperty("id"), prop.getProperty("password"));
	}
	
	@Test
	public void testPasswordEncryptor() {
		System.out.println(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(prop.getProperty("password")));
	}

}
