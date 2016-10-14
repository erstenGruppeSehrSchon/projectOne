package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.PasswordEncrypter;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;



/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminDao ad = new AdminDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("adminLoginName");
		System.out.println(id);
		String password = request.getParameter("adminLoginPassword");
		System.out.println(password);
		System.out.println(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password));
		if (checkLogin(id, PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password))) {
			request.getRequestDispatcher("adminIndex.html").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Login Fail!");
			request.getRequestDispatcher("adminLogin.html").forward(request, response);
		}
	}
	
	public boolean checkLogin(String id, String password) {
		System.out.println((ad.loadUser(id, password) != null));
		return ad.loadUser(id, password) != null;
	}

}
