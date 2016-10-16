package servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import consts.Consts;
import exception.RegisterEmptyException;
import po.MeMerchant;
import po.Merchant;
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
	
		// get username
		String username = request.getParameter("merchantUsername");
		if(username != null && !username.trim().equals("")){
			username = request.getParameter("merchantUsername").trim();
			merchant.setUserName(username);
		}

		// get password
		String password = request.getParameter("merchantPassword");
		if(password != null && !password.trim().equals("")){
			password = request.getParameter("merchantPassword").trim();
			merchant.setPassword(PasswordEncrypter.getPasswordEncrypter().getEncryptedPassword(password));
		}
			
		// get name
		String name = request.getParameter("merchantRegName");
		if(name != null && !name.trim().equals("")){
			name = request.getParameter("merchantRegName").trim();
			merchant.setName(name);
		}
		
		// get gender
		String gender = request.getParameter("merchantGender");
		if(gender != null && !gender.trim().equals("")){
			gender = request.getParameter("merchantGender").trim();
			merchant.setGender(gender);
		}

		try {
			String birthDateStr = request.getParameter("merchantBirthDate");
			if(birthDateStr != null && !birthDateStr.trim().equals("")){
				birthDateStr = request.getParameter("merchantBirthDate").trim();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date birthDate = sdf.parse(birthDateStr);
				merchant.setBirth(birthDate);
			}
			
			merchant.setRegDate(new Date(System.currentTimeMillis()));
		} catch (ParseException e1) {
			e1.printStackTrace();
			request.setAttribute("errorMsg", Consts.REGISTER_FAIL);
			request.getRequestDispatcher("merchantRegistration.jsp").forward(request, response);
			return;
		}
			
		// default status = pending
		String status = Consts.PENDING;
		merchant.setStatus(status);	

		
		// add to db
		int result= 0;
		if((result = getMerchantRegisterService().addMerchant(merchant)) != -1){			
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
			request.setAttribute("status", status);
			request.getRequestDispatcher("showIndex").forward(request, response);
		}
		else{
			request.setAttribute("errorMsg", Consts.REGISTER_FAIL);
			request.getRequestDispatcher("merchantRegistration.jsp").forward(request, response);
		}
		
		
	}
	
	/*
	 *  not used in register
	 */
	public void getUploadIcon(HttpServletRequest request, int mid){
		String path=this.getServletContext().getRealPath("/" + mid);
		
		File f=new File(path);
		if (!f.exists()) {
            boolean status = f.mkdirs();
        }
		
		DiskFileItemFactory factory=new DiskFileItemFactory(10240,f );
		
		ServletFileUpload upload=new ServletFileUpload();
		upload.setFileItemFactory(factory);
		
		List<FileItem> fis=null;
		try {
			fis= upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OutputStream out = null;
		
		try {
			for(FileItem fi:fis){
				
				if(fi.isFormField()){
					System.out.println(fi.getFieldName() +"......."+fi.getString());
				}
				else{
//				InputStream in= fi.getInputStream();
//				byte[] bs=new byte[in.available()];
//				in.read(bs);
					//fi.write(file);
					out = new FileOutputStream(path + "/" +fi.getName());

			        int read = 0;
			        final byte[] bytes = new byte[1024];

			        while ((read = fi.getInputStream().read(bytes)) != -1) {
			            out.write(bytes, 0, read);
			        }
					System.out.println(fi.getSize());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

	}

}
