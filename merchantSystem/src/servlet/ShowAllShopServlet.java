package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.po.MeMerchant;
import common.po.Shop;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

/**
 * Servlet implementation class ShowAllShop
 */
public class ShowAllShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid= 0;
		if (request.getParameter("mid") != null){
			mid= Integer.parseInt(request.getParameter("mid"));
		}
		else {
			mid = (Integer) request.getAttribute("mid");
		}
				
		List<Shop> shops = service.retrieveShopOnly(mid);
		request.setAttribute("shops", shops);
		request.setAttribute("mid", mid);
		request.getRequestDispatcher("merchantShowAllShop.jsp").forward(request, response);
	}

}
