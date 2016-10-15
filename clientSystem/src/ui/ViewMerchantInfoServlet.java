package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;













import po.Merchant;
import service.ClientManager;
import service.ClientViewMerchantInfoService;
import service.MerchantManager;
import service.impl.ClientManagerImpl;
import service.impl.ClientViewMerchantInfoServiceImpl;
import service.impl.MerchantManagerImpl;
import constant.Constant;

/**
 * Servlet implementation class ViewMerchantInfoServlet
 */
public class ViewMerchantInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MerchantManager MM = new MerchantManagerImpl();
    private Merchant M = null;
    private int MID = -1;
    /**
     * Default constructor. 
     */
    public ViewMerchantInfoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          try {
  			
        	   MID = Integer.parseInt(request.getParameter(Constant.MERCHANT_PARAMETER_MID));
      		
      		}catch(NumberFormatException nfe){
      		     
      		     MID = -1;
      		}
          
          if (MID>0){
        	  
        	  M = MM.findMeMerchantById(MID);
        	  
        	  if(M.getName()!=null){
        		  request.setAttribute("Merchant", M);
        		  request.getRequestDispatcher("showMerchantDetails.jsp").forward(request, response);         	 
        		  }else{
            		  request.getRequestDispatcher("Error.jsp").forward(request, response);         	 

        		  }
        	  
        	  
          
          
          
          
          }else{
        	  System.out.println("ID not FOUND");
          }
          
          
          

		
	}

	

}
