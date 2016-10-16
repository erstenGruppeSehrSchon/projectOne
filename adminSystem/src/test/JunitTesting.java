package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import service.AdminService;
import service.MerchantManager;
import service.impl.AdminServiceImpl;
import service.impl.MerchantManagerImpl;
import util.PasswordEncrypter;

public class JunitTesting {
	
	private AdminService as = new AdminServiceImpl();
	private MerchantManager mm = new MerchantManagerImpl();
	private Properties prop = new Properties();
	private InputStream in;

	@Test
	public void testLogin() throws Exception {
		Assert.assertTrue(as.getAdmin(getProperty("id.valid"), getEncryptedPassword(getProperty("password.valid"))) != null);
		Assert.assertTrue(as.getAdmin(getProperty("id.invalid"), getEncryptedPassword(getProperty("password.invalid"))) == null);	
		Assert.assertTrue(as.getAdmin(getProperty("id.valid"), getEncryptedPassword(getProperty("password.invalid"))) == null);
		Assert.assertTrue(as.getAdmin(getProperty("id.invalid"), getEncryptedPassword(getProperty("password.valid"))) == null);
	}
	
	@Test
	public void testPasswordEncryptor() throws Exception {
		Assert.assertTrue(StringUtils.equals(getEncryptedPassword(getProperty("password.valid")), getProperty("encryptedPassword.valid")));
	}
	
	@Test
	public void testGetMerchantById() throws Exception {
		Assert.assertTrue(mm.getMerchantById(Integer.parseInt(getProperty("merchant.id.valid"))) != null);
		Assert.assertTrue(mm.getMerchantById(Integer.parseInt(getProperty("merchant.id.invalid"))) == null);
	}
	
	@Test
	public void testGetAllMerchants() throws Exception {
		Assert.assertTrue(mm.getAllMerchants().size() == Integer.parseInt(getProperty("merchant.all.amount")));
	}
	
	@Test
	public void testGetOutstandingMerchants() throws Exception {
		Assert.assertTrue(mm.getOutstandingMerchants().size() == Integer.parseInt(getProperty("merchant.outstanding.amount")));
	}
	
	@Test
	public void testUpdateMerchantStatus() throws Exception {
		Assert.assertTrue(mm.updateMerchantStatus(getProperty("merchant.status.accepted"), Integer.parseInt(getProperty("merchant.id.valid"))));
		Assert.assertTrue(StringUtils.equals(mm.getMerchantById(Integer.parseInt(getProperty("merchant.id.valid"))).getStatus(), getProperty("merchant.status.accepted")));
		
		Assert.assertTrue(mm.updateMerchantStatus(getProperty("merchant.status.rejected"), Integer.parseInt(getProperty("merchant.id.valid"))));
		Assert.assertTrue(StringUtils.equals(mm.getMerchantById(Integer.parseInt(getProperty("merchant.id.valid"))).getStatus(), getProperty("merchant.status.rejected")));
		
		Assert.assertTrue(mm.updateMerchantStatus(getProperty("merchant.status.pending"), Integer.parseInt(getProperty("merchant.id.valid"))));
		Assert.assertTrue(StringUtils.equals(mm.getMerchantById(Integer.parseInt(getProperty("merchant.id.valid"))).getStatus(), getProperty("merchant.status.pending")));
		
		Assert.assertTrue(mm.updateMerchantStatus(getProperty("merchant.status.frozen"), Integer.parseInt(getProperty("merchant.id.valid"))));
		Assert.assertTrue(StringUtils.equals(mm.getMerchantById(Integer.parseInt(getProperty("merchant.id.valid"))).getStatus(), getProperty("merchant.status.frozen")));
		
		Assert.assertTrue(!mm.updateMerchantStatus(getProperty("merchant.status.accepted"), Integer.parseInt(getProperty("merchant.id.invalid"))));
		
		Assert.assertTrue(!mm.updateMerchantStatus(getProperty("merchant.status.rejected"), Integer.parseInt(getProperty("merchant.id.invalid"))));
		
		Assert.assertTrue(!mm.updateMerchantStatus(getProperty("merchant.status.pending"), Integer.parseInt(getProperty("merchant.id.invalid"))));
		
		Assert.assertTrue(!mm.updateMerchantStatus(getProperty("merchant.status.frozen"), Integer.parseInt(getProperty("merchant.id.invalid"))));
		
	}
	
	public String getEncryptedPassword(String password) {
		return PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password);
	}
	
	public String getProperty(String key) throws Exception {
		in = new FileInputStream("test.data");
		prop.load(in);
//		System.out.println(prop.getProperty(key));
		in.close();
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) throws Exception {
		JunitTesting j = new JunitTesting();
		System.out.println(j.getProperty("id.valid"));
	}

}
