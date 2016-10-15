package service.impl;

import po.Admin;
import service.AdminService;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao ad = new AdminDaoImpl();

	@Override
	public Admin getAdmin(String id, String password) {
		return ad.getAdmin(id, password);
	}

}
