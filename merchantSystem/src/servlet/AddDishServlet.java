package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("shopId"));
		String dishName = request.getParameter("dishName");
		String dishType = request.getParameter("dishType");
		double dishPrice = Double.parseDouble(request.getParameter("dishPrice"));
		
		// Add dish record to database
		Dish dish = new Dish();
		dish.setName(dishName);
		dish.setType(dishType);
		dish.setPrice(dishPrice);
		dish.setActive(1);
		mds.adddish(dish);
		
		// Upload image
		FileUploader fileUploader = FileUploader.getFileUploader();
		ArrayList<String> imgUrls = fileUploader.upload(getServletContext(), request, "dish", sid);
		
		// Add dish image record to database
		for (String imgUrl : imgUrls) {
			dis.addDishImage(sid, imgUrl);
		}
	}

}
