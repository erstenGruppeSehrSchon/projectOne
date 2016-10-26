package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import po.Admin;
import po.Advertisement;
import po.Merchant;
import service.AdminManager;
import service.AdvertisementManager;
import service.MerchantManager;

@Controller
@SessionAttributes("admin")
public class AdminController {
	
	@Autowired
	private AdminManager adminManager;
	
	@Autowired
	private MerchantManager merchantManager;
	
	@Autowired
	private AdvertisementManager advertisementManager;
	
	@RequestMapping(value="login", method={RequestMethod.POST})
	public ModelAndView login(String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        
        // Set view
        modelAndView.setViewName("index");

        // Set admin object (null if fail)
        Admin admin = adminManager.login(username, password);
        modelAndView.addObject("admin", admin);
        
		return modelAndView;
	}
	
	@RequestMapping(value="getMerchantByMid", method={RequestMethod.GET})
	@ResponseBody
	public Merchant getMerchant(int mid) {
		return merchantManager.getMerchantByMid(mid);
	}
	
	@RequestMapping(value="getAllMerchants", method={RequestMethod.GET})
	@ResponseBody
	public List<Merchant> getAllMerchants() {
		return merchantManager.getAllMerchants();
	}
	
	@RequestMapping(value="getMerchantsByCriteria", method={RequestMethod.GET})
	@ResponseBody
	public List<Merchant> getMerchantsByCriteria(Integer mid, String name, String gender, Integer ageIndex, String regDate, String status) {
		return merchantManager.getMerchantsByCriteria(mid, name, gender, ageIndex, regDate, status);
	}
	
	@RequestMapping(value="updateMerchantStatus", method={RequestMethod.POST})
	@ResponseBody
	public Merchant updateMerchantStatus(String mid, String status) {
		return merchantManager.updateMerchantStatus(mid, status);
	}
	
	@RequestMapping(value="getAdvertisementsByStatus", method={RequestMethod.GET})
	@ResponseBody
	public List<Advertisement> getAdvertisementsByStatus(String status) {
		System.out.println("enter getAdvertisementsByStatus " + status);
		return advertisementManager.getAdvertisementsByStatus(status);
	}
	
	//http://localhost:8080/Admin/updateAdvertisementStatus?advId=-1&status=abc
	@RequestMapping(value="updateAdvertisementStatus", method={RequestMethod.GET})
	@ResponseBody
	public void updateAdvertisementStatus(Integer advId, String status) {
		System.out.println("enter updateAdvertisementStatus " + status);
		advertisementManager.updateAdvertisementStatus(advId, status);
	}
	
}
