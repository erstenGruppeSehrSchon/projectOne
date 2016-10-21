package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Admin;
import po.Merchant;
import service.AdminManager;
import service.MerchantManager;

@Controller
public class AdminController {
	
	@Autowired
	private AdminManager adminManager;
	
	@Autowired
	private MerchantManager merchantManager;
	
	@RequestMapping(value="login", method={RequestMethod.POST})
	@ResponseBody
	public Admin login(String username, String password) {
		return adminManager.login(username, password);
	}
	
	@RequestMapping(value="getMerchant", method={RequestMethod.GET})
	@ResponseBody
	public Merchant getMerchant(int id) {
		return merchantManager.getMerchant(id);
	}
	
	@RequestMapping(value="getAllMerchant", method={RequestMethod.GET})
	@ResponseBody
	public List<Merchant> getAllMerchants() {
		return merchantManager.getAllMerchants();
	}
	
	@RequestMapping(value="getMerchantsByCriteria", method={RequestMethod.GET})
	@ResponseBody
	public List<Merchant> getMerchantsByCriteria(Integer id, String name, String gender, Integer ageIndex, String regDate, String status) {
		return merchantManager.getMerchantsByCriteria(id, name, gender, ageIndex, regDate, status);
	}
}
