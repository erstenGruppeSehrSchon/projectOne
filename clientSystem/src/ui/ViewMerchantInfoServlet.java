package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import service.ClientManager;
import service.ClientViewMerchantInfoService;
import service.impl.ClientManagerImpl;
import service.impl.ClientViewMerchantInfoServiceImpl;
import constant.Constant;

/**
 * Servlet implementation class ViewMerchantInfoServlet
 */
public class ViewMerchantInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClientViewMerchantInfoService CVM = new ClientViewMerchantInfoServiceImpl();
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
          int id = Integer.parseInt(request.getParameter(Constant.MERCHANT_PARAMETER_MID));        
          if(CM.isMerchanAccept(id)){
        	  request.setAttribute(Constant.MERCHANT_PARAMETER_MID, id);
        	  request.setAttribute(Constant.MERCHANT_PARAMETER_MID, id);
        	  

        	  
        	  
        	  
        	  
        	  
        	  request.getRequestDispatcher("showMerchantDetails.html").forward(request, response);   //accpeted and view info jsp 
          }else if(!(CM.isMerchanAccept(id))){
        	  request.getRequestDispatcher("xxxxxxx.jsp").forward(request, response);  //rejected jsp
          }
          
          
          
          
          
          

		
	}

	

}
