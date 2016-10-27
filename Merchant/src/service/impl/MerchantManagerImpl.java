package service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Merchant;
import dao.MerchantDao;
import service.MerchantManager;
import common.util.DateFormatter;
import common.util.PasswordEncrypter;

@Service
public class MerchantManagerImpl implements MerchantManager {

	private static final String DEFAULT_STATUS = "Pending";
	
	@Autowired
	private MerchantDao dao;


	@Override
	public Merchant login(String username, String password) {
		// Encrypt password input by user
		Merchant merchant = dao.getMerchantByUsername(username);
		
		// prevent exception
		if(merchant == null)
			return null;
				
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		String encryptedPassword = encrypter.encrypt(password);
		System.out.println(merchant == null);
		if (encryptedPassword.equals(merchant.getPassword())) {
			// Remove password from object
			merchant.setPassword(null);
			return merchant;
		} else {
			return null;
		}
	}

	@Override
	public Merchant getMerchantByMid(String mid) {
		return dao.getMerchantByMid(mid);
	}

	@Override
	public Merchant addMerchant(String username, String password, String name, String gender, String birthDate) {
		// Encrypt password
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		String encryptedPassword = encrypter.encrypt(password);
		
		// Convert String to Date
		DateFormatter formatter = DateFormatter.getDateFormatter();
		Date formattedBirthDate = formatter.parseDate(birthDate);
		
		// Create merchant object
		Merchant merchant = new Merchant();
		merchant.setUsername(username);
		merchant.setPassword(encryptedPassword);
		merchant.setName(name);
		merchant.setGender(gender);
		merchant.setBirthDate(formattedBirthDate);
		merchant.setRegDate(new Date());
		merchant.setStatus(DEFAULT_STATUS);
		
		// Add to database and return
		return dao.addMerchant(merchant);
	}
	
	@Override
	public Merchant updateMerchantStatus(String mid, String status) {
		return dao.updateMerchantStatus(mid, status);
	}
	
}
