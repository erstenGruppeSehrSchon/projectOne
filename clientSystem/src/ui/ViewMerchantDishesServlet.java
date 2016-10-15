package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClientManager;
import service.ClientViewMerchantDishService;
import constant.Constant;
import service.impl.ClientManagerImpl;
import service.impl.ClientViewMerchantDishServiceImpl;

/**
 * Servlet implementation class ViewMerchantDishesServlet
 */
public class ViewMerchantDishesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int DID = -1;
	private int MID = -1;
	
	private ClientManager CM = new ClientManagerImpl();
	private ClientViewMerchantDishService CVD = new ClientViewMerchantDishServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMerchantDishesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setAttribute(Constant.MERCHANT_DISH_NAME, CVD.loadDish(DID).getName());
		//request.setAttribute(Constant.MERCHANT_DISH_PRICE, CVD.loadDish(DID).getPrice());
		//request.setAttribute(Constant.MERCHANT_DISH_TYPE, CVD.loadDish(DID).getType());
		//request.setAttribute(Constant.MERCHANT_DISH_ISACTIVE, CVD.loadDish(DID).getActive());
		//request.setAttribute(Constant.MERCHANT_DISH_SID, CVD.loadDish(DID).getMid());
		
		/*try {
	    DID = Integer.parseInt(request.getParameter(Constant.MERCHANT_DISH_DID));
		MID = Integer.parseInt(request.getParameter(Constant.MERCHANT_PARAMETER_MID));
		}catch(NumberFormatException nfe){
		     DID = -1;
		     MID = -1;
		}
		
		if((DID>=0)&&(MID>=0)){
			request.setAttribute(Constant.MERCHANT_PARAMETER_MID, MID);
			request.setAttribute(Constant.MERCHANT_DISH_DID, DID);
			request.setAttribute("Dish", CVD.loadDish(MID));
			
		
			
			
			
      	    request.getRequestDispatcher("showDishes.jsp").forward(request, response);   //accpeted and view DISH info jsp 

		}else{
      	      request.getRequestDispatcher("xxxxxx.jsp").forward(request, response);   //accpeted and view DISH info jsp 
		}
		
		*/
		
		
		MID = 1;
		request.setAttribute(Constant.MERCHANT_PARAMETER_MID, MID);
		request.setAttribute(Constant.MERCHANT_DISH_DID, DID);
		request.setAttribute("Dish", CVD.loadDish(MID));
		

		
		
		
  	    request.getRequestDispatcher("showDishes.jsp").forward(request, response);   //accpeted and view DISH info jsp 
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
