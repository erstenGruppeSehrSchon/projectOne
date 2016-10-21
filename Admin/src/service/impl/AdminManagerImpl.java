package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminDao;
import po.Admin;
import service.AdminManager;
import util.PasswordEncrypter;

@Service
public class AdminManagerImpl implements AdminManager {
	
	@Autowired
	private AdminDao dao;
	
	public AdminDao getDao() {
		return dao;
	}

	public void setDao(AdminDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Admin login(String username, String password) {
		Admin admin = dao.getAdmin(username);
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		String encryptedPassword = encrypter.encrypt(password);
		return encryptedPassword.equals(admin.getPassword()) ? admin : null;
	}
	
}
