package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class ExceptionFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(req, res);
		} catch (Exception e) {
			System.out.println("Exception Captured by Filter: " + e.getMessage());
			HttpServletResponse response = (HttpServletResponse)res;
			response.sendRedirect("clientIndex.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}



}
