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
import po.MeMerchant;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;
import util.PasswordEncrypter;

/**
 * Servlet implementation class EditProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// retrieve data from user
		MeMerchant merchant = new MeMerchant();
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		merchant.setMid(mid);
		
		// get password
		String oldPassword = request.getParameter("merchantOldPassword");
		if(oldPassword != null && !oldPassword.trim().equals("")){
			oldPassword = oldPassword.trim();
			oldPassword = PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(oldPassword);
		}

		
		// get username
		String name = request.getParameter("merchantName");
		if(name != null && !name.trim().equals("")){
			name = name.trim();
			merchant.setName(name);
		}

					
		// get name
		String newPassword = request.getParameter("merchantNewPassword");
		if(newPassword != null && !newPassword.trim().equals("")){
			newPassword = newPassword.trim();
			merchant.setPassword(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(newPassword));
		}
				
		// get gender
		String gender = request.getParameter("merchantGender");
		if(gender != null && !gender.trim().equals("")){
			gender = gender.trim();
			merchant.setGender(gender);
		}

		try {
			String birthDateStr = request.getParameter("merchantBirth");
			if(birthDateStr != null && !birthDateStr.trim().equals("")){
				birthDateStr = birthDateStr.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthDate = sdf.parse(birthDateStr);
				merchant.setBirth(birthDate);
			}
	
		} catch (ParseException e1) {
			e1.printStackTrace();
			request.setAttribute("errorMsg", Consts.UPDATE_FAIL);
			request.getRequestDispatcher("merchantProfileEdit.jsp").forward(request, response);
			return;
		}
		
		if(service.updateMerchantInfo(merchant, oldPassword)){
			request.setAttribute("mid", mid);
			request.getRequestDispatcher("merchantIndex.jsp").forward(request, response);
		}
		else {
			request.setAttribute("mid", mid);
			request.setAttribute("errorMsg", Consts.UPDATE_FAIL);
			request.getRequestDispatcher("merchantProfileEdit.jsp").forward(request, response);
		}
	}

}
