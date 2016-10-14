package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Merchant;
import object.merchant.MeMerchant;

/**
 * Servlet implementation class ViewMerchantInfoServlet
 */
public class ViewMerchantInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MeMerchant merchant = new MeMerchant();
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
          int id = Integer.parseInt(request.getParameter("MerchantId"));
          MarchantManager.
          
          

		
	}

	

}
