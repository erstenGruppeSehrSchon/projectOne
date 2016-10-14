package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.merchant.MeMerchant;
import object.merchant.Merchant;
import service.MerchantRegisterService;
import service.impl.MerchantRegisterServiceImpl;
import util.PasswordEncrypter;

/**
 * Servlet implementation class MerchantRegisterServlet
 */
public class MerchantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantRegisterService merchantRegisterService = new MerchantRegisterServiceImpl();
	
	public MerchantRegisterService getMerchantRegisterService() {
		return merchantRegisterService;
	}
	public void setMerchantRegisterService(MerchantRegisterService merchantRegisterService) {
		this.merchantRegisterService = merchantRegisterService;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// retrieve data from user
		MeMerchant merchant = new MeMerchant();
		merchant.setUserName(request.getParameter("username"));
		merchant.setPassword(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(request.getParameter("password")));
		merchant.setName(request.getParameter("name"));
		merchant.setGender(request.getParameter("gender"));

		try {
			String birthDateStr = request.getParameter("birth_date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date birthDate = sdf.parse(birthDateStr);
			merchant.setBirth(birthDate);
			
			String regDateStr = request.getParameter("reg_date");
			Date regDate = sdf.parse(regDateStr);
			merchant.setRegDate(regDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		// add to db
		int result= 0;
		if((result = getMerchantRegisterService().addMerchant(merchant)) != -1){
			System.out.println("add merchant success");
			
			// wait admin to accept page
			// still can modify shop name, shop logo, shop tel, shop address
			request.setAttribute("id", result);
			request.getRequestDispatcher("xxxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
		}
		else{
			System.out.println("add merchant fail");
			request.setAttribute("errorMsg", "Register Fail!");
			request.getRequestDispatcher("xxxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
		}
		
		
	}

}
