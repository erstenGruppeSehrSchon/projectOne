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
	public Merchant getMerchant(int id) {
		return dao.getMerchant(id);
	}

	@Override
	public List<Merchant> getAllMerchants() {
		return dao.getAllMerchants();
	}

	@Override
	public List<Merchant> getMerchantsByCriteria(Integer id, String name, String gender, Integer ageIndex, String regDate, String status) {
		return dao.getMerchantsByCriteria(id, name, gender, ageIndex, regDate, status);
	}

}
