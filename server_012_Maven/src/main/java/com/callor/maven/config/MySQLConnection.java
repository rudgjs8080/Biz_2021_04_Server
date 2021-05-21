package com.callor.maven.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	private static Connection dbConn;
	
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "";
		String username = "";
		String password = "";
		
		if(dbConn == null) {
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url,username,password);
				System.out.println("Oracle 접속 완료");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("ojdbc6.jar를 확인해보세요");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("=".repeat(30));
				System.out.println("Driver : " + jdbcDriver);
				System.out.println("url : " + url);
				System.out.println("username : " + username);
				System.out.println("password : " + password);
				System.out.println("=".repeat(30));
				System.out.println("위의 입력정보를 확인해주세요");
			}
		}
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
