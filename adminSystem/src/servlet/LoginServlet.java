package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminMerchantManager;
import service.AdminService;
import service.impl.AdminMerchantManagerImpl;
import service.impl.AdminServiceImpl;
import util.PasswordEncrypter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService as = new AdminServiceImpl();
	private AdminMerchantManager amm = new AdminMerchantManagerImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("adminLoginName");
		System.out.println(id);
		String password = request.getParameter("adminLoginPassword");
		System.out.println(password);
		System.out.println(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password));
		if (checkLogin(id, PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password))) {
			request.setAttribute("am", amm.getOutstandingMerchants());
			request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Login Fail!");
			request.getRequestDispatcher("adminLogin.html").forward(request, response);
		}
	}
	
	public boolean checkLogin(String id, String password) {
		System.out.println((as.getAdmin(id, password) != null));
		return as.getAdmin(id, password) != null;
	}

}
