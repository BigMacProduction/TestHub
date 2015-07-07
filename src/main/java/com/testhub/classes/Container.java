package com.testhub.classes;

public class Container {
	private static final String JBDC_DRIVER="com.mysql.jdbc.Driver";
	private static final String SQL_URL="jdbc:mysql://localhost:3306/testhub";
	private static final String SQL_USER="root";
	private static final String SQL_PASSWORD="root";
	private static final String SQL_SCHEMA="testhub";
	private static final String appOwnMailAddress="testHubMail@gmail.com";
	private static final String appOwnMailPassword="4jugf45G2ggeyRRdkuw";
	
	
	public static String getAppownmailaddress() {
		return appOwnMailAddress;
	}
	public static String getAppownmailpassword() {
		return appOwnMailPassword;
	}
	
	public static String getSqlSchema() {
		return SQL_SCHEMA;
	}
	public static String getJbdcDriver() {
		return JBDC_DRIVER;
	}
	public static String getSqlUrl() {
		return SQL_URL;
	}
	public static String getSqlUser() {
		return SQL_USER;
	}
	public static String getSqlPassword() {
		return SQL_PASSWORD;
	}

}

