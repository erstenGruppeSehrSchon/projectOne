package service.impl;

import java.util.ArrayList;

import dao.UserDao;
import dao.impl.UserDaoImpl;

import po.User;
import service.UserManager;

public class UserManagerImpl implements UserManager {

	private UserDao ud = new UserDaoImpl();
	
	@Override
	public void addUser(User user) {
		ud.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		ud.updateUser(user);		
	}

	@Override
	public void deleteUser(int id) {
		ud.deleteUser(id);
	}

	@Override
	public User getUser(int id) {
		return ud.getUser(id);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return ud.getAllUsers();
	}

}
