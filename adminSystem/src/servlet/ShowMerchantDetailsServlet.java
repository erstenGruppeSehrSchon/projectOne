package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminMerchantManager;
import service.impl.AdminMerchantManagerImpl;

public class ShowMerchantDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AdminMerchantManager amm = new AdminMerchantManagerImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("merchant", amm.getMerchantById(id));
		request.getRequestDispatcher("showMerchantDetails.jsp").forward(request, response);
	}

}
