package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import dao.MerchantRegisterDao;
import dao.impl.MerchantRegisterDaoImpl;
import common.po.MeMerchant;
import common.po.Merchant;
import service.MerchantLoginService;
import service.MerchantRegisterService;
import util.DBUtil;

public class MerchantRegisterServiceImpl implements MerchantRegisterService{
	public MerchantRegisterDao merchantRegisterDao = new MerchantRegisterDaoImpl();

	@Override
	public int addMerchant(MeMerchant merchant) {
		// check field empty
		if(merchant.getUserName() == null || merchant.getUserName().equals(""))
			return -1;
		if(merchant.getPassword() ==null || merchant.getPassword().equals(""))
			return -1;
		if(merchant.getName() == null || merchant.getName().equals(""))
			return -1;
		if(merchant.getGender() == null || merchant.getGender().equals(""))
			return -1;
		if(merchant.getBirth() == null)
			return -1;
		
		// return mid, -1 if failed
		return merchantRegisterDao.addMerchantWithoutShop(merchant);
	}

	@Override
	public MeMerchant searchMerchant(int mid) {
		return merchantRegisterDao.searchMerchant(mid);
	}

}
