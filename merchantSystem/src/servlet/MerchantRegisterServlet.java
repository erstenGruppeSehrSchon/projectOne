package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import consts.Consts;
import exception.RegisterEmptyException;
import object.merchant.MeMerchant;
import object.merchant.Merchant;
import service.MerchantRegisterService;
import service.impl.MerchantRegisterServiceImpl;
import util.PasswordEncrypter;
import util.SendJMSRequestUtil;

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
		try {
			
			// check username is empty
			String username= request.getParameter("username");
			if(username != null && !username.equals(""))
				merchant.setUserName(username);
			else
				throw new RegisterEmptyException(Consts.USERNAME_CANNOT_EMPTY);
			
			// check password is empty
			String password = request.getParameter("password");
			if(password !=null && !password.equals(""))
				merchant.setPassword(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password));
			else 
				throw new RegisterEmptyException(Consts.PASSWORD_CANNOT_EMPTY);
			
			// check name is empty
			String name = request.getParameter("name");
			if(name != null && !name.equals(""))
				merchant.setName(name);
			else
				throw new RegisterEmptyException(Consts.NAME_CANNOT_EMPTY);
			
			//check gender is empty
			String gender = request.getParameter("gender");
			if(gender != null && !name.equals(""))
				merchant.setGender(gender);
			else
				throw new RegisterEmptyException(Consts.GENDER_CANNOT_EMPTY);

			String birthDateStr = request.getParameter("birth_date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date birthDate = sdf.parse(birthDateStr);
			merchant.setBirth(birthDate);
			
			String regDateStr = request.getParameter("reg_date");
			Date regDate = sdf.parse(regDateStr);
			merchant.setRegDate(regDate);
			
			// default status = pending
			String status = Consts.PENDING;
			merchant.setStatus(status);
			
			// to do : some shop here .....
			
		} catch (ParseException e) {
			request.setAttribute("errorMsg", Consts.INVALID_DATE);
			request.getRequestDispatcher("xxxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
		} catch (RegisterEmptyException e){
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("xxxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
		}
		
				
		// add to db
		int result= 0;
		if((result = getMerchantRegisterService().addMerchant(merchant)) != -1){
			System.out.println("add merchant success");
			
			// call jms
			try {
				SendJMSRequestUtil.sendRegisterRequest(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// wait admin to accept page
			// still can modify shop name, shop logo, shop tel, shop address
			request.setAttribute("mid", result);
			request.getRequestDispatcher("xxxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
		}
		else{
			System.out.println("add merchant fail");
			request.setAttribute("errorMsg", "Register Fail!");
			request.getRequestDispatcher("xxxxxxxxxxxxxxxxxxxxxxxxx").forward(request, response);
		}
		
		
	}

}
