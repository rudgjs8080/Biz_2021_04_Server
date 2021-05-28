package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 싱글톤 패턴
 * 자원(Resource: 하드웨워 장치, 네트워크, 파일..) 을
 * 코드에서 활용할 때는 최소한의 연결을 하여 사용하는 것이
 * 여러모로 좋다
 * 
 * 필요한 연결객체를 프로젝트에서 1개만 선언하고
 * 공용으로 사용하는 방법
 */
public class DBContract {
	private static Connection dbConn;
	private static final Logger log = LoggerFactory.getLogger("DB");
	// static 초기화 블록
	// static으로 선언된 변수나 객체를 프로젝트가 시작될 때
	// 자동으로 생성하는 코드를 작성하는 부분
	// Connection 객체인 dbConn을 사용할 준비를 하기
	// DB Server와 연동을 시작하여 연결 session을 생성해둔다
	// 필요할 때 get() method를 통하여 제공해준다
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/mydb";
		String username = "gbuser";
		String password = "12345";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			log.debug("MySQL 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL 연결실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL 연결 실패2");
		}
	}

	// get Instance method
	// Instance : 사용준비(생성된, 초기화된) 객체
	// private static 으로 선언된 변수, 객체를
	// 다른 곳에서 사용할 수 있도록 제공하는 method
	public static Connection getDBConnection() {
		return dbConn;
	}

}
