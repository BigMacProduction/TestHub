package com.testhub.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testhub.classes.AccountMaker;
import com.testhub.classes.AccountsChecker;
import com.testhub.classes.SendMailSSL;
import com.testhub.classes.ValidationExpressionGenerator;

/**
 * Servlet implementation class SingInServlet
 */
public class SingInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String login = request.getParameter("login");
		String password = request.getParameter("password1");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		AccountsChecker checker = new AccountsChecker();
		
		
		

		
		
		if (checker.checkForUniqueness("LOGIN", login) && checker.checkForUniqueness("EMAIL", email)) {
			
			String validationExpression = new ValidationExpressionGenerator().generateValExpression();
			
			AccountMaker accMaker = new AccountMaker();
			accMaker.createRawAccount(login, email, firstName, lastName, password,validationExpression);
			
			SendMailSSL makeMail = new SendMailSSL();
			makeMail.sendValidationLink(email, validationExpression);
			//redirection to JSP page
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/instructions");
			request.setAttribute("title", "Validation instruction");
			request.setAttribute("message", "To validate your account follow to your  mail-box");
			reqDispatcher.forward(request,response);
			
		} else {
		};

	}

}
