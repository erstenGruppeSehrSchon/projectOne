package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.User;

import service.UserManager;
import service.impl.UserManagerImpl;

public class ShowUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserManager um = new UserManagerImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = um.getUser(id);
		request.setAttribute("user", user);
		
		ObjectMapper mapper=new ObjectMapper();
		response.setHeader("Content-Type", "application/json");
		mapper.writeValue(response.getOutputStream(), user);
	}



}
