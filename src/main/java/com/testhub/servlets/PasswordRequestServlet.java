package com.testhub.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testhub.classes.PasswordRecovery;
import com.testhub.classes.SendMailSSL;
import com.testhub.classes.ValidationExpressionGenerator;

public class PasswordRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String URL = null;
		String email = (String) request.getParameter("email");
		PasswordRecovery passRec = new PasswordRecovery();

		if (passRec.checkEmailPresence(email)) {
			String recoveryExpression = new ValidationExpressionGenerator().generateValExpression();
			request.setAttribute("Expression", recoveryExpression);
			System.out.println("Hello_recovery");
			passRec.setRecoveryData(email, recoveryExpression);
			SendMailSSL mail = new SendMailSSL();
			mail.sendRecoveryLink(email, recoveryExpression);
			URL = "/instructions";
			request.setAttribute("title", "Recovery instructions");
			request.setAttribute("message", "For futher password recovery follow to your mail-box");
		} else {
			URL = "/instructions";
			request.setAttribute("title", "ERROR");
			request.setAttribute("message", "No such email in our DataBase, konokrad");
		}

		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);

	}

}
