package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	// 연결 준비
	// 디비 연결 == conn 얻기
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String username = "C##KH_JDBC";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, username, pwd);
		conn.setAutoCommit(false);
		
		return conn;
	}

}
