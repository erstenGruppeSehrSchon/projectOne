package dao;

import object.Admin;

public interface AdminDao {
	
	public Admin loadUser(String id, String password);

}
