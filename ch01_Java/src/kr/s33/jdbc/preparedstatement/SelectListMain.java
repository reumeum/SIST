package kr.s33.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.*;

public class SelectListMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 1,2단계 수행
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM test3 ORDER BY num DESC";
			
			//JDBC 3단계 수행 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//JDBC 4단계 수행
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t작성자\t등록일\t\t제목");
			
			while (rs.next()) {
				System.out.print(rs.getInt("num"));
				System.out.print("\t");
				System.out.print(rs.getString("name"));
				System.out.print("\t");
				System.out.print(rs.getDate("reg_date"));
				System.out.print("\t");
				System.out.print(rs.getString("title"));
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}
