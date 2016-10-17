package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import common.po.Dish;
import service.DishImageService;
import service.MerchantDishService;
import service.impl.DishImageServiceImpl;
import service.impl.MerchantDishServiceImpl;
import util.FileUploader;

public class AddDishServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MerchantDishService mds = new MerchantDishServiceImpl();
	private DishImageService dis = new DishImageServiceImpl();
	private List<FileItem> imageFileItems = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sid = saveDishRecord(request);
		uploadImage(request, sid);

		//request.getRequestDispatcher("AddDishPage?").forward(request, response);
	}
	
	// Save dish to database, return shop id
	private int saveDishRecord(HttpServletRequest request)  {
		int sid = -1;
		
		String dishName = null;
		String dishType = null;
		double dishPrice = -1;
		
		try {
			ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString();
					switch (name) {
						case "shopId":
							sid = Integer.parseInt(value);
						case "dishName":
							dishName = value;
							break;
						case "dishType":
							dishType = value;
							break;
						case "dishPrice":
							dishPrice = Double.parseDouble(value);
							break;
					}
					
				} else {
					imageFileItems.add(fileItem);
				}
				
			}
			
			// Add dish record to database
			Dish dish = new Dish();
			dish.setSid(sid);
			dish.setName(dishName);
			dish.setType(dishType);
			dish.setPrice(dishPrice);
			dish.setActive(1);
			mds.adddish(dish);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sid;
	}

	public void uploadImage(HttpServletRequest request, int sid) {
		// Upload image
		FileUploader fileUploader = FileUploader.getFileUploader();
		ArrayList<String> imgUrls = fileUploader.upload(getServletContext(), request, "dish", sid, imageFileItems);
		
		// Add dish image record to database
		for (String imgUrl : imgUrls) {
			dis.addDishImage(sid, imgUrl);
		}
	}
}
