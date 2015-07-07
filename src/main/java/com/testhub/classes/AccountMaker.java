package com.testhub.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountMaker {

	public void createAccount(String validationExpression) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `testhub`.`raw_account` where validationExpression = \'"
					+ validationExpression + "\';");
			rs.next();

			String login = rs.getString("login");
			String password = rs.getString("password");
			String email = rs.getString("email");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");

			this.createAccount(login, email, firstName, lastName, password);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}

	}

	private void createAccount(String login, String email, String firstName, String lastName, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `testhub`.`account` "
					+ "(`firstName`, `lastName`, `login`, `email`, `password`) " + "VALUES (?,?,?,?,?);");

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, login);
			stmt.setString(4, email);
			stmt.setString(5, password);

			stmt.executeUpdate();

			// Lets get The ID of just created account
			rs = stmt.executeQuery("SELECT accountId FROM `testhub`.`account` where login = \'" + login + "\';");
			rs.next();
			int accountId = rs.getInt("accountId");

			System.out.println("New account ID: " + accountId);

			// And just set for those ID role "1", which means 'student'
			stmt.execute("INSERT INTO `testhub`.`account_role` (`accountId`, `roleId`) VALUES ('" + accountId + "', '"
					+ 1 + "');");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}

	}

	public void createRawAccount(String login, String email, String firstName, String lastName, String password,
			String validationExpression) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `testhub`.`raw_account` "
					+ "(`firstName`, `lastName`, `login`, `email`, `password`,`validationExpression`) "
					+ "VALUES (?,?,?,?,?,?);");

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, login);
			stmt.setString(4, email);
			stmt.setString(5, password);
			stmt.setString(6, validationExpression);

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}

	}

	public void remoweRawAccount(String validationExpression) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `testhub`.`raw_account` WHERE `validationExpression`=\'"
					+ validationExpression + "\';");

		
	}catch (SQLException e){
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		
	}

}
