package com.callor.diet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	private static Connection dbConn; // static 으로 바뀌는 이유는 ?

	static {
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:mysql://127.0.0.1:3306/mydb";
		String username = "myfood";
		String password = "myfood";

		// 이 프로젝트에서 어딘가에서 이미 dbConn이
		// 만들어져 있다면 다시 만들지 않기 위한 코드
		if (dbConn == null) {

			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url, username, password);
				System.out.println("오라클 접속 OK");
			} catch (ClassNotFoundException e) {
				System.out.println("ojdb6.jar를 확인하세요");
			} catch (SQLException e) {
				System.out.println("=".repeat(30));
				System.out.println("Driver : " + jdbcDriver);
				System.out.println("URL : " + url);
				System.out.println("UserName : " + username);
				System.out.println("PassWord : " + password);
				System.out.println("-".repeat(30));
				System.out.println("오라클 DBMS 접속 오류");
				System.out.println("접속정보를 확인하세요");
			}

		}
	}

	public static Connection getDBConnection() {
		
		return dbConn;
	}
}
