package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.merchant.AdminMerchant;

import dao.AdminMerchantDao;
import dao.impl.AdminMerchantDaoImpl;

public class SearchMerchantByCriteriaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private AdminMerchantDao am = new AdminMerchantDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get user input
		Integer id = null;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		String name = null;
		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
		}
		
		Integer ageIndex = Integer.parseInt(request.getParameter("ageIndex"));
		
		String gender = request.getParameter("gender");
		
		String regDate = null;
		if (request.getParameter("regDate") != null) {
			regDate = request.getParameter("regDate");
		}
		
		// Search merchant based on input
		ArrayList<AdminMerchant> aMerchants = am.getMerchantByCriteria(id, name, ageIndex, gender, regDate);
		
		// Store search result and forward to result page
		request.setAttribute("aMerchants", aMerchants);
		request.getRequestDispatcher("adminSearchResult.jsp").forward(request, response);
	}

}
