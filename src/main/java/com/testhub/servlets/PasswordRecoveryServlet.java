package com.testhub.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testhub.classes.PasswordRecovery;

/**
 * Servlet implementation class PasswordRecoveryServlet
 * Author Sopolev Vlad
 */
public class PasswordRecoveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordRecovery passRec = new PasswordRecovery();
		HttpSession session = request.getSession();
		
		String URL = null;
		String recexp = request.getParameter("recoveryExpression");
		String email = passRec.checkRecoveryExp(recexp);
					
		if (email == null){
			URL = "/info";
		} else {
			URL = "/passwordRestore";
			session.setAttribute("email", email);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String password = request.getParameter("password");
		PasswordRecovery passRec = new PasswordRecovery();
		System.out.println("DO POST" + email);
		
		passRec.setNewPassword(password, email);
		passRec.remoweRecoveryData(email);
		
		
		
	}

}
