package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClientManager;
import service.ClientViewMerchantDishService;
import service.ClientViewMerchantInfoService;
import service.MerchantManager;
import service.ShopManager;
import constant.Constant;
import service.impl.ClientManagerImpl;
import service.impl.ClientViewMerchantDishServiceImpl;
import service.impl.ClientViewMerchantInfoServiceImpl;
import service.impl.MerchantManagerImpl;
import service.impl.ShopManagerImpl;

public class ViewMerchantDishesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int DID = -1;
	private int MID = -1;
	
	private ClientManager CM = new ClientManagerImpl();
	private ClientViewMerchantDishService CVD = new ClientViewMerchantDishServiceImpl();
	private ClientViewMerchantInfoService CVM = new ClientViewMerchantInfoServiceImpl();
	private MerchantManager MM = new MerchantManagerImpl();
	private ShopManager SM = new ShopManagerImpl();
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
		
		
		
		try {
			
	    DID = Integer.parseInt(request.getParameter(Constant.MERCHANT_DISH_DID));
		MID = Integer.parseInt(request.getParameter(Constant.MERCHANT_PARAMETER_MID));
		
		}catch(NumberFormatException nfe){
		     DID = -1;
		     MID = -1;
		}
		
		if((DID>=0)&&(MID>=0)){
			
			request.setAttribute(Constant.MERCHANT_PARAMETER_MID, MID);
			request.setAttribute(Constant.MERCHANT_DISH_DID, DID);
			
			//request.setAttribute("DishImage",CVD.loadDishImage(DID));
			request.setAttribute("Dish", CVD.loadDish(DID));
			request.setAttribute("Merchant", MM.findMeMerchantById(MID));
			request.setAttribute("Shop", SM.findShopById(MID));
			
		
			
				
      	    request.getRequestDispatcher("showDishes.jsp").forward(request, response);   //accpeted and view DISH info jsp 

		}else{
			
			System.out.print("no ID found");
   		}
		
		
		
		
		

		
		
		
  	    request.getRequestDispatcher("showDishes.jsp").forward(request, response);   //accpeted and view DISH info jsp 
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
