package service;

import org.springframework.web.servlet.ModelAndView;

public interface ShopInfoManager {
	public ModelAndView getShopInfoBySid (String sid);
	public ModelAndView getDishInfoByDid(String did,String sid);
	
}
