package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import consts.Consts;
import object.Dish;
import object.merchant.MeMerchant;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

/**
 * Servlet implementation class ShowProfileServlet
 */
public class ShowProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for security reason, only post request can be received
		
		// get mid from login servlet
		int mid= Integer.parseInt(request.getParameter("mid"));
		MeMerchant merchant = service.retrieveMerchantInfo(mid);
		
		request.setAttribute("merchant", merchant);
		request.getRequestDispatcher("xxxxxxxxxxxxxxxx").forward(request, response);
	}

}
