package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.merchant.MeMerchant;
import object.merchant.Merchant;
import service.MerchantRegisterService;
import service.impl.MerchantRegisterServiceImpl;

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
		merchant.setPassword(request.getParameter("password"));
		merchant.setName(request.getParameter("name"));
//		merchant.setBirth_date(request.getParameter("birth_date"));
//		merchant.setGender(request.getParameter("gender"));
//		merchant.setReg_date(request.getParameter("reg_date"));
		
		
		merchant.setImage_path(request.getParameter("img_path"));
		
		//...
		
		// add to db
		int mid = getMerchantRegisterService().addMerchant(merchant);
		
		int result = 0;
		if((result = getMerchantRegisterService().searchMerchant(mid)) != -1){
			System.out.println("add merchant success");
			
			// wait admin to accept page
			// still can modify shop name, shop logo, shop tel, shop address
			
		}
		else{
			
		}
		
		
	}

}
