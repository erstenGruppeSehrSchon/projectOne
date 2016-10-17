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
 * Servlet implementation class ShowEditPageServlet
 */
public class ShowEditPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for security reason, only post request can be received
		
		// get mid from login servlet
		int mid = 0 ;
		if(request.getParameter("mid") != null)
			mid = Integer.parseInt(request.getParameter("mid"));
		else 
			mid = (Integer) request.getAttribute("mid");
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String regDate = request.getParameter("regDate");
		String status = request.getParameter("status");
		
		request.setAttribute("mid", mid);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		request.setAttribute("birth", birth);
		request.setAttribute("gender", gender);
		request.setAttribute("regDate", regDate);
		request.setAttribute("status", status);
		
		request.getRequestDispatcher("merchantProfileEdit.jsp").forward(request, response);
	}

}
