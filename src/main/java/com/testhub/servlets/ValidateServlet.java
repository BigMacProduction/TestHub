package com.testhub.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testhub.classes.AccountMaker;
import com.testhub.classes.AccountsChecker;


public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		String validationExpression = request.getParameter("validationExpression");
		AccountsChecker checker = new AccountsChecker();
		AccountMaker myMaker = new AccountMaker();
		
		PrintWriter out = response.getWriter();
		
		if(checker.checkRawAccountExistance(validationExpression)){
			System.out.println(validationExpression+" bebore creating validated account");
			myMaker.createAccount(validationExpression);
			myMaker.remoweRawAccount(validationExpression);
	
			RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
		}else{
			System.out.println(validationExpression+" wrong validation number");
		}
		
		
		
		
		
	}

}
