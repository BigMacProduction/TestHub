package com.testhub.classes;

public class ValidationExpressionGenerator {

	public String generateValExpression() {
		char[] expression = new char[40];
		for (int i = 0; i < expression.length; i++) {
			expression[i] = (char) (48 + Math.random() * 10);
		}
		String result = new String(expression);
		return result;
	}

}