package com.callor.food.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	private static Connection dbConn = null;

	// static 으로 선언된 dbConn 객체를 초기화 하는 코드
	static {
		// Referenced odbc6...
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		// url 어디서 따와야하는지?
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "food";
		String password = "food";

		// 필수적인 코드인지 확인?
		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("오라클 접속 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 Driver를 찾을수 없음");
			System.out.println("오라클 Ojdbc6.jar를 확인하세요");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("=".repeat(30));
			System.out.println("오라클 DBMS 연결 실패");
			System.out.println("접속 정보를 확인하세요");
			System.out.println("URL : " + url);
			System.out.println("USER : " + username);
			System.out.println("PW : " + password);
			System.out.println("=".repeat(30));
		}
	}// end static

	// 싱클턴 패턴
	// 필수적인 코드인지?
	public static Connection getDBConnection() {
		return dbConn;
	}

}
