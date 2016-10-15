package servlet;

import javax.servlet.http.HttpServlet;
import util.ListenJMSUtil;

public class JMSListenerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public JMSListenerServlet() {
        try {
        	System.out.println("JMSListener Start");
			ListenJMSUtil.startListenRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
