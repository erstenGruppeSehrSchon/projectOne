package ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Dish;
import po.Shop;
import service.ClientViewMerchantDishService;
import service.ShopManager;
import service.impl.ClientViewMerchantDishServiceImpl;
import service.impl.ShopManagerImpl;

/**
 * Servlet implementation class ShowShopDetailsServlet
 */
public class ShowShopDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopManager sm = new ShopManagerImpl();
	private ClientViewMerchantDishService cvmds = new ClientViewMerchantDishServiceImpl();
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	int sid = Integer.parseInt(request.getParameter("ShopId"));
			Shop shop = sm.findShopById(sid);
			ArrayList<Dish> dishes = cvmds.loadDishBySid(sid);
			request.setAttribute("shop", shop);
			request.setAttribute("dishes", dishes);
			request.getRequestDispatcher("showShop.jsp").forward(request, response);
		
			}


}