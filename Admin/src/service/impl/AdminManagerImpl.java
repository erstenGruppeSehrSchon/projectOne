package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminDao;
import po.Admin;
import service.AdminManager;
import common.util.PasswordEncrypter;

@Service
public class AdminManagerImpl implements AdminManager {
	
	@Autowired
	private AdminDao dao;
	
	@Override
	public Admin login(String username, String password) {
		Admin admin = dao.getAdmin(username);
		System.out.println("username" + username);
		System.out.println("password" + password);
				
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		String encryptedPassword = encrypter.encrypt(password);
		
		System.out.println(encryptedPassword);
		
		if (admin!=null && encryptedPassword.equals(admin.getPassword())) {
			// Remove password from object
			admin.setPassword(null);
			return admin;
		} else {
			return null;
		}
	}
	
}
