package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.Merchant;
import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;

public class SearchMerchantByCriteriaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private MerchantDao md = new MerchantDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get user input
		Integer id = null;
		if (request.getParameter("id") != null && request.getParameter("id").length() > 0) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		String name = null;
		if (request.getParameter("name") != null && request.getParameter("name").length() > 0) {
			name = request.getParameter("name");
		}
		Integer ageIndex = Integer.parseInt(request.getParameter("ageIndex"));
		
		String gender = request.getParameter("gender");
		
		String regDate = null;
		if (request.getParameter("regDate") != null && request.getParameter("regDate").length() > 0) {
			regDate = request.getParameter("regDate");
		}
		
		// Search merchant based on input
		ArrayList<Merchant> aMerchants = md.getMerchantByCriteria(id, name, ageIndex, gender, regDate);

		// Store search result and forward to result page
		request.setAttribute("aMerchants", aMerchants);
		request.getRequestDispatcher("adminSearchResult.jsp").forward(request, response);
	}

}
