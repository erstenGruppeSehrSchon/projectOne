package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.po.MeMerchant;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

/**
 * Servlet implementation class ShowAddShopServlet
 */
public class ShowAddShopServlet extends HttpServlet {
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
		// get mid from login servlet
		int mid= 0;
		if(request.getParameter("mid") != null){
			mid = Integer.parseInt(request.getParameter("mid"));
		}
		else{
			mid = (Integer) request.getAttribute("mid");
		}
				
		request.setAttribute("mid", mid);
		request.getRequestDispatcher("merchantAddShop.jsp").forward(request, response);
	}

}
