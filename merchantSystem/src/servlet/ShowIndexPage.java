package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Dish;
import po.MeMerchant;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

/**
 * Servlet implementation class ShowAllInfo
 */
public class ShowIndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for security reason, only post request can be received
		
		// get mid from login servlet
		int mid= (Integer) request.getAttribute("mid");
		MeMerchant merchant = service.retrieveMerchantInfo(mid);
//		List<Dish> dishes = service.retrieveDishesByMid(mid);
				
		request.setAttribute("merchant", merchant);
//		request.setAttribute("dishes", dishes);
		request.setAttribute("mid", mid);
		request.getRequestDispatcher("merchantIndex.jsp").forward(request, response);
	}

}
