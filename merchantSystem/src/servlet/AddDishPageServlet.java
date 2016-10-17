package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

import common.po.Shop;

public class AddDishPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MerchantProfileService mps = new MerchantProfileServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		// Get all shop of this merchants
		List<Shop> shops = mps.retrieveShopOnly(mid);
		
		// Store to attribute
		request.setAttribute("shops", shops);
		
		// Forward to add dish page
		request.getRequestDispatcher("merchantAddDish.jsp").forward(request, response);
		
	}

}
