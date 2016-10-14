package dao;

import object.Admin;

public interface AdminDao {
	
	public Admin getAdmin(String id, String password);

}
