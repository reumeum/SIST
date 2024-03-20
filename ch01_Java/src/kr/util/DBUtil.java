package kr.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_ID = "user01";
	private static final String DB_PASSWORD = "1234";
	
	//Connection 객체를 생성해서 반환
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//JDBC 수행 1단계: 드라이버 로드
		Class.forName(DB_DRIVER);
		//JDBC 수행 2단계: Connection 객체 생성
		Connection conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PASSWORD);
		
		return conn;
	}
	
	//자원정리
	//PreparedStatement용
	public static void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		//rs가 없을 시 null을 넘겨주면 됨
		if (rs!=null) try {rs.close();} catch (SQLException e) {}
		if (pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
		if (conn!=null) try {conn.close();} catch (SQLException e) {}
	}
	
	//CallableStatement용 메서드 오버로딩
	public static void executeClose(ResultSet rs, CallableStatement cstmt, Connection conn) {
		if (rs!=null) try {rs.close();} catch (SQLException e) {}
		if (cstmt!=null) try {cstmt.close();} catch (SQLException e) {}
		if (conn!=null) try {conn.close();} catch (SQLException e) {}
	}
}
