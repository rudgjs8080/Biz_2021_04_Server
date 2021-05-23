package com.callor.student.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static Connection dbConn;
	
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/root";
		String username = "student";
		String password = "12341234";
		
		if(dbConn == null) {
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url, username, password);
				System.out.println("MySQL 접속 성공");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("MySQL 접속 실패");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("jdbcDriver : " + jdbcDriver);
				System.out.println("url : " + url);
				System.out.println("username : " + username);
				System.out.println("password : " + password);
				System.out.println("정보를 제대로 입력했는지 확인해주세요");
			} 
		}
		
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
