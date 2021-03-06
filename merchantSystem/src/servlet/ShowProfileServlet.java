package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import consts.Consts;
import common.po.Dish;
import common.po.MeMerchant;
import service.MerchantProfileService;
import service.impl.MerchantProfileServiceImpl;

public class ShowProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileService service = new MerchantProfileServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for security reason, only post request can be received
		
		// get mid from login servlet
		int mid= 0;
		if(request.getParameter("mid") != null){
			mid = Integer.parseInt(request.getParameter("mid"));
		}
		else{
			mid = (Integer) request.getAttribute("mid");
		}
		
		MeMerchant merchant = service.retrieveMerchantOnly(mid);
		
		request.setAttribute("mid", mid);
		request.setAttribute("merchant", merchant);
		request.getRequestDispatcher("merchantViewProfile.jsp").forward(request, response);
	}

}
