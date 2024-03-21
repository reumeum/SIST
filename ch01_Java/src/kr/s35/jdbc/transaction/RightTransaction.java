package kr.s35.jdbc.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.util.DBUtil;

public class RightTransaction {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;

		try {
			//복수의 SQL문을 실행할 경우 오토커밋을 해제하고 수작업으로 트랜잭션 처리함
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//오토커밋 해제
			conn.setAutoCommit(false);

			sql = "INSERT INTO test1 VALUES ('ANNA', 10)";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.executeUpdate();

			sql = "INSERT INTO test1 VALUES ('MARY', 20)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.executeUpdate();

			//테스트용으로 잘못된 SQL문 작성
			sql = "INSERT INTO test1 VAUES ('JAMES', 30";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.executeUpdate();

			//정상적으로 작업이 완료되면 commit
			conn.commit();

			System.out.println("작업 완료");
		} catch (Exception e) {
			//예외가 발생할 경우 rollback
			try {
				conn.rollback();
				System.out.println("예외가 발생하여 데이터를 삽입하지 않습니다.");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			//자원정리
			//pstmt 사이의 정리 순서는 상관 없음
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt1, conn);
		}
	}
}
