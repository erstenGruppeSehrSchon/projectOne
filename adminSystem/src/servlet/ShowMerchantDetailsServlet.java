package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.merchant.AdminMerchant;

import service.AdminMerchantManager;
import service.impl.AdminMerchantManagerImpl;

public class ShowMerchantDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AdminMerchantManager amm = new AdminMerchantManagerImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminMerchant aMerchant = amm.getMerchantById(id);
			request.setAttribute("merchant", aMerchant);
		}
		request.getRequestDispatcher("showMerchantDetails.jsp").forward(request, response);
	}

}
