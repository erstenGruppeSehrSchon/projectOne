package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.TODO;

import service.MerchantLoginService;
import service.impl.MerchantLoginServiceImpl;

/**
 * Servlet implementation class MerchantLoginServlet
 */
public class MerchantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantLoginService merchantLoginService = new MerchantLoginServiceImpl();

	public MerchantLoginService getMerchantLoginService() {
		return merchantLoginService;
	}

	public void setMerchantLoginService(MerchantLoginService merchantLoginService) {
		this.merchantLoginService = merchantLoginService;
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get username & password from request
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		// check user exist in merchant side
		if (getMerchantLoginService().checkMerchantExist(username, password)){
			
			String status = getMerchantLoginService().retrieveMerchantStatus(username, password);
			
			// accepted
			if(status.equals("")){
				
//				request.getRequestDispatcher("errorpagexxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
			}
			// pending
			else if(status.equals("")) {
//				request.getRequestDispatcher("errorpagexxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
			}
			else if(status.equals("")) {
//				request.getRequestDispatcher("errorpagexxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
			}
			else if(status.equals("")) {
//				request.getRequestDispatcher("errorpagexxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
			}
			// invalid status
			else {
				
			}
			
		}
		else {
			// user not exist in system
//			response.setAttribute("notExist","notExist");
			
			request.getRequestDispatcher("errorpagexxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
		}
		
	}
}