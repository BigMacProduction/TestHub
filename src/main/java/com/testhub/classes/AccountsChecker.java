package com.testhub.classes;

import java.sql.*;

public class AccountsChecker {

	/**
	 * 
	 * @param field
	 *            name of the field, that will be checked for its uniqueness
	 *            EMAIL or LOGIN
	 * @param value
	 *            the value of that field
	 * @return
	 */
	public boolean checkForUniqueness(String field, String value) {

		String valueOfField = null;
		String SQLfield = null;

		if (field.equals("EMAIL")) {
			valueOfField = value;
			SQLfield = "email";
		} else if (field.equals("LOGIN")) {
			valueOfField = value;
			SQLfield = "login";
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT " + SQLfield + " FROM `" + Container.getSqlSchema() + "`.`account`;");

			while (rs.next()) {
				if (!(valueOfField.equals(rs.getString(SQLfield)))) {
				} else {
					System.out.println("User already exist");
					stmt.close();
					con.close();
					return false;
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

		return true;

	}

	public boolean checkRawAccountExistance(String validationExpression){
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT * FROM `" + Container.getSqlSchema() + "`.`raw_account`;");

			while (rs.next()) {
				if ((validationExpression.equals(rs.getString("validationExpression")))) {
					System.out.println("correcr validatin code");
					stmt.close();
					con.close();
					return true;
				} else {
					
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

