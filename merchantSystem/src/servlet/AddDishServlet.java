package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.po.Dish;
import service.MerchantDishService;
import service.impl.MerchantDishServiceImpl;
import util.FileUploader;

public class AddDishServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MerchantDishService mds = new MerchantDishServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("shopId"));
		String dishName = request.getParameter("dishName");
		String dishType = request.getParameter("dishType");
		double dishPrice = Double.parseDouble(request.getParameter("dishPrice"));
		
		Dish dish = new Dish();
		dish.setName(dishName);
		dish.setType(dishType);
		dish.setPrice(dishPrice);
		dish.setActive(1);
		mds.adddish(dish);
		
		FileUploader fileUploader = FileUploader.getFileUploader();
		fileUploader.upload(getServletContext(), request, "dish", sid);
		
	}

}
