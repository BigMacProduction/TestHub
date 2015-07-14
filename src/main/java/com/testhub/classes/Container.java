package com.testhub.classes;

public class Container {
	private static final String JBDC_DRIVER="com.mysql.jdbc.Driver";
		
	//Uncoment next three lines for global redhat tomcat hosting
	
//	private static final String SQL_URL="jdbc:mysql://localhost:3307/testhub";
//	private static final String SQL_USER="adminJlw4NSy";
//	private static final String SQL_PASSWORD="DiR5ErrIRGqf";
//	private static final String LINK_HEAD_VALIDATION = "http://goodweb-testhubls.rhcloud.com/GoodWeb/ValidateServlet?validationExpression=";
//	private static final String LINK_HEAD_RECOVERY = "http://goodweb-testhubls.rhcloud.com/GoodWeb/PasswordRecoveryServlet?recoveryExpression=";
	
	
	
	
	//Uncoment next lines for local tomcat hosting
		
	private static final String SQL_URL="jdbc:mysql://localhost:3306/testhub";
	private static final String SQL_USER="root";
	private static final String SQL_PASSWORD="root";
	private static final String LINK_HEAD_VALIDATION = "http://localhost:8083/GoodWeb/ValidateServlet?validationExpression=";
	private static final String LINK_HEAD_RECOVERY = "http://localhost:8083/GoodWeb/PasswordRecoveryServlet?recoveryExpression=";
	
	
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
	public static String getLinkheadvalidation() {
		return LINK_HEAD_VALIDATION;
	}
	public static String getLinkHeadrecovery() {
		return LINK_HEAD_RECOVERY;
	}
	

}

