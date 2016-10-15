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

public class LoadMerchantDishServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ClientViewMerchantDishService cvmds = new ClientViewMerchantDishServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		
		System.out.print("get in doget");

		List<Dish> dishList = CVMDS.findAllDish();
		
		System.out.print(dishList);
=======
>>>>>>> Client_clientIndex
		// Store to request attribute
		List<Dish> dishList = cvmds.findAllDish();
		
		
		request.setAttribute("dishs", dishList);
		
  	    request.getRequestDispatcher("clientIndex.jsp").forward(request, response);   //accpeted and view DISH info jsp 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
