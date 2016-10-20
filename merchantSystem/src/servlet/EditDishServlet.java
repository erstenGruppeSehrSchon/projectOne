package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.po.Dish;

import service.MerchantDishService;
import service.impl.MerchantDishServiceImpl;

public class EditDishServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MerchantDishService service = new MerchantDishServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get user input
		int did = Integer.parseInt(request.getParameter("dishId"));
		int sid = Integer.parseInt(request.getParameter("shopId"));
		String type = request.getParameter("dishType");
		String name = request.getParameter("dishName");
		double price = Double.parseDouble(request.getParameter("dishPrice"));
		int active = Integer.parseInt(request.getParameter("isActive"));
		
		// Update dish record
		Dish dish = new Dish();
		dish.setDid(did);
		dish.setType(type);
		dish.setName(name);
		dish.setPrice(price);
		dish.setActive(active);
		dish.setSid(sid);
		service.updatedish(dish);
		
		// Forward
		request.setAttribute("dish", dish);
		request.getRequestDispatcher("EditDish").forward(request, response);
	}

}
