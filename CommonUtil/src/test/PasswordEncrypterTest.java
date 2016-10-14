package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.PasswordEncrypter;

public class PasswordEncrypterTest {

	// Test encrypted password length, should be 64
	@Test
	public void testEncryptedPasswordLength() {
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		String oriPassword1 = "123*ABC#";
		String oriPassword2 = "123*ABC#*(ASDA";
		String encryptedPassword1 = encrypter.getEncryptedPassword(oriPassword1);
		String encryptedPassword2 = encrypter.getEncryptedPassword(oriPassword2);
		assertEquals(64, encryptedPassword1.length());
		assertEquals(64, encryptedPassword2.length());
	}
	
	//Test encrypted password with same input, should be same
	@Test
	public void testSameInput() {
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		String oriPassword1 = "123*ABC#";
		String oriPassword2 = "123*ABC#";
		String encryptedPassword1 = encrypter.getEncryptedPassword(oriPassword1);
		String encryptedPassword2 = encrypter.getEncryptedPassword(oriPassword2);
		assertEquals(true, encryptedPassword1.equals(encryptedPassword2));
	}

	//Test encrypted password with same input, should be same
	@Test
	public void testDiffInput() {
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		String oriPassword1 = "123*ABC#";
		String oriPassword2 = "123*ABC#*(ASDA";
		String encryptedPassword1 = encrypter.getEncryptedPassword(oriPassword1);
		String encryptedPassword2 = encrypter.getEncryptedPassword(oriPassword2);
		assertEquals(false, encryptedPassword1.equals(encryptedPassword2));
	}
}
