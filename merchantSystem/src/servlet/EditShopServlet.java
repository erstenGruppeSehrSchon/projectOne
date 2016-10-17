package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Shop;
import service.MerchantShopService;
import service.impl.MerchantShopServiceImpl;

/**
 * Servlet implementation class EditShopServlet
 */
public class EditShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MerchantShopService mss = new MerchantShopServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Shop shop = new Shop();
		shop.setSid(Integer.parseInt(request.getParameter("")));
		shop.setMid(Integer.parseInt(request.getParameter("")));
//		shop.set
//		mss.updateShop(shop);
	}

}
