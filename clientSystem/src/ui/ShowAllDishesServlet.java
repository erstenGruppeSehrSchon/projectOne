package ui;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import object.Dish;
import service.ClientViewMerchantDishService;
import service.impl.ClientViewMerchantDishServiceImpl;

public class ShowAllDishesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClientViewMerchantDishService cvmds = new ClientViewMerchantDishServiceImpl();
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Store to request attribute
		List<Dish> dishList = cvmds.findAllDish();
		request.setAttribute("dishes", dishList);
		
		// Forward to index page
  	    request.getRequestDispatcher("clientIndex.jsp").forward(request, response);
	}

}
