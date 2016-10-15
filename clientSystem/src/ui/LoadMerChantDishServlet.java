package ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Dish;
import service.ClientManager;
import service.ClientViewMerchantDishService;
import service.impl.ClientManagerImpl;
import service.impl.ClientViewMerchantDishServiceImpl;

/**
 * Servlet implementation class LoadMerChantDishServlet
 */
public class LoadMerChantDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientManager CM = new ClientManagerImpl();
	private ClientViewMerchantDishService CVMDS = new ClientViewMerchantDishServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadMerChantDishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Dish> DishList = CVMDS.findAllDish();
	
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
