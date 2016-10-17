package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Dish;
import po.DishImage;
import po.MeMerchant;
import po.Shop;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

/**
 * Servlet implementation class ShowAllInfo
 */
public class ShowIndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for security reason, only post request can be received
		
		// get mid from login servlet / other servlet
		int mid = 0;
		if(request.getAttribute("mid") != null)
			mid = (Integer) request.getAttribute("mid");
		else
			mid = Integer.parseInt(request.getParameter("mid"));
		
		
		MeMerchant merchant = service.retrieveMerchantOnly(mid);
		
		// get shop by mid
		List<Shop> shops = service.retrieveShopOnly(mid);
		merchant.setShopList((ArrayList<Shop>) shops);
		
		// get dish by mid
		List<Dish> dishes = service.retrieveDishesByMid(mid);
				
		// get dish image by did
		for (Dish dish: dishes){
			dish.setDishImages((ArrayList<DishImage>) service.retrieveDishImagesByDid(dish.getDid()));
		}
		
		request.setAttribute("merchant", merchant);
		request.setAttribute("dishes", dishes);
		request.setAttribute("mid", mid);
		request.getRequestDispatcher("merchantIndex.jsp").forward(request, response);
	}

}
