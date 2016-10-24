package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Merchant;

import service.MerchantManager;

import dao.MerchantDao;

@Service
public class MerchantManagerImpl implements MerchantManager {

	@Autowired
	private MerchantDao dao;

	public MerchantDao getDao() {
		return dao;
	}

	public void setDao(MerchantDao dao) {
		this.dao = dao;
	}

	@Override
	public Merchant getMerchantByMid(String mid) {
		return dao.getMerchantByMid(mid);
	}

	@Override
	public List<Merchant> getAllMerchants() {
		return dao.getAllMerchants();
	}
	
	
}
