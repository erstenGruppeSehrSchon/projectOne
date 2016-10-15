package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminMerchantManager;
import service.impl.AdminMerchantManagerImpl;

public class ShowOutstandingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private AdminMerchantManager amm = new AdminMerchantManagerImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Store outstanding merchants pending list
		request.setAttribute("aMerchants", amm.getOutstandingMerchants());
		
		// Forward to index page
		request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
