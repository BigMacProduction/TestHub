package com.testhub.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testhub.classes.AccountMaker;
import com.testhub.classes.LoginChecker;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String URL;
		LoginChecker logChecker = new LoginChecker();

		if (logChecker.checkLogin(userName, password)) {
			URL = "/info";
		} else {
			URL = "/error";
		}

		RequestDispatcher logDispacher = getServletConfig().getServletContext().getRequestDispatcher(URL);
		logDispacher.forward(request, response);

	}

}
