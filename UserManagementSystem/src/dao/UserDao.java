package dao;

import java.util.ArrayList;
import po.User;

public interface UserDao {

	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	public ArrayList<User> getAllUsers();
	public User getUser(int id);
}
