package dao;

import po.Admin;

public interface AdminDao {
	
	public Admin getAdmin(String id, String password);

}
