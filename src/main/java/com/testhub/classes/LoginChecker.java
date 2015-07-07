package com.testhub.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginChecker {

	public boolean checkLogin(String login, String password) {

		String log = login;
		String psw = password;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT login  FROM account;");

			while (rs.next()) {

				if (log.equals(rs.getString("login"))) {

					rs.close();
					rs = stmt.executeQuery("SELECT password FROM testhub.account where login=\'" + log + "\';");
					rs.next();

					if (psw.equals(rs.getString("password"))) {

						return true;

					} 
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (rs != null) {

				}
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
		return false;
		

	}
}
