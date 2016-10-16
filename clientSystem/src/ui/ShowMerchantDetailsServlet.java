package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.Merchant;
import service.MerchantManager;
import service.impl.MerchantManagerImpl;

public class ShowMerchantDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MerchantManager mm = new MerchantManagerImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("MerchantId") != null) {
			int id = Integer.parseInt(request.getParameter("MerchantId"));
			Merchant merchant = mm.findMeMerchantById(id);
			request.setAttribute("merchant", merchant);
		}
		request.getRequestDispatcher("showMerchantDetails.jsp").forward(request, response);
	}

}
