package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.po.MeMerchant;
import common.po.Shop;
import common.po.ShopContact;
import consts.Consts;
import service.MerchantShopService;
import service.impl.MerchantShopServiceImpl;
import util.FileUploader;

/**
 * Servlet implementation class NewShopServlet
 */
public class AddShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MerchantShopService service = new MerchantShopServiceImpl();
	
	private List<FileItem> imageFileItems = new ArrayList<>();
	

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
		String name = null;
		String descr = null;
		String type = null;
		String info = null;
		
		// save shop record
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems;
		try {
			fileItems = upload.parseRequest(request);

			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					imageFileItems.add(fileItem);
				}
				else{
					String fieldName = fileItem.getFieldName();
					String fieldValue = fileItem.getString();
					switch (fieldName) {
						case "mid":
							mid = Integer.parseInt(fieldValue);
							break;
						case "shopRegName":
							name = fieldValue;
							break;
						case "shopRegDescription":
							descr = fieldValue;
							break;
						case "shopContactType":
							type = fieldValue;
							break;
						case "shopContactInformation":
							info = fieldValue;
							break;
					}
				}
			}
			
					
			shop.setMid(mid);
			
			// set username
			if(name != null && !name.trim().equals("")){
				name = name.trim();
				shop.setName(name);
			}
			
			// set description
			if(descr != null && !descr.trim().equals("")){
				descr = descr.trim();
				shop.setDescr(descr);
			}
	
						
			// set contact type
			if(type != null && !type.trim().equals("")){
				type = type.trim();
			}
					
			// set contact info
			if(info != null && !info.trim().equals("")){
				info = info.trim();
			}
			ShopContact contact = new ShopContact();
			contact.setType(type);
			contact.setInfo(info);
			
			List<ShopContact> contacts = new ArrayList<>();
			contacts.add(contact);
			shop.setShopContactList((ArrayList<ShopContact>) contacts);
			
		
			// add to db
			int sid= 0;
			
			if((sid = service.addMerchantShop(shop))!= 0){
				uploadImage(request, sid, mid);
				request.setAttribute("mid", mid);
				request.getRequestDispatcher("showIndex").forward(request, response);
				
			}
			else {
				request.setAttribute("mid", mid);
				request.setAttribute("errorMsg", Consts.ADD_SHOP_FAIL);
				request.getRequestDispatcher("merchantAddShop.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Upload image
	public void uploadImage(HttpServletRequest request, int sid, int mid) {

		FileUploader fileUploader = FileUploader.getFileUploader();
		List<String> imgUrls = fileUploader.upload(getServletContext(), request, "shop", sid, imageFileItems);
		
		for (String imgUrl : imgUrls) {
			service.updateShopImage(imgUrl, sid, mid);
		}
	}


}
