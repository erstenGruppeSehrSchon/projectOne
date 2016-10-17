package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.po.MeMerchant;
import common.po.Shop;
import common.po.ShopContact;
import consts.Consts;
import service.MerchantShopService;
import service.impl.MerchantShopServiceImpl;
import util.PasswordEncrypter;

/**
 * Servlet implementation class NewShopServlet
 */
public class AddShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MerchantShopService service = new MerchantShopServiceImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// retrieve data from user
		Shop shop = new Shop();
		
		int mid = 0 ;
		if(request.getParameter("mid") != null)
			mid = Integer.parseInt(request.getParameter("mid"));
		else 
			mid = (Integer) request.getAttribute("mid");
				
		shop.setMid(mid);
		
		// get username
		String name = request.getParameter("shopRegName");
		if(name != null && !name.trim().equals("")){
			name = name.trim();
			shop.setName(name);
		}
		
		// get description
		String descr = request.getParameter("shopRegDescription");
		if(descr != null && !descr.trim().equals("")){
			descr = descr.trim();
			shop.setDescr(descr);
		}

					
		// get contact type
		String type = request.getParameter("shopContactType");
		if(type != null && !type.trim().equals("")){
			type = type.trim();
		}
				
		// get contact info
		String info = request.getParameter("shopContactInformation");
		if(info != null && !info.trim().equals("")){
			info = info.trim();
		}
		
		ShopContact contact = new ShopContact();
		contact.setType(type);
		contact.setInfo(info);
		
		List<ShopContact> contacts = new ArrayList<>();
		contacts.add(contact);
		shop.setShopContactList((ArrayList<ShopContact>) contacts);
		

		// upload image
		int n= 0;
		
		if((n = service.addMerchantShop(shop))!= 0){
			request.setAttribute("mid", mid);
			request.getRequestDispatcher("/showIndex").forward(request, response);
		}
		else {
			request.setAttribute("mid", mid);
			request.setAttribute("errorMsg", Consts.ADD_SHOP_FAIL);
			request.getRequestDispatcher("merchantAddShop.jsp").forward(request, response);
		}
	}


}
