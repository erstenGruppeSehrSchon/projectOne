package service.impl;

import java.util.ArrayList;
import java.util.List;

import object.Admin;
import object.merchant.AdminMerchant;

import org.apache.commons.lang3.StringUtils;

import service.AdminService;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao ad = new AdminDaoImpl();
	
	private final String STATUS_ACCEPT = "Accepted";
//	private final String STATUS_PENDING = "Pending";
//	private final String STATUS_REJECT = "Rejected";
//	private final String STATUS_FROZEN = "Frozen";
	
	public List<AdminMerchant> findOutstandingMerchants() {
		List<AdminMerchant> outstanding = new ArrayList<AdminMerchant>();
		for (AdminMerchant am : ad.findAllMerchants()) {
			if (!StringUtils.equals(am.getStatus(), STATUS_ACCEPT)) {
				System.out.println(am.getName());
				System.out.println(am.getStatus());
				outstanding.add(am);
			}
		}
		return outstanding;
	}

	public Admin loadUser(String id, String password) {
		return ad.loadUser(id, password);
	}

	public List<AdminMerchant> findAllMerchants() {
		return ad.findAllMerchants();
	}

}
