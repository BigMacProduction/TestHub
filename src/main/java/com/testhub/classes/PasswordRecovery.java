package com.testhub.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PasswordRecovery {
	
	public boolean setNewPassword(String password, String email){
		Connection con = null;
		PreparedStatement stmt = null;
		System.out.println("setNewPassword start");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			String sql = "UPDATE `testhub`.`account` SET `password`='" + password
					+ "' WHERE `email`='" + email + "';";
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			System.out.println("setNewPassword finish");

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

		return false;
	}

	public void setRecoveryData(String email, String recoveryExpression) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());
			//INSERT INTO `testhub`.`passwordRecovery` (`email`, `recoveryExpression`) VALUES ('asgfsdagdfg', 'fdgfdgdf');
			String sql = "INSERT INTO `testhub`.`passwordRecovery` (`email`, `recoveryExpression`) VALUES ('"+ email + "', '" + recoveryExpression + "');";
			stmt = con.prepareStatement(sql);
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

	public void remoweRecoveryData(String email) {
		Connection con = null;
		Statement stmt = null;
		System.out.println("remoweRecoveryData start");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `testhub`.`passwordRecovery` WHERE `email`=\'"
					+ email + "\';");
			System.out.println("remoweRecoveryData finish with" + email);


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public String checkRecoveryExp(String valExp){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT * FROM `testhub`.`passwordRecovery`;");
			while (rs.next()) {
				if (valExp.equals(rs.getString("recoveryExpression"))) {
					return rs.getString("email");
				}
			}
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
				System.err.println("Error:" + ex.getMessage());
			}
		}

		return null;
		
		
	}
	

	public boolean checkEmailPresence(String email) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Container.getSqlUrl(), Container.getSqlUser(),
					Container.getSqlPassword());

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT email FROM `testhub`.`account`;");
			while (rs.next()) {
				if (email.equals(rs.getString("email"))) {
					return true;
				}
			}
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
				System.err.println("Error:" + ex.getMessage());
			}
		}

		return false;
	}

}
