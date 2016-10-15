package service.impl;

import dao.MerchantLoginDao;
import dao.impl.MerchantLoginDaoImpl;
import service.MerchantLoginService;

public class MerchantLoginServiceImpl implements MerchantLoginService{
	private MerchantLoginDao dao = new MerchantLoginDaoImpl();

	@Override
	public int checkMerchantExist(String username, String password) {
		return dao.checkMerchantExist(username, password);
		
	}

	@Override
	public String retrieveMerchantStatus(int mid) {
		// TODO Auto-generated method stub
		return dao.retrieveMerchantStatus(mid);
	}

}
