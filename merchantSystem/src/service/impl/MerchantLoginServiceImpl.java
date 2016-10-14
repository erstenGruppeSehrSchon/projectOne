package service.impl;

import service.MerchantLoginService;

public class MerchantLoginServiceImpl implements MerchantLoginService{
	private MerchantLoginService service = new MerchantLoginServiceImpl();

	@Override
	public int checkMerchantExist(String username, String password) {
		return service.checkMerchantExist(username, password);
		
	}

	@Override
	public String retrieveMerchantStatus(int mid) {
		// TODO Auto-generated method stub
		return service.retrieveMerchantStatus(mid);
	}

}
