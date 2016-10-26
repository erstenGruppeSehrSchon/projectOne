package service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.MerchantDao;
import po.Merchant;
import service.MerchantManager;

@Service
public class MerchantManagerImpl implements MerchantManager {

	@Autowired
	private MerchantDao dao;
	
	@Override
	public Merchant getMerchantByMid(int mid) {
		return dao.getMerchantByMid(mid);
	}

	@Override
	public List<Merchant> getAllMerchants() {
		return dao.getAllMerchants();
	}

	@Override
	public List<Merchant> getMerchantsByCriteria(Integer mid, String name, String gender, Integer ageIndex, String regDate, String status) {
		return dao.getMerchantsByCriteria(mid, name, gender, ageIndex, regDate, status);
	}

	@Override
	public Merchant updateMerchantStatus(String mid, String status) {
		return dao.updateMerchantStatus(mid, status);
	}

}
