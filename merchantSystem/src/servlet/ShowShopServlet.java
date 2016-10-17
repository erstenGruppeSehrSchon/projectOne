package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.po.Dish;
import common.po.DishImage;
import common.po.Shop;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

/**
 * Servlet implementation class ShowShopServlet
 */
public class ShowShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid= 0;
		if (request.getParameter("sid") != null){
			sid= Integer.parseInt(request.getParameter("sid"));
		}
		else {
			sid = (Integer) request.getAttribute("sid");
		}
		
		int mid= 0;
		if (request.getParameter("mid") != null){
			mid= Integer.parseInt(request.getParameter("mid"));
		}
		else {
			mid = (Integer) request.getAttribute("mid");
		}
				
		Shop shop = service.retrieveShopBySid(sid);
		
		List<Dish> dishes = service.retrieveDishesBySid(sid);
		for(Dish dish : dishes){
			List<DishImage> dishImage = service.retrieveDishImagesByDid(dish.getDid());
			dish.setDishImages((ArrayList<DishImage>) dishImage);
		}
		
		request.setAttribute("shop", shop);
		request.setAttribute("dishes", dishes);
		request.setAttribute("mid", mid);
		request.getRequestDispatcher("merchantShowShop.jsp").forward(request, response);
	}

}
