package kr.s32.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import kr.util.DBUtil;

public class InsertMain {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2 단계
			conn = DBUtil.getConnection();
			
			//SQL문 만들기
			sql = "INSERT INTO test2(id,name,age,reg_date) VALUES(?,?,?,SYSDATE)";
			
			//JDBC 수행 3단계: PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터를 바인딩
			pstmt.setString(1, "mubien"); //1번 ?에 데이터 전달
			pstmt.setString(2, "김후안"); //2번 ?에 데이터 전달
			pstmt.setInt(3, 20); //3번 ?에 데이터 전달
			
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate(); //prepareStatement()에 sql을 전달했기 때문에 여기에서는 전달하지 않음
			
			System.out.println(count + "개 행을 추가했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
