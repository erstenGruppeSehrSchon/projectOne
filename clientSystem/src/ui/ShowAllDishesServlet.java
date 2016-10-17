package ui;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.Dish;
import service.ClientViewMerchantDishService;
import service.impl.ClientViewMerchantDishServiceImpl;

public class ShowAllDishesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClientViewMerchantDishService cvmds = new ClientViewMerchantDishServiceImpl();
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Store to request attribute
		ArrayList<Dish> dishList = cvmds.findAllDish();
		request.setAttribute("dishes", dishList);
		for (Dish dish : dishList){
			System.out.print(dish.getName());
			System.out.print(dish.getSid());
			System.out.print(dish.getDid());
		}
		
		// Forward to index page
  	    request.getRequestDispatcher("clientIndex.jsp").forward(request, response);
	}

}
