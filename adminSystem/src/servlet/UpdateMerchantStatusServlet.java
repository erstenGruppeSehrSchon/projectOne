package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MerchantManager;
import service.impl.MerchantManagerImpl;

public class UpdateMerchantStatusServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MerchantManager mm = new MerchantManagerImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		System.out.println("Update id = " + id);
		System.out.println("Update status = " + status);
		if (mm.updateMerchantStatus(status, id)) {
			request.setAttribute("message", "Update successful!");
		} else {
			request.setAttribute("message", "Fail to update, pls try again!");
		}
		
		// Forward to ShowOutstanding servlet for getting outstanding merchant list
		request.getRequestDispatcher("ShowOutstanding").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	

}
