package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.TODO;

import consts.Consts;
import exception.LoginEmptyException;
import service.MerchantLoginService;
import service.impl.MerchantLoginServiceImpl;
import util.PasswordEncrypter;

/**
 * Servlet implementation class MerchantLoginServlet
 */
public class MerchantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantLoginService service = new MerchantLoginServiceImpl();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get username & password from request
		String username = "";
		String encryPw = "";
		
		
		// check user & password is empty
		try {
			username = (String) request.getParameter("username");
			if(username == null || username.equals(""))
//				throw new LoginEmptyException(Consts.USERNAME_CANNOT_EMPTY);
				throw new LoginEmptyException(Consts.LOGIN_FAILURE);
			
			String password = (String) request.getParameter("password");
			if(password == null || password.equals(""))
//				throw new LoginEmptyException(Consts.PASSWORD_CANNOT_EMPTY);
				throw new LoginEmptyException(Consts.LOGIN_FAILURE);
			
			encryPw = PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password);
		} catch (LoginEmptyException e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("merchantLogin.jsp").forward(request, response);
//			response.sendRedirect("merchantLogin.jsp?errorMsg="+e.getMessage());
			return;
		}
		
		int mid = 0;
		
		// check user exist in merchant side
		if ((mid = service.checkMerchantExist(username, encryPw)) != 0){
			
			System.out.println(mid);
			
			// get merchant status with mid
			String status = service.retrieveMerchantStatus(mid);
			
			System.out.println(status);

			// accepted
			if(status.equals(Consts.ACCEPTED)){
				request.setAttribute("mid", mid);
				
				// show profile
//				request.getRequestDispatcher("showProfile?mid="+mid);
				request.getRequestDispatcher("showProfile").forward(request, response);
			}
			// rejected
			else if(status.equals(Consts.REJECTED)) {
				request.setAttribute("status", status);
//				request.setAttribute("errorMsg", Consts.REJECTED_ERROR);
				request.setAttribute("errorMsg", Consts.LOGIN_FAILURE);
				request.getRequestDispatcher("merchantLogin.jsp").forward(request, response);
			}
			// frozen
			else if(status.equals(Consts.FROZEN)) {
				request.setAttribute("status", status);
//				request.setAttribute("errorMsg", Consts.FROZEN_ERROR);
				request.setAttribute("errorMsg", Consts.LOGIN_FAILURE);
				request.getRequestDispatcher("merchantLogin.jsp").forward(request, response);
			}
			// pending
			else if(status.equals(Consts.PENDING)) {
				request.setAttribute("status", status);
//				request.setAttribute("errorMsg", Consts.PENDING_ERROR);
				request.setAttribute("errorMsg", Consts.LOGIN_FAILURE);
				request.getRequestDispatcher("merchantLogin.jsp").forward(request, response);
			}
			// invalid status
			else {
				request.setAttribute("errorMsg", Consts.LOGIN_FAILURE);
				request.getRequestDispatcher("merchantLogin.jsp").forward(request, response);
			}
			
		}
		else {
			// user not exist in system
//			request.setAttribute("errorMsg", Consts.USER_NOT_EXIST);
			request.setAttribute("errorMsg", Consts.LOGIN_FAILURE);
			request.getRequestDispatcher("merchantLogin.jsp").forward(request, response);
		}
		
	}
}
