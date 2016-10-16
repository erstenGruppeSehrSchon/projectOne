package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Shop;
import service.ShopManager;
import service.impl.ShopManagerImpl;

/**
 * Servlet implementation class ShowShopDetailsServlet
 */
public class ShowShopDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopManager sm = new ShopManagerImpl();
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	int sid = Integer.parseInt(request.getParameter("ShopId"));
			Shop shop = sm.findShopById(sid);
			request.setAttribute("shop", shop);
			request.getRequestDispatcher("shopShop.jsp").forward(request, response);
		
			}


}
