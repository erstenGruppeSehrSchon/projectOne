package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Admin;

import service.AdminMerchantManager;
import service.AdminService;
import service.impl.AdminMerchantManagerImpl;
import service.impl.AdminServiceImpl;
import util.PasswordEncrypter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService as = new AdminServiceImpl();
	private AdminMerchantManager amm = new AdminMerchantManagerImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("adminLoginName");
		String password = request.getParameter("adminLoginPassword");
		
		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
		Admin admin = as.getAdmin(id, encrypter.getEncryptedPassword(password));

		if (admin != null) {
			// Store admin to session
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", admin);
			
			// Store outstanding merchants pending list
			request.setAttribute("aMerchants", amm.getOutstandingMerchants());
			request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Login Fail!");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
	}


}
