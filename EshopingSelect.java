package com.example.web;

import com.example.model.EshopingExpert;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;
import com.example.model.User;

public class EshopingSelect extends HttpServlet {
	
	private static final String sort = null;
	private UserDao userDao;
	public void init() {
		userDao = new UserDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response, action);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.getAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.html");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.html");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response, String sort) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		request.getParameter("sort");
		User newUser = new User(name, sort);
		userDao.saveUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		request.getParameter("sort");

		User user = new User(id, name, sort);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}

	
	private static final long serialVersionUID = 1L;
	
	public EshopingSelect(){
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		String c = request.getParameter("sort");
		EshopingExpert be = new EshopingExpert();
		List<String> result = be.getBrands(c);

		request.setAttribute("styles", result);
	
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			
			view.forward(request, response);
	}
}