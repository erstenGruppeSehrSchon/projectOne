package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminMerchantManager;
import service.impl.AdminMerchantManagerImpl;

public class UpdateMerchantStatusServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AdminMerchantManager amm = new AdminMerchantManagerImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		System.out.println("Update id = " + id);
		System.out.println("Update status = " + status);
		if (amm.updateMerchantStatus(status, id)) {
			request.setAttribute("message", "Update successful!");
		} else {
			request.setAttribute("message", "Fail to update, pls try again!");
		}
		request.setAttribute("am", amm.getOutstandingMerchants());
		request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	

}
