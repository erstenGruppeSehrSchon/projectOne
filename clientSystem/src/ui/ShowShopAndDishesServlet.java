package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.Shop;
import service.ShopManager;
import service.impl.ShopManagerImpl;

public class ShowShopAndDishesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private ShopManager sh = new ShopManagerImpl();
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get shop info
		int sid = Integer.parseInt(request.getParameter("sid"));
		Shop shop = sh.findShopById(sid);	// Include shop, shop contacts and dishes
		
		// Store to request attribute
		request.setAttribute("shop", shop);
		
		// Forward to shop detail page
		
	}


}
