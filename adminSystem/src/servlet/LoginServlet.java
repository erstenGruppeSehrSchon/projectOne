package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import object.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;
import util.PasswordEncrypter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService as = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = null;
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") != null) { 
			// Check if already logged on
			admin = (Admin)session.getAttribute("admin");
			
		} else if (request.getParameter("adminLoginName") != null && request.getParameter("adminLoginPassword") != null){
			// If not logged on, try to log on using user input
			String id = request.getParameter("adminLoginName");
			String password = request.getParameter("adminLoginPassword");
			PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
			admin = as.getAdmin(id, encrypter.getEncryptedPassword(password));
		}

		if (admin != null) {
			// Store admin to session
			session.setAttribute("admin", admin);
			
			// Redirect to ShowOutstanding servlet for getting outstanding merchant list
			response.sendRedirect("ShowOutstanding");

		} else {
			request.setAttribute("errorMsg", "Login Fail!");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
	}


}
