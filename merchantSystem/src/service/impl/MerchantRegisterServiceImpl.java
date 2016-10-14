package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import dao.MerchantRegisterDao;
import dao.impl.MerchantRegisterDaoImpl;
import object.merchant.MeMerchant;
import object.merchant.Merchant;
import service.MerchantLoginService;
import service.MerchantRegisterService;
import util.DBUtil;

public class MerchantRegisterServiceImpl implements MerchantRegisterService{
	public MerchantRegisterDao merchantRegisterDao = new MerchantRegisterDaoImpl();

	@Override
	public int addMerchant(MeMerchant merchant) {
		// return mid, -1 if failed
		return merchantRegisterDao.addMerchant(merchant);
	}

	@Override
	public MeMerchant searchMerchant(int mid) {
		return merchantRegisterDao.searchMerchant(mid);
	}

}
