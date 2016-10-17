package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.UserManager;
import service.impl.UserManagerImpl;

public class DeleteUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserManager um = new UserManagerImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		um.deleteUser(id);

		ObjectMapper mapper=new ObjectMapper();
		response.setHeader("Content-Type", "application/json");
		mapper.writeValue(response.getOutputStream(), true);

	}

}
