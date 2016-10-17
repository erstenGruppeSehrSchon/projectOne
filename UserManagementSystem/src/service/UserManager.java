package service;

import java.util.ArrayList;

import po.User;

public interface UserManager {

	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);
	public ArrayList<User> getAllUsers();
}
