package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.Dish;
import service.ClientViewMerchantDishService;
import service.impl.ClientViewMerchantDishServiceImpl;

public class ShowDishServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClientViewMerchantDishService cvmds = new ClientViewMerchantDishServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Store to request attribute
		int did = Integer.parseInt(request.getParameter("dishId"));
		Dish dish = cvmds.loadDish(did);
		request.setAttribute("dish", dish);
		
		// Forward to dish page
  	    request.getRequestDispatcher("showDish.jsp").forward(request, response);
	}

}
