package service;

import common.po.Admin;

public interface AdminService {
	
	public Admin getAdmin(String id, String password);

}
