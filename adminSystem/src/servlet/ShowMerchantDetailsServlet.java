package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.po.Merchant;

import service.MerchantManager;
import service.impl.MerchantManagerImpl;

public class ShowMerchantDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MerchantManager mm = new MerchantManagerImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			Merchant aMerchant = mm.getMerchantById(id);
			request.setAttribute("merchant", aMerchant);
		}
		request.getRequestDispatcher("showMerchantDetails.jsp").forward(request, response);
	}

}
