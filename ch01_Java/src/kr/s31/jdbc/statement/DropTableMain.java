package kr.s31.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "user01";
		String db_password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			Class.forName(db_driver);
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			
			System.out.println("test1 테이블을 삭제합니다.");
			
			sql = "DROP TABLE test1";
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("test1 테이블의 삭제가 완료되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
