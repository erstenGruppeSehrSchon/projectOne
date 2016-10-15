package service.impl;

import java.util.ArrayList;
import java.util.List;

import object.Admin;
import object.merchant.AdminMerchant;

import org.apache.commons.lang3.StringUtils;

import service.AdminService;
import dao.AdminDao;
import dao.AdminMerchantDao;
import dao.impl.AdminDaoImpl;
import dao.impl.AdminMerchantDaoImpl;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao ad = new AdminDaoImpl();
	private AdminMerchantDao amd = new AdminMerchantDaoImpl();
	
	public List<AdminMerchant> findOutstandingMerchants() {
		List<AdminMerchant> outstanding = new ArrayList<AdminMerchant>();
		for (AdminMerchant am : amd.getAllMerchants()) {
			if (!StringUtils.equals(am.getStatus(), AdminMerchantDao.STATUS_ACCEPT)) {
				System.out.println(am.getName());
				System.out.println(am.getStatus());
				outstanding.add(am);
			}
		}
		return outstanding;
	}

	public Admin getAdmin(String id, String password) {
		return ad.getAdmin(id, password);
	}

}
