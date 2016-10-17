package ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.User;


import service.UserManager;
import service.impl.UserManagerImpl;

public class ShowAllUsersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserManager um = new UserManagerImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> users = (ArrayList<User>)um.getAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("showAllUsers.jsp").forward(request, response);
	}

}
