package service.impl;


import po.Merchant;
import service.ClientManager;
import constant.Constant;

public class ClientManagerImpl implements ClientManager{
	
    Merchant merchant = new Merchant();

	@Override
	public int getMarchantId() {
		
		return merchant.getMid();
		
	}
	@Override
	public String getMarchanStatus() {
		// TODO Auto-generated method stub
		return merchant.getStatus();
	}
	@Override
	public boolean isMerchanAccept(int id) {
		String merchantStatus = merchant.getStatus();
		if(merchantStatus!=null && merchantStatus.isEmpty()&& merchantStatus.equals(Constant.MERCHANT_STATUS_ACCEPTED)){
			return true;
		}else if(merchantStatus!=null && merchantStatus.isEmpty()&& !merchantStatus.equals(Constant.MERCHANT_STATUS_ACCEPTED)){
			return false;
		}else{
			return false;
		}

	}
	
	

}
