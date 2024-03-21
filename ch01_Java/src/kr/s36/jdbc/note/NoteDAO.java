package kr.s36.jdbc.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.*;

/*
 * DAO : Data Access Object
 * 		 데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
 */

/*
 * 데이터베이스 연동 작업에서는 자원정리를 해야하기 때문에 에러를 throw 하지 않고
 * 메서드 안에서 try-catch-finally를 해주는 것이 원칙
 */


public class NoteDAO {
	//글쓰기
	public void insertInfo(String name, String passwd, String subject, String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "INSERT INTO note(num, name, passwd, subject, content, email, reg_date) VALUES (note_seq.nextval,?,?,?,?,?,SYSDATE)";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			
			//JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드를 생성
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 삽입했습니다.\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//목록 보기
	public void selectInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM note ORDER BY num DESC";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("----------------------------------------");
			
			if (rs.next()) {
				System.out.println("번호\t이름\t작성일\t\t제목");
				do {
					System.out.print(rs.getInt("num"));
					System.out.print("\t");
					System.out.print(rs.getString("name"));
					System.out.print("\t");
					System.out.print(rs.getDate("reg_date"));
					System.out.print("\t");
					System.out.println(rs.getString("subject"));
				} while (rs.next());
			} else {
				System.out.println("표시할 데이터가 없습니다.");
			}
			
			System.out.println("----------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//상세글 보기
	public void selectDetailInfo(int num) {
		
	}
	
	//글 수정
	public void updateInfo(int num, String name, String passwd, String subject, String content, String email) {
		
	}
	
	//글 삭제
	public void deleteInfo(int num) {
		
	}
}
