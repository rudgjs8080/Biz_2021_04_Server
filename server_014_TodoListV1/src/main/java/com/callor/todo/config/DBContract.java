package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn;
		
		static {
			String jdbcDriver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/mydb";
			String username = "gbuser";
			String password = "12345";
			
			try {
				Class.forName(jdbcDriver);
				if(dbConn == null) {
					dbConn = DriverManager.getConnection(url, username, password); 
				}
				System.out.println("DB 연결 완료");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("DB 연결 실패");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("DB 연결 실패 입력내용 다시 확인해주세요");
			}
			
		}
	public static Connection getDBConnection() {
		return dbConn;
	}
}
