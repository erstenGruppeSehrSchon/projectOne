package dao;

import common.po.Admin;

public interface AdminDao {
	
	public Admin getAdmin(String id, String password);

}
