package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private AdminDao ad = new AdminDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		if (checkLogin(id, password)) {
			request.getRequestDispatcher("XXX.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Fail to login!");
		}
	}
	
	private boolean checkLogin(int id, String password) {
//		Admin admin = new Admin();
//		List<Admin> admins = ad.getInfo(admin);
		String dbPassword = null;
//		for (Admin a : admins) {
//			if (a.getId() == id) {
//				dbPassword = a.getPassword();
//				break;
//			}
//		}
//		return StringUtils..encode(password);
		return true;
	}

}
