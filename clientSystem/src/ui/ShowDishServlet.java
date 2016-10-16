package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Dish;
import po.Merchant;
import po.Shop;
import service.ClientViewMerchantDishService;
import service.MerchantManager;
import service.ShopManager;
import service.impl.ClientViewMerchantDishServiceImpl;
import service.impl.MerchantManagerImpl;
import service.impl.ShopManagerImpl;

public class ShowDishServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClientViewMerchantDishService cvmds = new ClientViewMerchantDishServiceImpl();
	private ShopManager sm = new ShopManagerImpl();
	private MerchantManager mm = new MerchantManagerImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Store to request attribute
		int did = Integer.parseInt(request.getParameter("dishId"));
		int sid = Integer.parseInt(request.getParameter("ShopId"));
	    
		
		
		Dish dish = cvmds.loadDishByDid(did);
		Shop shop = sm.findShopById(sid);
		Merchant merchant = mm.findMeMerchantById(shop.getMid());
		
		request.setAttribute("shop", shop);
		request.setAttribute("dish", dish);
		request.setAttribute("merchant", merchant);
		
		// Forward to dish page
  	    request.getRequestDispatcher("showDishes.jsp").forward(request, response);
	}

}
